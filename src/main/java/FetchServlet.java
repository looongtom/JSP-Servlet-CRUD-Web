import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
    private final Gson gson = new Gson();
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
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            // Set up HTML table formatting for the output
            out.println("<html><body>");
            out.println("<h3>Staff Details</h3>");
            out.println("<table border=1><tr>" + "<td><b> Staff.ID </b></td>" + "<td><b>  Frist name  </b></td>"
                    + "<td><b>  Last name  </b></td>" + "<td><b> Age </b></td>"
                    + "<td><b>  Address  </b></td>" + "</td></tr>");

            // Create JDBC statement object, construct
            // the SQL query and execute the query.
            Statement stmt = conn.createStatement();
            String sql ="SELECT * FROM staff ";
            ResultSet res = stmt.executeQuery(sql);

            // Loop through the result set to
            // retrieve the individual data items.
            ArrayList<Staff>List_Staff=new ArrayList<Staff>();
            Staff tmp=new Staff();
            while (res.next()) {
                Integer id = res.getInt("staff_id");
                String firstName = res.getString("first_name");
                String lastName = res.getString("last_name");
                Integer age=res.getInt("age");
                String address=res.getString("address");
                 tmp=new Staff(id,firstName,lastName,age,address);
//                out.println("<tr>" + "<td>" + id + "</td>" +
//                        "<td>" + firstName + "</td>" +
//                        "<td>" + lastName + "</td>" +
//                        "<td>" + age + "</td>" +
//                        "<td>" + address + "</td>" +
//                        "</td></tr>");
//                List_Staff.add(tmp);

            }
            String staffJsonString=this.gson.toJson(tmp);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(staffJsonString);
            out.flush();
//            out.println("</table></body></html>");

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

