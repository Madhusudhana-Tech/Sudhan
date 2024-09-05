<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login to X Automobile Garage</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
       
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 350px;
            padding: 30px;
            border-radius: 10px;
            background-color: #ffffff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
            color: #333333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555555;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .footer {
            margin-top: 20px;
            text-align: center;
            color: #777777;
        }

        /* Application name styling */
        .app-name {
            text-align: center;
            margin-bottom: 30px;
        }

        .app-name h2 {
            font-size: 2.5em;
            color: #007bff; /* Your desired color */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); /* Text shadow effect */
            letter-spacing: 2px; /* Increased letter spacing for emphasis */
            font-family: 'Arial Black', sans-serif; /* Font family with emphasis */
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Application name -->
        <div class="app-name">
            <h2>X Automobile Garage</h2>
        </div>

    
        <form action="LoginServlet" method="Post">
            <label for="username">UserName:</label>
            <input type="text" id="username" name="username" >
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" >
            
            <label for="designation">Designation:</label>
            <select id="dropdown" name="designation">
                <option value="admin">Admin</option>
                <option value="salesperson">SalesPerson</option>
                <option value="customer">Customer</option> <!-- New option for customer -->
            </select>
            
            <input type="submit" value="Login">
        </form>
        
       
        <a href="forgot_password.jsp">Forgot Password?</a>
        
        
        <p>Don't have an account? <a href="signup.jsp">Create New Account</a></p>
        
        
        <div class="footer">
            &copy; 2024 X Automobile Garage. All rights reserved.
        </div>
        
       
        <div class="top-right">
            <a href="menu.jsp">&#9776;</a>
            <a href="logout.jsp">Logout</a>
        </div>
    </div>
</body>
</html>