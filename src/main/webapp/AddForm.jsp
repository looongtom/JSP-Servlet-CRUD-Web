
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Staff</title>
</head>
<body>
<form action="AddStaff" method="post" style="display: inline;">
    <l>First Name:</l>
    <input type="text" name="first_name" >
    <br/>

    <l>Last Name:</l>
    <input type="text" name="last_name" >
    <br/>

    <l>Age:</l>
    <input type="text" name="age" >
    <br/>

    <l>Address:</l>
    <input type="text" name="address" >
    <br/><br/><br/>
    <input type="submit" value="Save" />
</form>

<form action="home.jsp" style="display: inline;">
    <input type="submit" value="Cancel" />
</form>
</body>
</html>
