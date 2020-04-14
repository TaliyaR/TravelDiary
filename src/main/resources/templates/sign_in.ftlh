<!doctype html>
<html lang="en">
<head>
    <link href="sign_in.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Вход</title>
</head>
    <body>
    <#--<a href="/signUp">SignUp</a>-->
    <#--<a href="https://accounts.google.com/o/oauth2/auth?redirect_uri=http%3A%2F%2Fmysite.com%2Fgglogin&response_type=code&client_id={client_id}&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile"-->
    <#--   title="Войти через Google">Войти через Google</a>-->
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
                <div class="col-md-8 col-lg-6">
                    <div class="login d-flex align-items-center py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-9 col-lg-8 mx-auto">
                                    <h3 class="login-heading mb-4">Добро пожаловать!</h3>
                                    <form action="/signIn" method="post">
                                        <div class="form-label-group">
                                            <input type="username" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
                                            <label for="username">Username</label>
                                        </div>

                                        <div class="form-label-group">
                                            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required>
                                            <label for="inputPassword">Пароль</label>
                                        </div>

                                        <div class="custom-control custom-checkbox mb-3">
                                            <input type="checkbox" class="custom-control-input container input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">Запомнить пароль</label>
                                        </div>
                                        <button class="btn btn-lg btn-block btn-login text-uppercase" type="submit">Войти</button>
                                        <button class="btn btn-lg btn-danger btn-block text-uppercase mb-2" type="submit">Войти через Google</button>
                                        <div class="text-center">
                                            <a class="small text-col" href="#">Забыли пароль?</a></div>
                                            <a class="d-block text-center mt-2 small text-col" href="/signUp">Зарегистрироваться</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>