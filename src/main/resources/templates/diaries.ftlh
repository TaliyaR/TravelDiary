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
    <title>Diary</title>
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
                    <a class="nav-link" href="/chat">Чат</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/diaries">Дневник</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выйти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Content -->
<div class="container header">

    <!-- Page Heading -->
    <div class="row">
        <h1 class="my-4">Мои дневники</h1>
        <div style="position: absolute; right: 200px;">
            <a href="/entry">
                <button class="btn btn-lg btn-entry text-uppercase my-4" type="button">Новая запись</button>
            </a>
        </div>
    </div>

    <div class="row">
        <#list entries as entry>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="/currentEntry?entryId=${entry.id}"><img class="card-img-top" src="/img/${entry.filename}" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title card-text-color">${entry.title}</h4>
                        <p class="card-text card-text-color">${entry.location}</p>
                        <form action="/delete" method="post">
                            <button class="btn btn-primary btn-delete" name="entryId" value="${entry.id}" type="submit">
                                Удалить
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>