<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="chat.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title>Diary</title>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous">
    </script>
    <script>
        var webSocket;

        function connect() {
            webSocket = new WebSocket('ws://localhost:8080/chats');
            webSocket.onmessage = function receiveMessage(message) {
                let data = message['data'];
                let json = JSON.parse(data);
                $('#messagesList').first().after("<li>" + json['from'] + ": " + json['text'] + "</li>")
            }
            webSocket.onopen = function () {
                sendMessage(null, null)
            }
        }

        function sendMessage(username, text) {
            let message = {
                "text": text,
                "from": username
            };
            webSocket.send(JSON.stringify(message));
        }
    </script>
</head>
<body onload="connect()">

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
                <li class="nav-item active">
                    <a class="nav-link" href="/chat">Чат</a>
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
<div class="container ">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-body">
                    <div>
                        <input class="mb-2" id="message" required type="text" placeholder="Введите текст">
                        <div>
                            <button onclick="sendMessage('${user.username}', $('#message').val())"
                                    type="submit">Отправить
                            </button>
                        </div>
                    </div>

                    <div class="overflow-auto">
                        <ul id="messagesList">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#--<div>-->
<#--    <input id="message" required type="text" placeholder="Введите текст">-->
<#--    <div>-->
<#--        <button onclick="sendMessage('${user.username}', $('#message').val())"-->
<#--                type="submit">Отправить-->
<#--        </button>-->
<#--    </div>-->
<#--</div>-->




</body>
</html>