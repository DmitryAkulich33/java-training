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
    <br>
    <h2>Order products:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal4">
                Find products by user id
            </button>
            <div class="modal fade" id="myTopModal4">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find products</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter id</span>
                                    </div>
                                    <input type="text" class="form-control" name="userId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_order_product_by_user_id">
                                    <input type="submit" value="Find products" class="btn btn-secondary">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal5">
                Find products by order id
            </button>
            <div class="modal fade" id="myTopModal5">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find products</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter id</span>
                                    </div>
                                    <input type="text" class="form-control" name="orderId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_order_product_by_order_id">
                                    <input type="submit" value="Find products" class="btn btn-secondary">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="admin_order_product">
                <input type="submit" class="change-info btn btn-primary" value="Show all products">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Order id</th>
            <th>Pie id</th>
            <th>Pie name</th>
            <th>Pie Price</th>
            <th>Action</th>
        </tr>
        </thead>
                <c:forEach var="element" items="${orderProducts}" varStatus="status">
                    <tr>
                        <td><c:out value="${ element.id }"/></td>
                        <td><c:out value="${ element.order.id }"/></td>
                        <td><c:out value="${ element.pie.id }"/></td>
                        <td><c:out value="${ element.pie.name }"/></td>
                        <td><c:out value="${ element.pie.price }"/></td>
                        <td>
                            <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                                    data-target="#myModal${ element.id }">
                                Delete
                            </button>
                            <div class="modal fade" id="myModal${ element.id }">
                                <div class="modal-dialog modal-dialog-centered modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            Do you want to remove the order_product from the database?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="controller" method="POST">
                                                <input type="hidden" name="delId" value="${ element.id }"/>
                                                <input type="hidden" name="command" value="delete_order">
                                                <input type="submit" class="btn btn-secondary" value="Delete">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
    </table>
</div>

<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>