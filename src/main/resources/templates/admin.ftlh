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
        <a class="navbar-brand" href="/home">Travel Diary</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/diaries">Дневник</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Профиль</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin">Админ</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выйти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<section class="py-5">
    <div class="container">
        <#--        <div class="card border-0 shadow my-5">-->
        <#--            <div class="card-body p-5">-->
        <div class="row">
            <div class="col-sm-12 col-md-10 col-lg-8">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h2 class="font-weight-light mb-h2">Пользователи</h2>

                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">№</th>
                                <th scope="col">Фамилия</th>
                                <th scope="col">Имя</th>
                                <th scope="col">username</th>
                                <th scope="col">email</th>
                                <th scope="col"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <form class="form-signin" action="/deleteUser" method="post">
                                <#list userList as user2>
                                    <tr>
                                        <th scope="row">${user2_index + 1}</th>
                                        <td>${user2.lastName}</td>
                                        <td>${user2.firstName}</td>
                                        <td>${user2.username}</td>
                                        <td>${user2.email}</td>
                                        <td>
                                            <button class="btn btn-sm btn-color text-uppercase" name="id"
                                                    value="${user2.id}" type="submit">Удалить
                                            </button>
                                        </td>
                                    </tr>
                                </#list>
                            </form>

                            </tbody>
                        </table>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>