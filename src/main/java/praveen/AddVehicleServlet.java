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

@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String vehicleName = request.getParameter("vehicleName");
            String modelName = request.getParameter("modelName");
            int year = Integer.parseInt(request.getParameter("year"));
            String color = request.getParameter("color");
            int price = Integer.parseInt(request.getParameter("price"));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniq", "root",
                        "praveen@07");
                String sql = "INSERT INTO AutoMobileGarage (Vehicle_Name, Model_name, Year, Color, Price) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, vehicleName);
                stmt.setString(2, modelName);
                stmt.setInt(3, year);
                stmt.setString(4, color);
                stmt.setInt(5, price);

                int result = stmt.executeUpdate();
                if (result == 1) {
                    out.println("Vehicle added successfully!");
                } else {
                    out.println("Failed to add vehicle.");
                }
                con.close();
            } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}