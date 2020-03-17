<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="pie" class="by.epam.xml.domain.Pie" scope="application"/>
<jsp:useBean id="client" class="by.epam.xml.domain.Client" scope="application"/>
<jsp:useBean id="order" class="by.epam.xml.domain.Order" scope="application"/>
<%@ page import="java.util.Set" %>
<%@ page import="java.time.LocalDateTime" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="interface"/>

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
        <th><fmt:message key="table.orderId"/></th>
        <th><fmt:message key="table.orderStatus"/></th>
        <th><fmt:message key="table.clientName"/></th>
        <th><fmt:message key="table.clientSurname"/></th>
        <th><fmt:message key="table.clientPatronymic"/></th>
        <th><fmt:message key="table.pieName"/></th>
        <th><fmt:message key="table.pieWeight"/></th>
        <th><fmt:message key="table.piePrice"/></th>
        <th><fmt:message key="table.productionDate"/></th>
        <th><fmt:message key="table.deliveryDate"/></th>
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
<a href="<c:url value="index.jsp"/>"><fmt:message key="message.back"/></a>
</body>
</html>