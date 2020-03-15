<jsp:useBean id="user" class="by.epam.bakery.domain.User" scope="application"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../css/bootstrap.min.css" %>
        <%@include file="../../css/style.css" %>
    </style>
    <script>
        <%@include file="../../js/bootstrap.js" %>
    </script>
    <title>Bakery</title>
</head>
<body>
<div class="container-fluid pt-3">
    <c:choose>
        <c:when test="${user.login=='user1'}">
            Welcome, <c:out value="${ user.surname }"/>
            <br />
        </c:when>
        <c:otherwise>
            <form action="controller" method="POST">
                <div class="login">
                    <label for="login-field">Login</label>
                    <input type="text" name="login" id="login-field">
                </div>
                <div class="password">
                    <label for="password-field">Password</label>
                    <input type="password" name="password" id="password-field" value="">
                </div>
                <input type="hidden" name="command" value="login">
                <div class="enter">
                    <input type="submit" value="Submit" class="button_enter">
                </div>
            </form>
            <br>
        </c:otherwise>
    </c:choose>

<%--    <form action="controller" method="POST">--%>
<%--        <div class="login">--%>
<%--            <label for="login-field">Login</label>--%>
<%--            <input type="text" name="login" id="login-field">--%>
<%--        </div>--%>
<%--        <div class="password">--%>
<%--            <label for="password-field">Password</label>--%>
<%--            <input type="password" name="password" id="password-field" value="">--%>
<%--        </div>--%>
<%--        <input type="hidden" name="command" value="login">--%>
<%--        <div class="enter">--%>
<%--            <input type="submit" value="Submit" class="button_enter">--%>
<%--        </div>--%>
<%--    </form>--%>
<%--    <br>--%>
</div>
</body>
</html>