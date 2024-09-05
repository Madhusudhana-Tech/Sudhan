<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
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
        input[type="text"], select {
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
        <h2>Customer Registration</h2>
        <form action="CustomerServlet" method="post" onsubmit="return validateForm()">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>
            
            <!-- Add other fields like email, password, buying a vehicle, payment method, and feedback -->
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br><br>
            
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" required><br><br>

            <label for="vehicle">Buying a Vehicle:</label>
            <select id="vehicle" name="vehicle" required>
                <option value="">Select Vehicle Type</option>
                <option value="Two wheeler">Two wheeler</option>
                <option value="Car">Car</option>
                <option value="Bus">Bus</option>
                <option value="Lorry">Lorry</option>
            </select><br><br>

            <label for="payment">Payment Method:</label>
            <select id="payment" name="payment" required>
                <option value="">Select Payment Method</option>
                <option value="Cash">Cash</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Net Banking">Net Banking</option>
            </select><br><br>

            <label for="feedback">Feedback:</label>
            <textarea id="feedback" name="feedback" required></textarea><br><br>

            <input type="submit" name="action" value="Register">
        </form>
    </div>

    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var vehicle = document.getElementById("vehicle").value;
            var payment = document.getElementById("payment").value;
            var feedback = document.getElementById("feedback").value;

            if (name === "" || email === "" || password === "" || vehicle === "" || payment === "" || feedback === "") {
                alert("Please fill in all fields.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>