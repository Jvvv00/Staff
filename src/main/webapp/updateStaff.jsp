<%@ page import="com.utar.staff.model.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/4/2023
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
    table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    }
    td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    }
    tr:nth-child(even) {
    background-color: #dddddd;
    }
    </style>
</head>
<body>
<%
    Employee emp = (Employee) request.getAttribute("EMP");
%>
<h1>Update details</h1>
<form action="StaffController" method="post">
    <table>
        <tr>
            <td>Employee ID</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"id\" readonly value=" + emp.getId());
                %>
            </td>
        </tr>
        <tr>
            <td>First Name</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"firstname\" value=" + emp.getFirstname());
                %>
            </td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"lastname\" value=" + emp.getLastname());
                %>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"email\" value=" + emp.getEmail());
                %>
            </td>
        </tr>
        <tr>
            <td>Job Title</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"jobtitle\" value=" + emp.getJobtitle());
                %>
            </td> </tr>
        <tr>
            <td>Extension</td>
            <td>
                <%
                    out.println("<input type=\"text\" name=\"extension\" value=" + emp.getExtension());
                %>
            </td>
        </tr>
    </table>
    <input type="submit" name="UPDATE" value="UPDATE" />
    <input type="submit" name="DELETE" value="DELETE" />
</form>
</body>
</html>
