<%@ page import="com.utar.staff.model.entity.Employee" %>
<%@ page import="java.util.List" %><%--
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
    /* Button used to open the contact form - fixed at the bottom of the page */
    .open-button {
        background-color: #555;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        opacity: 0.8;
        position: fixed;
        bottom: 23px;
        right: 28px;
        width: 280px;
    }
    /* The popup form - hidden by default */
    .form-popup {
        overflow-x: hidden;
        overflow-y: auto;
        height: 400px;
        display: none;
        position: fixed;
        top: 60%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
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
    /* Add a red background color to the cancel button */
    .form-container .cancel {
        background-color: red;
    }
    /* Add some hover effects to buttons */
    .form-container .btn:hover, .open-button:hover {
        opacity: 1;
    }
    .pageref {
        text-align: center;
        font-weight: bold;
    }
</style>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<body>
<div class="row col-md-6">
    <table class="table table-striped table-bordered table-sm">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
<%
    List<Employee> staffs = (List<Employee>) request.getAttribute("staffs");
    for (Employee t : staffs) {
        out.println("<tr>");
        out.println("<td>" + t.getId() + "</td>");
        out.println("<td>" + t.getFirstname() + "</td>");
        out.println("<td>" + t.getLastname() + "</td>");
        out.println("<td><a href=\"EmployeeController?id=" + t.getId() + "\">Update</a></td>");
        out.println("<td><a href=\"EmployeeController?id=" + t.getId() + "\">Delete</a></td>");
        out.println("</tr>");
    }
%>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
<button class="open-button" onclick="openForm()">Open Form</button>
<div class="form-popup" id="myForm">
    <form action="EmployeeController" class="form-container" method="post">
        <h1>Add Employee</h1>
        <fieldset>
            <legend>Add Employee Details:</legend>
            <br> First Name:
            <input type="text" name="fname" /> <br>
            Last Name: <input type="text" name="lname" /> <br>
        </fieldset>

        <button type="submit" class="btn">Submit Test</button>
        <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        <button type="reset" class="btn">Reset</button>
    </form>
</div>
<script>
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }
    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }
</script>

</body>
</html>
