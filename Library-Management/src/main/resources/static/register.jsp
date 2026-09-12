
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Registration</title>
</head>

<body>

<h2>Library Book Registration</h2>

<form action="register" method="post">

    <!-- Book ID -->
    <label>Book ID:</label>
    <input type="number" name="id" required>
    <br><br>

    <!-- Book Name -->
    <label>Book Name:</label>
    <input type="text" name="bookName" required>
    <br><br>

    <!-- Author Name -->
    <label>Author Name:</label>
    <input type="text" name="authorName" required>
    <br><br>

    <!-- Category -->
    <label>Category:</label>
    <input type="text" name="category" required>
    <br><br>

    <label>Price:</label>
    <input type="number" name="price" step="0.01" required>
    <br><br>

    <button type="submit">Register Book</button>
    ${message}

</form>

</body>
</html>