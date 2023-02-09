import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
import java.util.stream.Collectors;

@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {
    private Gson gson = new Gson();
    private Staff staff;
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
//        String body = request.getReader().lines().collect(Collectors.joining());
//        JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
        try {

            // Set the response content type and
            // get the PrintWriter object.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


//            Statement stmt = conn.createStatement();
            String sql ="INSERT INTO staff (first_name, last_name, age, address) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt=conn.prepareStatement(sql.toString());
//            stmt.setInt( 1, Integer.valueOf( request.getParameter("staff_id") ) );
            stmt.setString( 1, request.getParameter("first_name") );
            stmt.setString(2, request.getParameter("last_name") );
            stmt.setInt(3, Integer.valueOf(request.getParameter("age" ) ) );
            stmt.setString(4, request.getParameter("address") );
            stmt.executeUpdate();


//            out.println("<html><body><b>Successfully Inserted"
//                    + "</b></body></html>");


            RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/home.jsp");
            RequetsDispatcherObj.forward(request, response);

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

/*
st.setInt( 1, Integer.valueOf( request.getParameter("staff_id") ) );
            st.setString( 2, request.getParameter("first_name") );
            st.setString(3, request.getParameter("last_name") );
            st.setInt(4, Integer.valueOf(request.getParameter("age" ) ) );
            st.setString(5, request.getParameter("address") );

 */