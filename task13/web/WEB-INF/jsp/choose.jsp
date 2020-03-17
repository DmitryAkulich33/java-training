<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="interface"/>

<html>
<head>
    <title>XML PARSING</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>


<form action="lang" method="POST">
    <input type="hidden" name="langValue" value="ru_Ru"/>
    <input type="submit" name="button" class="in_basket" value="RU"/>
</form>
<form action="lang" method="POST">
    <input type="hidden" name="langValue" value="en_US"/>
    <input type="submit" name="button" class="in_basket" value="EN"/>
</form>
<p><fmt:message key="message.first"/></p>
<br>
<form action="choose" method="POST" enctype="multipart/form-data">
    <input type="file" name="data"/>
    <br>
    <input type="radio" id="sax" name="parser" value="sax">
    <label for="sax">SAX</label><br>
    <input type="radio" id="stax" name="parser" value="stax">
    <label for="stax">STAX</label><br>
    <input type="radio" id="dom" name="parser" value="dom">
    <label for="dom">DOM</label>
    <br>
    <input type="submit" value="<fmt:message key="button.submit"/>">
</form>
</body>
</html>