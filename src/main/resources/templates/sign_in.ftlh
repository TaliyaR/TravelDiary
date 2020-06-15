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

<script type="text/javascript">
    function validate() {
        if (document.login.username.value == "" && document.login.password.value == "") {
            alert("Username and password are required");
            document.f.username.focus();
            return false;
        }
        if (document.f.username.value == "") {
            alert("Username is required");
            document.f.username.focus();
            return false;
        }
        if (document.f.password.value == "") {
            alert("Password is required");
            document.f.password.focus();
            return false;
        }
    }
</script>
<div class="container-fluid">
    <div class="row no-gutter">
        <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
        <div class="col-md-8 col-lg-6">
            <div class="login d-flex align-items-center py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                            <h3 class="login-heading mb-4">Добро пожаловать!</h3>
                            <form name="login" action="/signIn" method="post">
                                <div class="form-label-group">
                                    <input type="username" id="username" name="username" class="form-control"
                                           placeholder="Username" required autofocus>
                                    <label for="username">Username</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" name="password" class="form-control"
                                           placeholder="Пароль" required>
                                    <label for="inputPassword">Пароль</label>
                                </div>

                                <#--                                        <div class="custom-control custom-checkbox mb-3">-->
                                <#--                                            <input type="checkbox" class="custom-control-input container input" id="customCheck1">-->
                                <#--                                            <label class="custom-control-label" for="customCheck1">Запомнить пароль</label>-->
                                <#--                                        </div>-->
                                <button class="btn btn-lg btn-block btn-login text-uppercase mt-2 mb-2" type="submit">Войти
                                </button>
                            </form>
                            <#--                                <form action="/oauth2/authorization/google">-->
                            <#--                                    -->
                            <#--                                    <button class="btn btn-lg btn-danger btn-block text-uppercase mt-2 mb-2" type="submit">-->
                            <#--                                        Войти через Google-->
                            <#--                                    </button>-->
                            <#--                                </form>-->

                            <a class="btn btn-primary btn-lg btn-block text-uppercase" href="https://discord.com/oauth2/authorize?client_id=709842682574405763&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2FdiscordAuth&response_type=code&scope=identify%20email%20connections%20guilds">Войти через
                                Discord</a>
                            <div class="text-center">
                                <#--                                            <a class="small text-col" href="#">Забыли пароль?</a></div>-->
                                <a class="d-block text-center mt-2 small text-col"
                                   href="/signUp">Зарегистрироваться</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>