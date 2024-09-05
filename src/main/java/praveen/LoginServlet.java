package praveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String designation = request.getParameter("designation");

           
            if ("admin".equals(username) && "admin123".equals(password)) {
                
                if ("admin".equals(designation)) {
                    response.sendRedirect("admin.jsp");
                }
                else {
                    out.println("Invalid username or password for Admin. Please try again.");
                }
            }
           
            else if ("salesperson".equalsIgnoreCase(designation)) {
                  
                    if ("salesuser".equals(username) && "salespassword".equals(password)) {
                        response.sendRedirect("SalesPerson.jsp");
                    }
                    else {
                        out.println("Invalid username or password for SalesPerson. Please try again.");
                    }
            }
            else if ("Customer".equalsIgnoreCase(designation)) {
                  
                    if ("customeruser".equals(username) && "customerpassword".equals(password)) {
                        response.sendRedirect("Customer.jsp");
                    } 
            
                    else {
                        out.println("Invalid username or password for Customer. Please try again.");
                    }
            }
            else {
                        out.println("Invalid username or password for Customer. Please try again.");
                    }
                }
        
        }
    }
