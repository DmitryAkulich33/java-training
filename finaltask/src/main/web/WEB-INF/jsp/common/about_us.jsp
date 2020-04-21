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
                <h><strong>WE</strong></h>
                <br>
                <p>“TastyPie” company proposes you hot pies, delivered to your office or home every day since  10:00 a.m. till 22:00 p.m.</p>
                <p>In our menu you can find:</p>
                <ul>
                    <li>hearty pies – with meat, fish, potatoes;</li>
                    <li>sweet pies for desert – with fruit, berries, chocolate;</li>
                    <li>pies snacks – with vegetables, cheese, greens.</li>
                </ul>
                <br>
            </th>
        </tr>
        <tr>
            <th>
                <h><strong>OUR ADVANTAGES</strong></h>
                <br>
                <p>Over 10 000 clients have chosen us during the 1st year of work, because among our advantages are:</p>
                <ul>
                    <li>fresh and healthy farm products;</li>
                    <li>more than 30 items in the menu, which is regularly updating;</li>
                    <li>lots of filling in the pies – not less than 50% of its general weight;</li>
                    <li>convenient system of getting orders – you can make it online even at night and our managers will contact you since  10:00 a.m. till 22:00 p.m.;</li>
                    <li>quick delivery around Minsk and beyond the city (average time of delivery in the city is 1 hour);</li>
                </ul>
                <p>If you have any questions, please, contact our managers +375445646130. And if you have already tasted our pies, don’t forget to leave you feedback  - help the others to choose the tastiest pie. Every opinion is important for us!</p>
            </th>
        </tr>
    </table>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>