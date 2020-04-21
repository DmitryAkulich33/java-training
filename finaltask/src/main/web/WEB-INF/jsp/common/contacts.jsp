<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../../css/style.css" %>
        <%@include file="../../../css/bootstrap.min.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script>
        <%@include file="../../../js/bootstrap.js" %>
    </script>
    <title>Personal account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="login.jsp"/>
<jsp:include page="menu.jsp"/>
<div class="container mt-3">
    <table class="table table-hover">
        <tr>
            <th>
                <h><strong>OUR CONTACTS</strong></h>
                <br>
                <p>Telephones</p>
                <ul>
                    <li>
                        +375 44 564 61 30
                    </li>
                    <li>
                        +375 29 564 61 30
                    </li>
                </ul>
            </th>
        </tr>
        <tr>
            <th>
                <h><strong>OUR ADDRESS</strong></h>
                <br>
                <p>TASTYPIE.COM</p>
                <p>27 Lubimova St., Minsk</p>
                <br>
            </th>
        </tr>
    </table>
    <h><strong>OUR LOCATION HERE</strong></h>
    <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A39841349ba1022f696ab7d290cc2cfa5a46eaa08a7ab547c8d1bda449778d739&amp;width=800&amp;height=500&amp;lang=ru_RU&amp;scroll=true"></script>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>