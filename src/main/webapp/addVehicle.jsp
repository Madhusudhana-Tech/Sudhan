<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Vehicle</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Vehicle</h2>
        <form action="AddVehicleServlet" method="post" onsubmit="return validateForm()">
            <label for="vehicleName">Vehicle Name:</label>
            <input type="text" id="vehicleName" name="vehicleName" required><br><br>
            
            <label for="modelName">Model:</label>
            <input type="text" id="modelName" name="modelName" required><br><br>
            
            <label for="year">Year:</label>
            <input type="text" id="year" name="year" required><br><br>
            
            <label for="color">Color:</label>
            <input type="text" id="color" name="color" required><br><br>
            
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" required><br><br>
            
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>

    <script>
        function validateForm() {
            var vehicleName = document.getElementById("vehicleName").value;
            var modelName = document.getElementById("modelName").value;
            var year = document.getElementById("year").value;
            var color = document.getElementById("color").value;
            var price = document.getElementById("price").value;

            if (vehicleName === "" || modelName === "" || year === "" || color === "" || price === "") {
                alert("Please fill in all fields.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>