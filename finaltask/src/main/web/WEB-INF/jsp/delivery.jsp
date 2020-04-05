<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="by.epam.bakery.domain.User" scope="application"/>
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
                <h><strong>OUR DELIVERY SERVICE</strong></h>
                <br>
                <p>The delivery service is available from 10:00 a.m. till 22:00 p.m.Average delivery term is 1 hour.</p>
                <br>
                <p>To make an order for the following day, contact us till 18:00. Call +375445646130 or use the online
                    form and our managers will call you back. Online form is available 24/7.
                    The orders got after 18:00 are delivered the next day, you can choose convenient time from 10:00
                    a.m. till 22:00 p.m. As well pre-orders for holidays or any other days are available.</p>
            </th>
        </tr>
        <tr>
            <th>
                <br>
                <h><strong>OUR ADVANTAGES</strong></h>
                <br>
                <p>For all orders the delivery service is free. Delivery to the localities beyond Minsk Ring Road is
                    also possible. The price depends on distance. For more details contact our managers.
                    As well you can use free pickup from our office at Liubimova pr., 27. </p>
                <br>
                <p>We accept:</p>
                <ul>
                    <li>
                        cash payments;
                    </li>
                    <li>
                        credit card payments;
                    </li>
                </ul>
                <p>Please, contact us as soon as possible, if you want to cancel your order.</p>
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