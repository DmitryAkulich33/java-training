<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="st" uri="/WEB-INF/tld/StatisticTag.tld" %>
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
    <title>Admin account</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<div class="container-fluid pt-3">
    <div class="wrong_message"><c:out value="${ wrong }"/></div>
    <st:statistic/>
<%--    <br>--%>
<%--    <p>Number of registered users: <strong>15!</strong></p>--%>
<%--    <br>--%>
<%--    <p>Number of delivered orders: <strong>108!</strong></p>--%>
<%--    <br>--%>
<%--    <p>The total amount of orders is: <strong>25 670.00 RUB!</strong></p>--%>
    <div class="admin_padding footer">
        <jsp:include page="../common/footer.jsp"/>
    </div>
</div>
</body>
</html>