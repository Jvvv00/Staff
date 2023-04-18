package com.utar.staff.controller;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.entity.Office;
import com.utar.staff.model.entity.User;
import com.utar.staff.model.sessionbean.StaffSessionBeanLocal;

import javax.ejb.EJB;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @PersistenceContext(unitName = "Staff")
    EntityManager em;
    @EJB
    private StaffSessionBeanLocal empbean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = getUserFromDatabase(username, password);
        if (user != null) {
            List<Employee> employees = empbean.getAllEmployees();
            List<Office> offices = empbean.getAllOffice();
            HttpSession session = request.getSession();
            session.setAttribute("employees", employees);
            session.setAttribute("offices", offices);
            response.sendRedirect("manageStaff.jsp");
        }
        else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Incorrect username or password');");
            out.println("location='staffLogin.html';");
            out.println("</script>");
        }
    }
    private User getUserFromDatabase(String username, String password) {
        User user = null;

        try {
            Query q = em.createNativeQuery("SELECT * FROM classicmodels.users u WHERE u.username = :username AND u.password = :password", User.class);
            q.setParameter("username", username);
            q.setParameter("password", password);

            user = (User) q.getSingleResult();
        } catch (NoResultException e) {

        }
        return user;
    }
}
