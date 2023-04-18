<%@ page import="com.utar.staff.model.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="com.utar.staff.model.sessionbean.StaffSessionBeanLocal" %>
<%@ page import="com.utar.staff.model.sessionbean.StaffSessionBean" %>
<%@ page import="com.utar.staff.model.entity.Office" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/4/2023
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }
        * {
            box-sizing: border-box;
        }
        /* Add styles to the form container */
        .form-container {
            max-width: 500px;
            padding: 10px;
            background-color: white;
        }
        /* Full-width input fields */
        .form-container input[type=text], .form-container input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
        }
        /* When the inputs get focus, do something */
        .form-container input[type=text]:focus, .form-container input[type=password]:focus
        {
            background-color: #ddd;
            outline: none;
        }
        /* Set a style for the submit button */
        .form-container .btn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            margin-bottom: 10px;
            opacity: 0.8;
        }

        /* Add some hover effects to buttons */
        .form-container .btn:hover:hover {
            opacity: 1;
        }
    </style>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body class="m-3">
<div>
    <div class="text-center mt-4 mb-4">
        <h2>Employee's Detail</h2>
    </div>
    <table class="table table-striped table-bordered">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Extension</th>
            <th>Job Title</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <% List<Employee> employees = (List<Employee>) session.getAttribute("employees");
            for (Employee t : employees) {
                out.println("<tr>");
                out.println("<td>" + t.getId()+ "</td>");
                out.println("<td>" + t.getFirstname() + " " + t.getLastname() + "</td>");
                out.println("<td>" + t.getEmail() + "</td>");
                out.println("<td>" + t.getExtension() + "</td>");
                out.println("<td>" + t.getJobtitle() + "</td>");
                out.println("<td><a href=\"StaffController?id=" + t.getId() + "\">Update</a></td>");
                out.println("<td><a href=\"StaffController?id=" + t.getId() + "\">Delete</a></td>");
                out.println("</tr>");
            }
        %>
    </table>
</div>

<hr>
<div>
    <h3>Add new employee</h3>
    <form action="StaffController" class="form-container" method="post">
        <fieldset>
            <legend>Details: </legend>
            <br>
            ID: <input type="text" name="id" required/>
            <br>
            First Name: <input type="text" name="firstname" required/>
            <br>
            Last Name: <input type="text" name="lastname" required/>
            <br>
            Extension: <input type="text" name="extension" required/>
            <br>
            Email: <input type="text" name="email" required/>
            <br>
            Job Title: <input type="text" name="jobtitle" required/>
            <br>
            Office Code:
            <select name="officecode">
                <%
                    List<Office> offices = (List<Office>) session.getAttribute("offices");// get offices from database
                    for (Office office : offices) {
                        out.println("<option value=\"" + office.getId() + "\">" + office.getId() + "</option>");
                    }
                %>
            </select>

            <br>
            Reports To: <input type="text" name="reportsto" />

        </fieldset>
        <button type="submit" class="btn">Submit</button>
        <button type="reset" class="btn">Reset</button>
    </form>
</div>

</body>
</html>