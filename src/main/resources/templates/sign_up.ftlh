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

                    <form name='registration' class="form-signin" action="/signUp" method="post"
                          onsubmit="return validation();">
                        <div class="form-label-group">
                            <input type="text" id="inputUsername" name="username" class="form-control"
                                   placeholder="Username" required autofocus>
                            <label for="inputUsername">Username</label>
                            <span class="text-color" id="checkUsername" aria-required="true"></span>

                        </div>

                        <div class="form-label-group">
                            <input type="text" id="firstName" name="firstName" class="form-control" placeholder="Имя"
                                   required autofocus>
                            <label for="firstName">Имя</label>
                            <span class="text-color" id="check2" aria-required="true"></span>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Фамилия"
                                   required autofocus>
                            <label for="lastName">Фамилия</label>
                            <span class="text-color" id="check" aria-required="true"></span>
                        </div>

                        <div class="form-label-group">
                            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email"
                                   required>
                            <label for="inputEmail">Email</label>
                            <span class="text-color" id="checkEmail" aria-required="true"></span>

                        </div>

                        <hr>

                        <div class="form-label-group">
                            <input type="password" id="inputPassword" name="password" class="form-control"
                                   placeholder="Пароль" required>
                            <label for="inputPassword">Password</label>
                            <span class="text-color" id="checkPassword" aria-required="true"></span>
                        </div>

                        <button class="btn btn-lg btn-register btn-block text-uppercase" type="submit">
                            Зарегистрироваться
                        </button>
                        <a class="d-block text-center mt-2 small text-col" href="/signIn">Войти</a>
                        <hr class="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function validation() {
        var uName = document.registration.username;
        var lName = document.registration.lastName;
        var fName = document.registration.firstName;
        var email = document.registration.email;
        var pass = document.registration.password;
        if (username(uName, 30)) {
            if (last_name(lName, 30)) {
                if (name(fName, 30)) {
                    if (validEmail(email)) {
                        if (validPassword(pass, 8, 20)) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    function username(uName, max) {
        var len = uName.value.length;
        var letters = /^[a-zA-Z0-9]+$/;
        if (len == 0) {
            document.getElementById('checkUsername').innerHTML = 'Пожалуйста, введите данные';
            uName.focus();
            return false;
        } else if (len > max) {
            document.getElementById('checkUsername').innerHTML = 'Число символов не должен быть больше ' + max;
            uName.focus();
            return false;
        } else if (!uName.value.match(letters)) {
            document.getElementById('checkUsername').innerHTML = 'username должен содержать только цифры и латинские буквы';
            uName.focus();
            return false;
        }
        return true;
    }

    function last_name(uName, max) {
        var len = uName.value.length;
        var letters = /^[A-Za-zА-Яа-я]+$/;
        if (len == 0) {
            document.getElementById('check').innerHTML = 'Пожалуйста, введите данные';
            uName.focus();
            return false;
        } else if (!uName.value.match(letters)) {
            document.getElementById('check').innerHTML = 'Фамилия должна содержать только буквы';
            uName.focus();
            return false;
        } else if (len > max) {
            document.getElementById('check').innerHTML = 'Число символов не должен быть больше ' + max;
            uName.focus();
            return false;
        }
        return true;
    }

    function name(uName, max) {
        var len = uName.value.length;
        var letters = /^[A-Za-zА-Яа-я]+$/;
        if (len == 0) {
            document.getElementById('check2').innerHTML = 'Пожалуйста, введите данные';
            uName.focus();
            return false;
        } else if (len > max) {
            document.getElementById('check2').innerHTML = 'Число символов не должен быть больше ' + max;
            uName.focus();
            return false;
        } else if (!uName.value.match(letters)) {
            document.getElementById('check2').innerHTML = 'Имя должно содержать только буквы';
            uName.focus();
            return false;
        }
        return true;
    }

    function validEmail(email) {
        var m = /.+@.+\..+/;
        if (!email.value.match(m)) {
            document.getElementById('checkEmail').innerHTML = 'Пожалуйста, введите корректный адрес почты';
            email.focus();
            return false;
        }
        return true;
    }

    function validPassword(pass, min, max) {
        let len = pass.value.length;
        if (len > max || len < min) {
            document.getElementById('checkPassword').innerHTML = 'Количество символов должно быть от ' + min + " до " + max;
            pass.focus();
            return false;
        }
        return true;
    }


</script>
</body>
</html>