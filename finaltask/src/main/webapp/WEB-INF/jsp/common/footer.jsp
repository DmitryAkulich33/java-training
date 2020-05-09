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
<div class="container-fluid p-3 m-3 bg-dark text-white">
    <table>
        <td class="td_last_text">
            <img class="image_logo" src="image/logo1.png">
        </td>
        <td class="td_last_text">
        <span>
            <fmt:message key="footer.message"/>
        </span>
        </td>
    </table>
</div>
</div>
</body>
</html>