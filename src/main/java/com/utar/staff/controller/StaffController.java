package com.utar.staff.controller;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.sessionbean.StaffSessionBeanLocal;
import com.utar.staff.utilities.ValidateManageLogic;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StaffController", value = "/StaffController")
public class StaffController extends HttpServlet {

    @EJB
    private StaffSessionBeanLocal empbean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Employee emp = empbean.findEmployee(id);
            request.setAttribute("EMP", emp);
            RequestDispatcher req = request.getRequestDispatcher("updateStaff.jsp");
            req.forward(request, response);
        } catch (EJBException ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eid = request.getParameter("id");
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String jobtitle = request.getParameter("jobtitle");
        String extension = request.getParameter("extension");
        String offcode = request.getParameter("officecode");
        String reportsto = request.getParameter("reportsto");
        PrintWriter out = response.getWriter();
        String[] s = { eid, fname, lname, extension, email, jobtitle, offcode, reportsto };

        try {
            if (ValidateManageLogic.validateManager(request).equals("UPDATE")) {
                // call session bean updateEmployee method
                empbean.updateEmployee(s);

            }
            else if (ValidateManageLogic.validateManager(request).equals("DELETE")) {
                // call session bean deleteEmployee method
                empbean.deleteEmployee(eid);
                // if ADD button is clicked
            } else {
                // call session bean addEmployee method
                empbean.addEmployee(s);
            }
            List<Employee> employees = empbean.getAllEmployees();
            HttpSession session = request.getSession();
            session.setAttribute("employees", employees);
            response.sendRedirect("manageStaff.jsp");

        } catch (EJBException ex) {
            String errorMessage = ex.getMessage();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('" + errorMessage + "')");
            out.println("window.location.href = 'manageStaff.jsp';");
            out.println("</script>");
        }

    }
}
