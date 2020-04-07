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
<jsp:include page="admin_menu.jsp"/>
<div class="container-fluid">
    <br>
    <br>
    <h2>Orders:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModalStat">
                Show order with status
            </button>
            <div class="modal fade" id="myModalStat">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Choose orders with necessary status</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Status</span>
                                    </div>
                                    <select name="status">
                                        <option value="not ready">not ready</option>
                                        <option value="ready">ready</option>
                                        <option value="delivered">delivered</option>
                                        <option value="not delivered">not delivered</option>
                                    </select>
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="courier_choose_order_status">
                                    <input type="submit" class="btn btn-secondary" value="Find orders">
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
                <input type="hidden" name="command" value="courier_order">
                <input type="submit" class="change-info btn btn-primary" value="Show all orders">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>User id</th>
            <th>User surname</th>
            <th>User name</th>
            <th>User patronymic</th>
            <th>Total</th>
            <th>Production date</th>
            <th>Delivery date</th>
            <th>Order status</th>
            <th>Action</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="element" items="${orders}" varStatus="status">
            <tr>
                <td><c:out value="${ element.id }"/></td>
                <td><c:out value="${ element.user.id }"/></td>
                <td><c:out value="${ element.user.surname }"/></td>
                <td><c:out value="${ element.user.name }"/></td>
                <td><c:out value="${ element.user.patronymic }"/></td>
                <td><c:out value="${ element.total }"/></td>
                <td><c:out value="${ element.productionDate.toString().replace(\"T\", \" \") }"/></td>
                <td><c:out value="${ element.deliveryDate.toString().replace(\"T\", \" \") }"/></td>
                <td><c:out value="${ element.status.toString().replace(\"_\", \" \") }"/></td>
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                            data-target="#mySecModal${ element.id }">
                        Change status
                    </button>
                    <div class="modal fade" id="mySecModal${ element.id }">
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
                                            <input type="hidden" name="changeId" value="${ element.id }"/>
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