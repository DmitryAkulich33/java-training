<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="interface"/>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../../css/bootstrap.min.css" %>
        <%@include file="../../../css/style.css" %>
    </style>
    <script>
        <%@include file="../../../js/bootstrap.js" %>
    </script>
    <title><fmt:message key="bakery"/></title>
</head>
<body>
<div class="container-fluid pt-3">
    <div>
        <c:choose>
            <c:when test="${user.role == 1}">
                <div class="welcome">
                    <p><em><fmt:message key="login.welcome"/> <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=admin_account"><fmt:message key="login.admin"/></a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=log_out"><fmt:message key="login.exit"/></a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:when test="${user.role == 2}">
                <div class="welcome">
                    <p><em><fmt:message key="login.welcome"/> <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=courier_account"><fmt:message key="login.courier"/></a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=log_out"><fmt:message key="login.exit"/></a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:when test="${user.role == 3}">
                <div class="welcome">
                    <p><em><fmt:message key="login.welcome"/> <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=personal_account&page=1"><fmt:message key="login.client"/></a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=log_out"><fmt:message key="login.exit"/></a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:otherwise>
                <form action="controller" method="POST">
                    <label for="login-field"><fmt:message key="login"/></label>
                    <input type="text" name="login" id="login-field" placeholder="5-12 <fmt:message key="symbols"/>" pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                    <label for="password-field"><fmt:message key="password"/></label>
                    <input type="password" name="password" id="password-field" placeholder="5-12 <fmt:message key="symbols"/>" pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                    <input type="hidden" name="command" value="login">
                    <input type="submit" value="Submit" class="button_enter">
                    <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=registration"><fmt:message key="registration"/></a>
                    <div class="wrong_message"><c:out value="${ wrong }"/></div>
                    <div class="right_message"><c:out value="${ right }"/></div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>