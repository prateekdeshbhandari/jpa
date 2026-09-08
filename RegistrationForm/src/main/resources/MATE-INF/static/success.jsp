
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>


<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.html">My Website</a>

        <div>
            <a href="index.html" class="text-white me-3">Home</a>
            <a href="Registration.jsp" class="text-white">Registration</a>
        </div>
    </div>
</nav>


<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card">
                <div class="card-header bg-success text-white text-center">
                    <h3>Registration Successful!</h3>
                </div>

                <div class="card-body">

                    <p><b>Name:</b> ${name}</p>

                    <p><b>Email:</b> ${email}</p>

                    <p><b>Password:</b> ${password}</p>

                    <p><b>Phone:</b> ${phone}</p>



                </div>
            </div>

        </div>
    </div>
</div>


<footer class="bg-dark text-white text-center p-3 mt-5">
    <p class="mb-0"> X-workz</p>
</footer>

</body>
</html>