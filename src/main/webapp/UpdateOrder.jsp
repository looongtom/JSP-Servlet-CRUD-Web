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
    <title>UPDATE ORDER</title>
</head>
<body>
<tr>
    <%
        int order_id = Integer.valueOf(request.getParameter("order_id"));
        String order_name=request.getParameter("order_name");
        int order_price = Integer.valueOf(request.getParameter("order_price"));
        int staff_id = Integer.valueOf(request.getParameter("staff_id"));
    %>
    <td ><form method ="post" action="UpdateOrder" style="display: inline;" >
        <input type="hidden" name="order_id" value=<%=order_id%>>
        <p>Order Name:</p>
        <input type="text" name="order_name" value=<%=order_name%>>
        <br>
        <p>Order Price:</p>
        <input type="text" name="order_price" value=<%=order_price%>>
        <br>
        <input type="submit" value="Save"/>
    </form></td>
    <form action="home.jsp" style="display: inline;">
        <input type="submit" value="Cancel" />
    </form>

</tr>


</body>
</html>
