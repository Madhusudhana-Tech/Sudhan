
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

@WebServlet("/updateVehicle")
public class UpdateVehicleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String vehicleName = request.getParameter("vehicleName");
            String model = request.getParameter("model");
            int year = Integer.parseInt(request.getParameter("year"));
            String color = request.getParameter("color");
            int price = Integer.parseInt(request.getParameter("price"));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniq", "root",
                        "praveen@07");
                String sql = "UPDATE AutoMobileGarage SET Model_name=?, Year=?, Color=?, Price=? WHERE Vehicle_Name=?";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, model);
                stmt.setInt(2, year);
                stmt.setString(3, color);
                stmt.setInt(4, price);
                stmt.setString(5, vehicleName);
                
                int result = stmt.executeUpdate();
                if (result == 1) {
                    out.println("Vehicle updated successfully!");
                } else {
                    out.println("Failed to update vehicle.");
                }
                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}