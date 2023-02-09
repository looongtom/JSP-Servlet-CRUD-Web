import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/UpdateStaff")
public class UpdateStaff extends HttpServlet {


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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init();
        try {

            // Set the response content type and
            // get the PrintWriter object.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


//            Statement stmt = conn.createStatement();
            String sql ="UPDATE staff SET first_name = ?, last_name = ?, age = ?, address = ? WHERE staff_id = ?";
            PreparedStatement stmt=conn.prepareStatement(sql.toString());
//            stmt.setInt( 1, Integer.valueOf( request.getParameter("staff_id") ) );
            stmt.setString( 1, request.getParameter("first_name") );
            stmt.setString(2, request.getParameter("last_name") );
            stmt.setInt(3, Integer.valueOf(request.getParameter("age" ) ) );
            stmt.setString(4, request.getParameter("address") );
            stmt.setInt( 5, Integer.valueOf(request.getParameter("staff_id" ) ) );
            stmt.executeUpdate();

            out.println("<html><body><b>Successfully Updated"
                    + "</b></body></html>");

            RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/home.jsp");
            RequetsDispatcherObj.forward(request, response);
            // Close Result set, Statement
            // and PrintWriter objects.
            out.close();
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
