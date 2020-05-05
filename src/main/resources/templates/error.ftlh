<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tameline</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:700" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<#--    <#include "stylesheets/errorpagestylesheet.ftlh">-->
</head>

<body>

<div id="notfound">
    <div class="notfound">
        <div class="notfound-bg">
            <div></div>
            <div></div>
            <div></div>
        </div>
        <h1>Упс!</h1>
        <#switch statusCode>
            <#case 403>
                <h2>У вас нет доступа к данной странице :(</h2>
                <#break>
            <#case 404>
                <h2>Запрашиваемая страница не существует :(</h2>
                <#break>
            <#case 500>
                <h2>Произошла ошибка. Приносим наши извинения, мы уже работаем над данной проблемой</h2>
                <#break>
            <#default>
                <h2>Произошла ошибка. Приносим наши извинения, мы уже работаем над данной проблемой</h2>
        </#switch>
        <a href="/home">
            На главную
        </a>
    </div>
</div>
</body>
</html>