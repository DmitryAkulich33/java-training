<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="interface"/>

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
    <title><fmt:message key="login.courier"/></title>
</head>
<body>
<div class="container-fluid">
    <ul class="nav">
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=show_main_page"><fmt:message key="return"/></a>
        </li>
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=log_out"><fmt:message key="login.exit"/></a>
        </li>
    </ul>
    <div class="btn-group">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="courier_clients">
            <input type="hidden" name="page" value="1">
            <input type="submit" class="change-info btn btn-primary" value="<fmt:message key="change.user.note"/>">
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="courier_order">
            <input type="hidden" name="page" value="1">
            <input type="submit" class="change-info btn btn-primary" value="<fmt:message key="change.order.status"/>">
        </form>
    </div>
</div>
</body>
</html>