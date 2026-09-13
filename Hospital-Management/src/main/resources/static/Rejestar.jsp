
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Registration</title>
</head>

<body>

<h2>Doctor Registration</h2>

<form action="registerDoctor" method="post">

    <label>Doctor ID:</label>
    <input type="number" name="id" required>
    <br><br>

    <label>Doctor Name:</label>
    <input type="text" name="name" required>
    <br><br>

    <label>Specialization:</label>
    <input type="text" name="specialization" required>
    <br><br>

    <label>Hospital Name:</label>
    <input type="text" name="hospitalName" required>
    <br><br>

    <label>Phone Number:</label>
    <input type="text" name="phoneNumber" required>
    <br><br>

    <label>Color:</label>
    <input type="text" name="color" required>
    <br><br>

    <input type="submit" value="Register Doctor">

    ${message}
    ${errorMessage}


</form>

</body>
</html>
