<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>List Order</title>
</head>
<body>
<center>
  <table border="1">
    <tr>
      <th>Order ID</th>
      <th>Order name</th>
      <th>Order price</th>
      <th>Staff ID</th>
      <th>Action</th>
    </tr>

    <%
      try{
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/NHOM15",
                "postgres","tr1nhtu@n");
        Statement st=con.createStatement();
        String str="select * from orders ORDER BY staff_id ASC";
        ResultSet rs=st.executeQuery(str);
        while(rs.next()){
    %>
    <tr>
      <td><%=rs.getInt("order_id")%></td>
      <td><%=rs.getString("order_name")%></td>
      <td><%=rs.getInt("order_price")%></td>
      <td><%=rs.getInt("staff_id")%></td>
      <td >
        <form action="UpdateOrder.jsp"  method ="post"  >
          <input type="hidden" name="order_id" value=<%=rs.getInt("order_id")%>>
          <input type="hidden" name="order_name" value=<%=rs.getString("order_name")%>>
          <input type="hidden" name="order_price" value=<%=rs.getInt("order_price")%>>
          <input type="hidden" name="staff_id" value=<%=rs.getInt("staff_id")%>>
          <input type="submit" value=" Edit "/>
        </form></td>

      <td ><form action="DeleteOrder" method="post">
        <input type="hidden" name="order_id" value=<%=rs.getInt("order_id")%>>
        <input  type="submit" value=" Delete "z />
      </form></td>


    </tr>
    <% }

    }catch (Exception e){

    }
    %>
  </table>
  <form action="home.jsp" style="display: inline;">
    <input type="submit" value="Back" />
  </form>

</center>
</body>
</html>
