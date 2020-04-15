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
    <title>Admin account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
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
                                data-target="#myModalDelOrd${ element.order.id }">
                            Delete
                        </button>
                        <div class="modal fade" id="myModalDelOrd${ element.order.id }">
                            <div class="modal-dialog modal-dialog-centered modal-sm">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        Do you want to remove the order from the database?
                                    </div>
                                    <div class="modal-footer">
                                        <form action="controller" method="POST">
                                            <input type="hidden" name="delId" value="${ element.order.id }"/>
                                            <input type="hidden" name="command" value="delete_order">
                                            <input type="submit" class="btn btn-secondary" value="Delete">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </th>
                    <th>
                        <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                                data-target="#myModalChange${ element.order.id }">
                            Change
                        </button>
                        <div class="modal fade" id="myModalChange${ element.order.id }">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Change information</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="controller" method="POST">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Production date</span>
                                                </div>
                                                <input type="datetime-local" class="form-control" name="productionDate">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Delivery date</span>
                                                </div>
                                                <input type="datetime-local" class="form-control" name="deliveryDate">
                                            </div>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Status</span>
                                                </div>
                                                <select name="changeStatus">
                                                    <option value="not ready">not ready</option>
                                                    <option value="ready">ready</option>
                                                    <option value="delivered">delivered</option>
                                                    <option value="not delivered">not delivered</option>
                                                </select>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="hidden" name="changeId" value="${ element.order.id }"/>
                                                <input type="hidden" name="command" value="change_order">
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
                        <td>
                            <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                                    data-target="#myModalProdDel${ element.id }">
                                Delete
                            </button>
                            <div class="modal fade" id="myModalProdDel${ element.id }">
                                <div class="modal-dialog modal-dialog-centered modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Do you want to remove the order_product from the database?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="controller" method="POST">
                                                <input type="hidden" name="delId" value="${ element.id }"/>
                                                <input type="hidden" name="command" value="delete_order_product">
                                                <input type="submit" class="btn btn-secondary" value="Delete">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Cancel
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
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
                        <td>
                            <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                                    data-target="#myModalProdDel${ element.id }">
                                Delete
                            </button>
                            <div class="modal fade" id="myModalProdDel${ element.id }">
                                <div class="modal-dialog modal-dialog-centered modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Do you want to remove the order_product from the database?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="controller" method="POST">
                                                <input type="hidden" name="delId" value="${ element.id }"/>
                                                <input type="hidden" name="command" value="delete_order_product">
                                                <input type="submit" class="btn btn-secondary" value="Delete">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Cancel
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>
    <ul class="pagination justify-content-center" style="margin:20px 0">
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_order_product&page=1">The first</a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_order_product_decrease_page&page=${page}&count=${count}"><<</a></li>
        <li class="pagination_number">
            <span class="pagination_number"><mark>&nbspPage <c:out value="${ page }"/> from <c:out value="${ count }"/>&nbsp</mark></span>
        </li>
        <li class="page-item">
            <a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_order_product_increase_page&page=${page}&count=${count}">>></a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=admin_order_product&page=${count}">The last</a></li>
    </ul>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>