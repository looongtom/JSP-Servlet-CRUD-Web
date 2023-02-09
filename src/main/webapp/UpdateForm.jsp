<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 11/13/2022
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>UPDATE FORM</title>
</head>
<body>

<tr>
    <%
        String first_name=request.getParameter("first_name");
        String last_name=request.getParameter("last_name");
        int age = Integer.valueOf(request.getParameter("age"));
        String address=request.getParameter("address");
        int staff_id = Integer.valueOf(request.getParameter("staff_id"));

    %>
    <td ><form method ="post" action="UpdateStaff" style="display: inline;" >
        <p>First Name:</p>
        <input type="text" name="first_name" value=<%=first_name%>>
        <br>
        <p>Last Name:</p>
        <input type="text" name="last_name" value=<%=last_name%>>
        <br>
        <p>Age:</p>
        <input type="text" name="age" value=<%=age%>>
        <br>
        <p>Address:</p>
        <input type="text" name="address" value=<%=address%>>
        <br>
        <input type="hidden" name="staff_id" value=<%=staff_id%>>
        <br>
        <input type="submit" value="Edit"/>
    </form></td>
    <form action="home.jsp" style="display: inline;">
        <input type="submit" value="Cancel" />
    </form>

</tr>


</body>
</html>
