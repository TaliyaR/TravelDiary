<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
    <form action="/profile" method="post">
        <input name="firstName" placeholder="${user.firstName}">
        <input name="lastName" placeholder="${user.lastName}">
        <input type="email" name="email" placeholder="${user.email}">
        <input type="submit" value="Save">
    </form>
    <a href=/logout>Logout</a>
</body>
</html>