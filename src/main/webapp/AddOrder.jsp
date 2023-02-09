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
    <title>ADD ORDER</title>
</head>
<body>


<tr>
    <% int staff_id = Integer.valueOf(request.getParameter("staff_id")); %>
    <td ><form method ="post" action="AddOrder" style="display: inline;" >
        <l>Order name:</l>
        <input type="text" name="order_name" >
        <br/>
        <l>Order price:</l>
        <input type="text" name="order_price" >
        <br/>
        <input type="hidden" name="staff_id" value=<%=staff_id%>>
        <input type="submit" value="Save"/>
    </form></td>
    <form action="home.jsp" style="display: inline;">
        <input type="submit" value="Cancel" />
    </form>

</tr>


</body>
</html>
