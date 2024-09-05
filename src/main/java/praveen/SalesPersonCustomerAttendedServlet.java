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

@WebServlet("/SalesPersonCustomerAttendedServlet")
public class SalesPersonCustomerAttendedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action != null && action.equals("saveCustomersAttended")) {
                int numCustomers = Integer.parseInt(request.getParameter("numCustomers"));
                saveCustomersAttended(numCustomers, out);
            } else {
                out.println("Invalid action!");
            }
        }
    }

    private void saveCustomersAttended(int numCustomers, PrintWriter out) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniq", "root", "praveen@07");
            String sql = "INSERT INTO SalespersonCustomersAttended (NumCustomers) VALUES (?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numCustomers);

            int result = stmt.executeUpdate();
            if (result == 1) {
                out.println("Number of customers attended saved successfully!");
            } else {
                out.println("Failed to save number of customers attended.");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}