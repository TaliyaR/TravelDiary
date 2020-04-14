<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="style.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Профиль</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Travel Diary</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/diaries">Дневники</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/profile">Профиль</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выйти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Content -->
<section class="py-5">
    <div class="container">
<#--        <div class="card border-0 shadow my-5">-->
<#--            <div class="card-body p-5">-->
                <div class="row">
                    <div class="col-sm-12 col-md-10 col-lg-8">
                        <div class="card card-signin my-5">
                            <div class="card-body">
                                <h2 class="font-weight-light mb-h2">Настройки профиля</h2>
                                <form class="form-signin" action="/profile" method="post">
                                    <div class="form-label-group">
                                        <input type="text" id="firstName" name="firstName" class="form-control"
                                               placeholder="Имя" value="${user.firstName}" required autofocus>
                                        <label for="firstName">Имя</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="text" id="lastName" name="lastName" class="form-control"
                                               placeholder="Фамилия" value="${user.lastName}" required autofocus>
                                        <label for="lastName">Фамилия</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="email" id="inputEmail" name="email" class="form-control"
                                               placeholder="Email" value="${user.email}" required>
                                        <label for="inputEmail">Email</label>
                                    </div>
                                    <hr>
                                    <button class="btn btn-lg btn-color text-uppercase" type="submit">Сохранить
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
<#--                </div>-->
<#--            </div>-->
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-10 col-lg-8">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h2 class="font-weight-light mb-h2">Сменить пароль</h2>
                        <form class="form-signin" action="/profile_pass" method="post">
                            <div class="form-label-group">
                                <input type="password" id="oldPassword" name="oldPassword" class="form-control"
                                       placeholder="Старый пароль" required autofocus>
                                <label for="oldPassword">Старый пароль</label>
                            </div>

                            <div class="form-label-group">
                                <input type="password" id="newPassword" name="newPassword" class="form-control"
                                       placeholder="Новый пароль" required autofocus>
                                <label for="newPassword">Новый пароль</label>
                            </div>

                            <hr>
                            <button class="btn btn-lg btn-color text-uppercase" type="submit">Сохранить
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</section>

</body>
</html>