<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Courier account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="courier_menu.jsp"/>
<div class="container-fluid">
    <br>
    <h2>Orders:</h2>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Status</th>
            <th>id user</th>
            <th>Surname</th>
            <th>name</th>
            <th>patronymic</th>
            <th>production date</th>
            <th>delivery date</th>
            <th>total</th>
            <th>action</th>
            <th></th>
        </tr>
        </thead>
        <c:set var="index" scope="session" value="0"/>
        <c:forEach var="element" items="${orderProducts}" varStatus="status">
            <c:choose>
                <c:when test="${index != element.order.id }">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <thead>
                    <tr>
                        <th><c:out value="${ element.order.id }"/></th>
                        <th><mark><c:out value="${ element.order.status.toString().replace(\"_\", \" \") }"/></mark></th>
                        <th><c:out value="${ element.order.user.id }"/></th>
                        <th><c:out value="${ element.order.user.surname }"/></th>
                        <th><c:out value="${ element.order.user.name }"/></th>
                        <th><c:out value="${ element.order.user.patronymic }"/></th>
                        <th><mark><c:out value="${ element.order.productionDate.toString().replace(\"T\", \" \") }"/></mark></th>
                        <th><mark><c:out value="${ element.order.deliveryDate.toString().replace(\"T\", \" \") }"/></mark></th>
                        <th><c:out value="${ element.order.total }"/>0 BYN</th>
                        <th>
                            <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                                    data-target="#mySecModal${ element.order.id }">
                                Change status
                            </button>
                            <div class="modal fade" id="mySecModal${ element.order.id }">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Change status</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="controller" method="POST">
                                                <div class="input-group mb-3">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text">Status</span>
                                                    </div>
                                                    <select name="changeStatus">
                                                        <option value="delivered">delivered</option>
                                                        <option value="not delivered">not delivered</option>
                                                    </select>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="hidden" name="changeId" value="${ element.order.id }"/>
                                                    <input type="hidden" name="command" value="change_order_status">
                                                    <input type="submit" class="btn btn-secondary" value="Change">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                        Cancel
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </th>
                    </tr>
                    </thead>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><img class="image_pie_basket" src="<c:out value="${ element.pie.picture }"/>"></td>
                        <td><c:out value="${ element.pie.name }"/></td>
                        <td><c:out value="${ element.pie.price }"/>0 BYN</td>
                        <td>x 1</td>
                        <td><c:out value="${ element.pie.price }"/>0 BYN</td>
                    </tr>
                    <c:set var="index" scope="session" value="${ element.order.id }"/>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><img class="image_pie_basket" src="<c:out value="${ element.pie.picture }"/>"></td>
                        <td><c:out value="${ element.pie.name }"/></td>
                        <td><c:out value="${ element.pie.price }"/>0 BYN</td>
                        <td>x 1</td>
                        <td><c:out value="${ element.pie.price }"/>0 BYN</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>
    <ul class="pagination justify-content-center" style="margin:20px 0">
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=courier_order&page=1">The first</a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=courier_order_decrease_page&page=${page}&count=${count}"><<</a></li>
        <li class="pagination_number">
            <span class="pagination_number"><mark>&nbspPage <c:out value="${ page }"/> from <c:out value="${ count }"/>&nbsp</mark></span>
        </li>
        <li class="page-item">
            <a class="pagination_color page-link" href="${request.contextPath}controller?command=courier_order_increase_page&page=${page}&count=${count}">>></a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=courier_order&page=${count}">The last</a></li>
    </ul>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>