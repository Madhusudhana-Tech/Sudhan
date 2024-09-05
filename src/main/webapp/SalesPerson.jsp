<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Salesperson Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        .button-container {
            display: flex;
            justify-content: center;
        }
        .button-container button {
            background-color: #007bff;
            color: white;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            margin: 0 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button-container button:hover {
            background-color: #0056b3;
        }
        .button-container a {
            text-decoration: none;
            color: white;
            padding: 15px 30px;
            border-radius: 5px;
            margin: 0 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            background-color: #007bff;
            display: inline-block;
        }
        .button-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Salesperson Dashboard</h1>
        <div class="button-container">
            <a href="SalesPersonCustomersAttended.jsp">Number of Customers Attended</a>
            <a href="SalesPersonVehiclesSold.jsp">Number of Vehicles Sold</a>
        </div>
    </div>
</body>
</html>