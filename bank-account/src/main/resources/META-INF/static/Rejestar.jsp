
<html>
<head>
    <meta charset="UTF-8">
    <title>Debit Account Registration</title>
</head>
<body>

<h2>Debit Account Registration</h2>

<form action="bank" method="post">

    <label>Account ID:</label>
    <input type="number" name="id" required>
    <br><br>

    <label>Bank Name:</label>
    <input type="text" name="bankName" required>
    <br><br>

    <label>Balance:</label>
    <input type="number" name="balance" step="0.01" required>
    <br><br>

    <label>Account Number:</label>
    <input type="text" name="accountNumber" required>
    <br><br>

    <label>Account Holder Name:</label>
    <input type="text" name="accountHolderName" required>
    <br><br>

    <input type="submit" value="Register">

</form>
${message}

</body>
</html>