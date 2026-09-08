
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>


<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#"></a>

        <div>
            <a href="index.html" class="text-white me-3">Home</a>
            <a href="Registration.jsp" class="text-white">Registration</a>
        </div>
    </div>
</nav>


<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">

            <h2 class="text-center mb-4">Registration Form</h2>

            <form action="register" method="post">

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name"
                           class="form-control"
                           placeholder="Enter Name"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email"
                           class="form-control"
                           placeholder="Enter Email"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password"
                           class="form-control"
                           placeholder="Enter Password"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input type="text" name="phone"
                           class="form-control"
                           placeholder="Enter Phone Number"
                           required>
                </div>

                <button type="submit" class="btn btn-primary w-100">
                    Submit
                </button>

            </form>

        </div>
    </div>
</div>

<footer class="bg-dark text-white text-center p-3 mt-5">
    <p class="mb-0"> X-workz</p>
</footer>

</body>
</html>