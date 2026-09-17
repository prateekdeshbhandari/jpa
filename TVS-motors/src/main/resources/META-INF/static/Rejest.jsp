<!DOCTYPE html>
<html>
<head>
    <title>TVS Motors Registration</title>
</head>
<body>

<h2>TVS Motors Details</h2>

<form action="TVS" method="post">

    <label>Model Name:</label>
    <input type="text" name="modelName" required>
    <br><br>

    <label>Brand:</label>
    <input type="text" name="brand" required>
    <br><br>

    <label>Category:</label>
    <input type="text" name="category" required>
    <br><br>

    <label>Price:</label>
    <input type="number" name="price" step="0.01" required>
    <br><br>

    <input type="submit" value="Register">

</form>
${message}
<a href="read.jsp">View Registered Motors</a>
</body>
</html>