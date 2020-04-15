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
    <title>Personal account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <ul class="nav">
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=show_main_page">Return to the homepage</a>
        </li>
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=log_out">Exit</a>
        </li>
    </ul>
    <br>
    <h2>Personal Information:</h2>
    <br>
    <table class="table table-striped">
        <tbody>
        <tr>
            <td>Surname:</td>
            <td><c:out value="${ user.surname }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal">
                    Change information
                </button>
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Change surname</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="controller" method="POST">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">New surname</span>
                                        </div>
                                        <input type="text" class="form-control" name="newSurname">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="command" value="change_surname">
                                        <input type="submit" value="Change" class="btn btn-secondary">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><c:out value="${ user.name }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal2">
                    Change information
                </button>
                <div class="modal fade" id="myModal2">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Change name</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="controller" method="POST">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">New name</span>
                                        </div>
                                        <input type="text" class="form-control" name="newName">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="command" value="change_name">
                                        <input type="submit" value="Change" class="btn btn-secondary">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>Patronymic:</td>
            <td><c:out value="${ user.patronymic }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal3">
                    Change information
                </button>
                <div class="modal fade" id="myModal3">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Change patronymic</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="controller" method="POST">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">New patronymic</span>
                                        </div>
                                        <input type="text" class="form-control" name="newPatronymic">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="command" value="change_patronymic">
                                        <input type="submit" value="Change" class="btn btn-secondary">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><c:out value="${ user.address }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal4">
                    Change information
                </button>
                <div class="modal fade" id="myModal4">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Change address</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="controller" method="POST">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">New address</span>
                                        </div>
                                        <input type="text" class="form-control" name="newAddress">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="command" value="change_address">
                                        <input type="submit" value="Change" class="btn btn-secondary">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><c:out value="${ user.phone }"/></td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal5">
                    Change information
                </button>
                <div class="modal fade" id="myModal5">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Change phone</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form action="controller" method="POST">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">New phone</span>
                                        </div>
                                        <input type="text" class="form-control" name="newPhone">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" name="command" value="change_phone">
                                        <input type="submit" value="Change" class="btn btn-secondary">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container-fluid">
    <br>
    <h2>Order history:</h2>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Status</th>
            <th>production date</th>
            <th>delivery date</th>
            <th>total</th>
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
                    </tr>
                    </thead>
                    <thead>
                    <tr>
                        <th><c:out value="${ element.order.id }"/></th>
                        <th><mark><c:out value="${ element.order.status.toString().replace(\"_\", \" \") }"/></mark></th>
                        <th><mark><c:out value="${ element.order.productionDate.toString().replace(\"T\", \" \") }"/></mark></th>
                        <th><mark><c:out value="${ element.order.deliveryDate.toString().replace(\"T\", \" \") }"/></mark></th>
                        <th><c:out value="${ element.order.total }"/>0 BYN</th>
                    </tr>
                    </thead>
                    <tr>
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
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=personal_account&page=1">The first</a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=personal_account_decrease_page&page=${page}&count=${count}"><<</a></li>
        <li class="pagination_number">
            <span class="pagination_number"><mark>&nbspPage <c:out value="${ page }"/> from <c:out value="${ count }"/>&nbsp</mark></span>
        </li>
        <li class="page-item">
            <a class="pagination_color page-link" href="${request.contextPath}controller?command=personal_account_increase_page&page=${page}&count=${count}">>></a></li>
        <li class="page-item"><a class="pagination_color page-link" href="${request.contextPath}controller?command=personal_account&page=${count}">The last</a></li>
    </ul>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>