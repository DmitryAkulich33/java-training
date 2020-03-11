<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pie" class="by.epam.xml.domain.Pie" scope="application"/>
<jsp:useBean id="client" class="by.epam.xml.domain.Client" scope="application"/>
<jsp:useBean id="order" class="by.epam.xml.domain.Order" scope="application"/>
<%@ page import="java.util.Set" %>
<%@ page import="java.time.LocalDateTime" %>


<!doctype html>
<html>
<head>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
    <br>
<table>
    <tr>
        <th>OrderId</th>
        <th>OrderStatus</th>
        <th>ClientName</th>
        <th>ClientSurname</th>
        <th>ClientPatronymic</th>
        <th>PieName</th>
        <th>PieWeight</th>
        <th>PiePrice</th>
        <th>ProductionDate</th>
        <th>DeliveryDate</th>
    </tr>
    <c:forEach var="elem" items="${orders}">
    <tr>
        <td>
            <c:out value="${elem.id}"/>
        </td>
        <td>
            <c:out value="${elem.statusEnum}"/>
        </td>
        <td>
            <c:out value="${elem.client.name}"/>
        </td>
        <td>
            <c:out value="${elem.client.surname}"/>
        </td>
        <td>
            <c:out value="${elem.client.patronymic}"/>
        </td>
        <td>
            <c:out value="${elem.pie.title}"/>
        </td>
        <td>
            <c:out value="${elem.pie.weight}"/>
        </td>
        <td>
            <c:out value="${elem.pie.price}"/>
        </td>
        <td>
            <c:out value="${elem.productionDate}"/>
        </td>
        <td>
            <c:out value="${elem.deliveryDate}"/>
        </td>
    </tr>
    </c:forEach>
    </tr>
</table>
<br>
<a href="<c:url value="index.jsp"/>">Back</a>
</body>
</html>