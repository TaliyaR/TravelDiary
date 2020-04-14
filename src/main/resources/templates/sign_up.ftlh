<!DOCTYPE html>
<html lang="en">
<head>
    <link href="sign_up.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                            <!-- Background image for card set in CSS! -->
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">Регистрация</h5>
                            <form class="form-signin" action="/signUp" method="post">
                                <div class="form-label-group">
                                    <input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required autofocus>
                                    <label for="inputUsername">Username</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="text" id="firstName" name="firstName" class="form-control" placeholder="Имя" required autofocus>
                                    <label for="firstName">Имя</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Фамилия" required autofocus>
                                    <label for="lastName">Фамилия</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="email" id="inputEmail"  name="email" class="form-control" placeholder="Email" required>
                                    <label for="inputEmail">Email</label>
                                </div>

                                <hr>

                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required>
                                    <label for="inputPassword">Password</label>
                                </div>

                                <button class="btn btn-lg btn-register btn-block text-uppercase" type="submit">Зарегистрироваться</button>
                                <a class="d-block text-center mt-2 small text-col" href="/signIn">Войти</a>
                                <hr class="my-4">
                                <button class="btn btn-lg btn-danger btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Войти через Google</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>