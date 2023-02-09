import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:postgresql://localhost:5432/NHOM15";
    private static final String USER = "postgres";
    private static final String PASSWORD = "tr1nhtu@n";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection conn = null;

    public void init() throws ServletException {

        // Database connection through Driver Manager
        try {
            Class.forName( "org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        try {

            // Set the response content type and
            // get the PrintWriter object.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Set up HTML table formatting for the output
            out.println("<html><body>");
            out.println("<h3>Order Details</h3>");
            out.println("<table border=1><tr>" + "<td><b>Order Id</b></td>" +
                    "<td><b>  Order name  </b></td>"+
                    "<td><b>  First name  </b></td>"+
                     "<td><b>  Last name  </b></td>" +
                    "<td><b>Staff Id</b></td>"+
                     "<td><b>Order Price</b></td>" +
                    "</td></tr>");

            // Create JDBC statement object, construct
            // the SQL query and execute the query.
            Statement stmt = conn.createStatement();
            String sql ="select orders.order_id,orders.order_name,staff.first_name,staff.last_name,staff.staff_id,orders.order_price from orders inner join staff on orders.staff_id=staff.staff_id ";
            ResultSet res = stmt.executeQuery(sql);

            // Loop through the result set to
            // retrieve the individual data items.
            while (res.next()) {
                Integer orderId=res.getInt("order_id");
                String orderName=res.getString("order_name");
                String firstName=res.getString("first_name");
                String lastName=res.getString("last_name");
                Integer staffId=res.getInt("staff_id");
                Integer orderPrice=res.getInt("order_price");

                out.println("<tr>" + "<td>" + orderId + "</td>" +
                        "<td>" + orderName + "</td>" +
                        "<td>" + firstName + "</td>" +
                        "<td>" + lastName + "</td>" +
                        "<td>" + staffId + "</td>" +
                        "<td>" + orderPrice + "</td>" +
                        "</td></tr>");

            }
            out.println("</table></body></html>");

            // Close Result set, Statement
            // and PrintWriter objects.
            res.close();
            stmt.close();
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {

        // Close connection object.
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

