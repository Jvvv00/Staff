<%@ page import="com.utar.staff.model.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.utar.staff.model.entity.Office" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/3/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
    }
    * {
        box-sizing: border-box;
    }
</style>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">

<body class="m-3">
<!--Results content-->
<%
    String offX = request.getParameter("office.x");
    String jobX = request.getParameter("jobTitle.x");
    String keyword = (String) request.getAttribute("keyword");
    String direction = (String) request.getAttribute("direction");
%>
<div class="row col-md-6 mx-auto text-center">
    <% if (request.getParameter("office.x") != null) { %>
    <div class="text-center mb-4">
        <h1>Office's employee</h1>
    </div>
    <br>
    <form class="form-inline mr-auto mb-4"
          action="StaffListServlet" method="get">
        <input class="form-control mr-sm-2" type="text" aria-label="Search"
               name="keyword" />
        <button class="btn aqua-gradient btn-rounded btn-sm my-0 btn btn-info"
                type="submit">Search</button>
        <select class="form-control" name="direction">
            <option value="ASC">ascending</option>
            <option value="DESC">descending</option>
        </select>
        <button class="btn aqua-gradient btn-rounded btn-sm my-0 btn btn-info"
                type="submit">Sorting</button>
        <input type="hidden" name="office.x" value="<%=offX%>" />
    </form>
    <table class="table table-striped table-bordered table-sm">
        <tr>
            <th>Office ID</th>
            <th>City</th>
            <th>Employee Name</th>
        </tr>
        <%
            List<Object[]> office = (List<Object[]>) request.getAttribute("officeList");
            if (office.size() != 0) {
                for (Object[] t : office) {
                    out.println("<tr>");
                    out.println("<td>" + t[0].toString() + "</td>");
                    out.println("<td>" + t[1].toString() + "</td>");
                    out.println("<td>" + t[2].toString() + " " + t[3].toString()+ "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                String status = "No records";
                for (int i = 0; i < 3; i++) {
                    out.println("<td>" + status + "</td>");
                }
                out.println("</tr>");
            }
        %>
    </table>
    <% } else if (request.getParameter("jobTitle.x") != null) { %>
    <div class="text-center mb-4">
        <h1>Employee Job Title</h1>
    </div>
    <form class="form-inline mr-auto mb-4"
          action="StaffListServlet" method="get">
        <input class="form-control mr-sm-2" type="text" aria-label="Search"
               name="keyword" />
        <button class="btn aqua-gradient btn-rounded btn-sm my-0 btn btn-info"
                type="submit">Search</button>
        <select class="form-control" name="direction">
            <option value="ASC">ascending</option>
            <option value="DESC">descending</option>
        </select>
        <button class="btn aqua-gradient btn-rounded btn-sm my-0 btn btn-info"
                type="submit">Sorting</button>
        <input type="hidden" name="jobTitle.x" value="<%=jobX%>" />
    </form>
    <table class="table table-striped table-bordered table-sm">
        <tr>
            <th>Employee ID</th>
            <th>Job title</th>
            <th>First Name</th>
            <th>Email</th>
        </tr>
        <%
            List<Employee> staffs = (List<Employee>) request.getAttribute("jobTitleList");
            if (staffs.size() != 0) {
                for (Employee t : staffs) {
                    out.println("<tr>");
                    out.println("<td>" + t.getId() + "</td>");
                    out.println("<td>" + t.getJobtitle() + "</td>");
                    out.println("<td>" + t.getFirstname() + "</td>");
                    out.println("<td>" + t.getEmail() + "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                String status = "No records";
                for (int i = 0; i < 4; i++) {
                    out.println("<td>" + status + "</td>");
                }
                out.println("</tr>");
            }
        %>
    </table>
    <% } %>
</div>
<!--End of Result Content-->

<div class="row col-md-6 mx-auto text-left">
    <button onclick="goBack()">Go Back</button>
    <button onclick="location.href='staff.html'">Go to Staff Page</button>
</div>

<script>
    function goBack() {
        window.history.back();
    }

</script>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

</body>
</html>
