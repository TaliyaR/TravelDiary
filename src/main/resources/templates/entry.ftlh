<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link href="entry.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Новая запись</title>
</head>
<body>

<script>

    function validation() {
        let title = document.newEntry.title;
        let text = document.newEntry.text;
        let location = document.newEntry.location;
        let date = document.newEntry.date;
        if (text_val(title)) {
            if (text_val(text)) {
                if (text_val(location)) {
                    if (validDate(date)) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    function text_val(name) {
        let len = name.value.length;
        let letters = /^[A-Za-zА-Яа-я]+$/;
        if (len == 0) {
            document.getElementById('check').innerHTML = 'Пожалуйста, введите данные';
            return false;
        } else if (!name.value.match(letters)) {
            document.getElementById('check').innerHTML = 'Должны содержаться только буквы';
            return false;
        }
        return true;
    }


    function validDate(entryDate) {
        var arr = entryDate.value.split('-');
        var date = new Date();
        if (arr[0] > date.getFullYear() || arr[0] < 1900) {
            document.getElementById('checkDate').innerHTML = 'Неверная дата';
            return false;
        }
        return true;
    }

    var expanded = false;

    function showCheckboxes() {
        var checkboxes = document.getElementById("checkboxes");
        if (!expanded) {
            checkboxes.style.display = "block";
            expanded = true;
        } else {
            checkboxes.style.display = "none";
            expanded = false;
        }
    }
</script>

<style>
    .multiselect {
        width: 200px;
    }

    .selectBox {
        position: relative;
    }

    .selectBox select {
        width: 100%;
        font-weight: bold;
    }

    .overSelect {
        position: absolute;
        left: 0;
        right: 0;
        top: 0;
        bottom: 0;
    }

    #checkboxes {
        display: none;
        border: 1px #dadada solid;
    }

    #checkboxes label {
        display: block;
    }

    #checkboxes label:hover {
        background-color: #1e90ff;
    }
</style>
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
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Выйти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container margin">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Новая запись</h5>
                    <form name="newEntry" class="form-entry" action="/entry" method="post"
                          enctype="multipart/form-data" onsubmit="return validation();">
                        <div class="form-label-group">
                            <input type="text" id="inputTitle" name="title" class="form-control" placeholder="Заголовок"
                                   required autofocus>
                            <label for="inputTitle">Заголовок</label>
                        </div>

                        <div class="form-label-group">
                            <input type="date" id="date" name="date" class="form-control" required autofocus>
                            <label for="firstName">Дата поездки</label>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="location" name="location" class="form-control"
                                   placeholder="Местность" required autofocus>
                            <label for="location">Местность</label>
                        </div>

                        <div class="form-label-group">
                            <textarea id="inputText" rows="50" name="text" class="form-control"
                                      placeholder="Введите свой текст" required></textarea>
                        </div>

                        <#--                        <div class="custom-control custom-checkbox mb-3">-->
                        <div>
                            <select class="custom-select" name="isPublic">
                                <option value="PUBLIC">Public</option>
                                <option value="PRIVATE">Private</option>
                            </select>
                            <#--<input type="checkbox" class="custom-control-input container input" name="isPrivate" value="private" id="isPrivate">-->
                            <#--<label class="custom-control-label" for="isPrivate">Сделать приватным</label>-->
                        </div>

                        <div class="multiselect">
                            <div class="selectBox" onclick="showCheckboxes()">
                                <select class="custom-select">
                                    <option>Выберите тэги</option>
                                </select>
                                <div class="overSelect"></div>
                            </div>
                            <div id="checkboxes">
                                <#list tags as tag>
                                    <label>
                                        <input type="checkbox" name="tag" value="${tag.name}"/>${tag.name}</label>
                                </#list>
                            </div>
                            <div class="invalid-feedback">Выберите тэги</div>
                        </div>
                        <#--                        <form method="post" action="/upload" enctype="multipart/form-data">-->
                        <div class="form-group">
                            <label for="exampleFormControlFile1"></label>
                            <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                        </div>
                        <#--                        </form>-->

                        <hr class="my-4">
                        <button class="btn btn-lg btn-register btn-block text-uppercase" type="submit">Сохранить
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>