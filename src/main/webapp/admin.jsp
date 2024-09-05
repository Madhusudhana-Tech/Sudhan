<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <style>
        body {
            background-color: #1a1a1a;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            color: #fff;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #222;
            border-radius: 10px;
            box-shadow: 0px 0px 20px 0px rgba(0,0,0,0.2);
        }

        h1, h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        h1 {
            font-size: 36px;
        }

        .options {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .option {
            background-color: #007bff;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
            font-size: 20px;
            text-align: center;
            width: 80%;
            transition: background-color 0.3s ease;
        }

        .option:hover {
            background-color: #0056b3;
        }

        a {
            text-decoration: none;
            color: inherit;
        }

        .option:hover a {
            color: #fff;
        }

        p {
            text-align: center;
            font-size: 16px;
            color: #ccc;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Admin Panel</h1>
        <div class="options">
            <div class="option">
                <h2><a href="addVehicle.jsp">Add Vehicle</a></h2>
                <p>Click here to add a new vehicle to the system.</p>
            </div>
            <div class="option">
                <h2><a href="updateVehicle.jsp">Update Vehicle</a></h2>
                <p>Update information or details of existing vehicles.</p>
            </div>
            <div class="option">
                <h2><a href="DeleteVehicle.jsp">Delete Vehicle</a></h2>
                <p>Delete a vehicle from the system permanently.</p>
            </div>
        </div>
    </div>
</body>
</html>