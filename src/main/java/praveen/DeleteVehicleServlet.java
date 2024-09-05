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

@WebServlet("/DeleteVehicleServlet")
public class DeleteVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve parameters from the request
            String vehicleName = request.getParameter("vehicleName");
            String model = request.getParameter("model");

            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/uniq"; 
            String username = "root"; 
            String password = "praveen@07"; 

            
            String sql = "DELETE FROM AutoMobileGarage WHERE Vehicle_Name = ? AND Model_name = ?";

            try {
               
                Connection connection = DriverManager.getConnection(url, username, password);

              
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, vehicleName);
                statement.setString(2, model);

                
                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    out.println("<html><head><title>Delete Vehicle</title></head><body>");
                    out.println("<h2>Vehicle Deleted</h2>");
                    out.println("<p>Vehicle Name: " + vehicleName + "</p>");
                    out.println("<p>Model: " + model + "</p>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><head><title>Delete Vehicle</title></head><body>");
                    out.println("<h2>No vehicle found with the provided details.</h2>");
                    out.println("</body></html>");
                }

                // Close the resources
                statement.close();
                connection.close();
            } catch (SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}