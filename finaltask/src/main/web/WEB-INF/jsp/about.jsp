<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../css/style.css" %>
        <%@include file="../../css/bootstrap.min.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script>
        <%@include file="../../js/bootstrap.js" %>
    </script>
    <title>Bakery</title>
</head>
<body>
<div class="container-fluid pt-3">
    <div class="p-3 m-3 bg-dark text-white">
        <table>
            <tr>
                <td class="logo" rowspan="2"><img class="image_logo" src="../../image/logo1.png"></td>
                <td class="name_organization">T A S T Y P I E . C O M</td>
                <td class="a1_logo"><img class="image_logo_a1" src="../../image/a1.png"></td>
                <td class="a1_phone">+375-44-564-61-30</td>
            </tr>
            <tr>
                <td class="address_organization">27 Lubimova St, Minsk</td>
                <td class="mts_logo"><img class="image_logo_a1" src="../../image/mts.png"></td>
                <td class="mts_phone">+375-29-564-61-30</td>
            </tr>
        </table>
    </div>
    <div class="login">
        <label for="login-field">Login</label>
        <input type="text" name="login" id="login-field">
    </div>
    <div class="password">
        <label for="password-field">Password</label>
        <input type="password" name="password" id="password-field" value="">
    </div>
    <div class="enter">
        <input type="submit" value="Submit" class="button_enter">
    </div>
    <br>
    <p>
        adddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
    </p>

    <div class="footer">
        <jsp:include page="footer.jsp" />
    </div>

</div>
</body>
</html>