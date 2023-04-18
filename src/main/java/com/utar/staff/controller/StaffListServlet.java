package com.utar.staff.controller;

import com.utar.staff.model.entity.Employee;
import com.utar.staff.model.sessionbean.StaffSessionBeanLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffListServlet", value = "/StaffListServlet")
public class StaffListServlet extends HttpServlet {
    @EJB
    private StaffSessionBeanLocal empbean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String office = request.getParameter("office.x");
        String job = request.getParameter("jobTitle.x");
        String keyword = request.getParameter("keyword");
        String direction = request.getParameter("direction");
        if(office != null){
            List<Object[]> lists = empbean.readOfficeEmp(keyword, direction);
            request.setAttribute("officeList", lists);
            request.setAttribute("keyword", keyword);
            request.setAttribute("office.x", office);
            request.setAttribute("direction", direction);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStaffResult.jsp");
            dispatcher.forward(request, response);
        }
        else if(job != null){
            List<Employee> lists = empbean.readJob(keyword, direction);
            request.setAttribute("jobTitleList", lists);
            request.setAttribute("keyword", keyword);
            request.setAttribute("jobTitle.x", job);
            request.setAttribute("direction", direction);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewStaffResult.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
