<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link href="home.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Главная</title>
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
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Главная</a>
                    <span class="sr-only">(current)</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/diaries">Дневник</a>
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

<header class="masthead">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12 text-center">
                <h1 class="font-weight-light header-text">TRAVEL DIARIES</h1>
                <p class="lead header-text">Создай свой собственные заметки путешественника</p>
            </div>
        </div>
    </div>
</header>


<!-- Page Content -->
<section class="py-5">
    <div class="container">
        <h2 class="font-weight-light h-text">Дневники</h2>
        <div class="row">
            <#list entries as entry>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <a href="/currentEntry?entryId=${entry.id}"><img class="card-img-top" src="/img/${entry.filename}" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title card-tex-color">${entry.title}</h4>
                            <p class="card-text card-tex-color">${entry.location}</p>
                            <form action="/like" method="post">
                                <button class="btn btn-primary" name="entryId" value="${entry.id}" type="submit">Like</button>
                            </form>
<#--                            <div class="col-md-12">-->
<#--                                <button type="button" class="btn btn-labeled btn-success">-->
<#--                                    <i class="glyphicon glyphicon-thumbs-up"></i>-->
<#--                                </button>-->
<#--                            </div>-->
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>
</body>
</html>