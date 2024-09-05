
package praveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalesPersonServlet")
public class SalesPersonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "customersAttended":
                        int customersAttended = getCustomersAttended();
                        out.println("Number of Customers Attended: " + customersAttended);
                        break;
                    case "vehiclesSold":
                        int vehiclesSold = getVehiclesSold();
                        out.println("Number of Vehicles Sold: " + vehiclesSold);
                        break;
                    default:
                        out.println("Invalid action!");
                        break;
                }
            } else {
                out.println("No action specified!");
            }
        }
    }

    private int getCustomersAttended() {
        // Logic to retrieve number of customers attended
        // Implement your database query here
        return 0; // Placeholder for demonstration
    }

    private int getVehiclesSold() {
        // Logic to retrieve number of vehicles sold
        // Implement your database query here
        return 0; // Placeholder for demonstration
    }
}