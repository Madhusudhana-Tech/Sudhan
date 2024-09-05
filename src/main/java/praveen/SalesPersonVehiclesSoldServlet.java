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

@WebServlet("/SalesPersonVehiclesSoldServlet")
public class SalesPersonVehiclesSoldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String numVehiclesStr = request.getParameter("numVehicles");
            if (numVehiclesStr != null && !numVehiclesStr.isEmpty()) {
                try {
                    int numVehicles = Integer.parseInt(numVehiclesStr);

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniq", "root", "praveen@07");
                    String sql = "INSERT INTO VehiclesSold (NumVehicles) VALUES (?)";

                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, numVehicles);

                    int result = stmt.executeUpdate();
                    if (result == 1) {
                        out.println("Number of vehicles sold successfully recorded!");
                    } else {
                        out.println("Failed to record number of vehicles sold.");
                    }
                    con.close();
                } catch (NumberFormatException e) {
                    out.println("Error: Number of vehicles must be an integer.");
                } catch (ClassNotFoundException | SQLException e) {
                    out.println("Error: " + e.getMessage());
                }
            } else {
                out.println("Error: Number of vehicles parameter is missing.");
            }
        }
    }
}