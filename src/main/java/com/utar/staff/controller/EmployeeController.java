package com.utar.staff.controller;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.sessionbean.EmployeeSessionBeanLocal;
import com.utar.staff.utilities.ValidateManageLogic;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {

    @EJB
    private EmployeeSessionBeanLocal empbean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("employeenumber");
        try {
            Employee emp = empbean.findEmployee(id);
            request.setAttribute("EMP", emp);
            RequestDispatcher req = request.getRequestDispatcher("results.jsp");
            req.forward(request, response);
        } catch (EJBException ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("employeenumber");
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        PrintWriter out = response.getWriter();
        // this line is to package the whole values into one array string variable -
        // easier just pass one parameter object
        String[] s = { eid, fname, lname };

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
            // this line is to redirect to notify record has been updated and redirect to
            // another page
            ValidateManageLogic.navigateJS(out);
        } catch (EJBException ex) {
        }
    }
}
