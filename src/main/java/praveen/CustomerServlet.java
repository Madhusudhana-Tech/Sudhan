package praveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action != null && action.equals("Register")) {
                registerCustomer(request, out);
            } else {
                out.println("Invalid action!");
            }
        }
    }

    private void registerCustomer(HttpServletRequest request, PrintWriter out) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String vehicle = request.getParameter("vehicle");
        String payment = request.getParameter("payment");
        String feedback = request.getParameter("feedback");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniq", "root", "praveen@07");
            String sql = "INSERT INTO Customer (Name, Email, Password, Vehicle, Payment_Method, Feedback) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, vehicle);
            stmt.setString(5, payment);
            stmt.setString(6, feedback);

            int result = stmt.executeUpdate();
            if (result == 1) {
                out.println("Customer registered successfully!");
            } else {
                out.println("Failed to register customer.");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}