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
    <title><fmt:message key="login.admin"/></title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<div class="container-fluid">
    <br>
    <h2><fmt:message key="feedbacks"/></h2>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th><fmt:message key="id"/></th>
            <th><fmt:message key="surname"/></th>
            <th><fmt:message key="name"/></th>
            <th><fmt:message key="user.id"/></th>
            <th><fmt:message key="posted.date"/></th>
            <th><fmt:message key="review"/></th>
            <th><fmt:message key="action"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="element" items="${feedback}" varStatus="status">
        <tr>
            <td><c:out value="${ element.id}"/></td>
            <td><c:out value="${ element.user.surname }"/></td>
            <td><c:out value="${ element.user.name }"/></td>
            <td><c:out value="${ element.user.id }"/></td>
            <td><c:out value="${ element.localDateTime.toString().replace(\"T\", \" \") }"/></td>
            <td><c:out value="${ element.review }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModalFeed${ element.id }">
                    <fmt:message key="delete"/>
                </button>
                <div class="modal fade" id="myModalFeed${ element.id }">
                    <div class="modal-dialog modal-dialog-centered modal-sm">
                        <div class="modal-content">
                            <div class="modal-body">
                                <fmt:message key="delete.feedback"/>
                            </div>
                            <form action="controller" method="POST">
                                <div class="modal-footer">
                                    <input type="hidden" name="feedbackId" value="${ element.id }"/>
                                    <input type="hidden" name="command" value="delete_feedback">
                                    <input type="submit" class="btn btn-secondary" value="<fmt:message key="delete"/>">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal"><fmt:message key="cancel"/></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination justify-content-center" style="margin:20px 0">
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_feedback&page=1"><fmt:message key="first"/></a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_feedback_decrease_page&page=${page}&count=${count}"><<</a></li>
        <li class="pagination_number">
            <span class="pagination_number"><mark>&nbspPage <c:out value="${ page }"/> from <c:out value="${ count }"/>&nbsp</mark></span>
        </li>
        <li class="page-item">
            <a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_feedback_increase_page&page=${page}&count=${count}">>></a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_feedback&page=${count}"><fmt:message key="last"/></a></li>
    </ul>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="../common/footer.jsp"/>
    </div>
</div>
</body>
</html>