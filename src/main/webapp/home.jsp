<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%--    <meta charset="ISO-8859-1">--%>
    <title>Home Page</title>
</head>
<body>
<center>
    <br>
    <form action="AddForm.jsp" style="display: inline;">
        <input type="submit" value="Add new Staff" />
    </form>
    <form action="ListOrder.jsp" style="display: inline;">
        <input type="submit" value="Order details" />
    </form>


    <table border="1">
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Action</th>
        </tr>

        <%
            try{
                Class.forName("org.postgresql.Driver");
                Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/NHOM15",
                        "postgres","tr1nhtu@n");
                Statement st=con.createStatement();
                String str="select * from staff ORDER BY staff_id ASC ";
                ResultSet rs=st.executeQuery(str);
                while(rs.next()){
        %>
        <tr>
            <td><%=rs.getInt("staff_id")%></td>
            <td><%=rs.getString("first_name")%></td>
            <td><%=rs.getString("last_name")%></td>
            <td><%=rs.getInt("age")%></td>
            <td><%=rs.getString("address")%></td>
            <td ><form action="Details" method="get">
                <input type="hidden" name="staff_id" value=<%=rs.getInt("staff_id")%>>
                <input  type="submit" value=" Details " />
            </form></td>

            <td >
                <form action="UpdateForm.jsp"  method ="post"  >
                    <input type="hidden" name="first_name" value=<%=rs.getString("first_name")%>>
                    <input type="hidden" name="last_name" value=<%=rs.getString("last_name")%>>
                    <input type="hidden" name="age" value=<%=rs.getInt("age")%>>
                    <input type="hidden" name="address" value=<%=rs.getString("address")%>>
                    <input type="hidden" name="staff_id" value=<%=rs.getInt("staff_id")%>>
                    <input type="submit" value=" Edit "/>
                </form></td>

            <td ><form action="DeleteStaff" method="post">
                <input type="hidden" name="staff_id" value=<%=rs.getInt("staff_id")%>>
                <input  type="submit" value=" Delete " />
            </form></td>

            <td ><form action="AddOrder.jsp" method="post">
                <input type="hidden" name="staff_id" value=<%=rs.getInt("staff_id")%>>
                <input  type="submit" value=" Add order " />
            </form></td>
        </tr>
        <% }

        }catch (Exception e){
        }
        %>
    </table>


</center>
</body>
</html>