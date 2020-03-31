<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="by.epam.bakery.domain.User" scope="application"/>
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
    <title>My basket</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="login.jsp"/>
<jsp:include page="menu.jsp"/>
<div class="container-fluid mt-3">
    <br>
    <br>
    <h2>My basket:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="add_order">
                <input type="submit" class="change-info btn btn-primary" value="To order">
            </form>
        </li>
        <li class="li_admin nav-item">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="clear_basket">
                <input type="submit" class="change-info btn btn-primary" value="Clear basket">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Pie</th>
            <th>Name</th>
            <th>Weight</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="element" items="${basketProducts}" varStatus="status">
            <tr>
                <td><img class="image_pie_basket" src="<c:out value="${ element.picture }"/>"></td>
                <td><c:out value="${ element.name }"/></td>
                <td><c:out value="${ element.weight }"/> gramm</td>
                <td><c:out value="${ element.price }"/>0 BYN</td>
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModalFeed${ element.id }">
                        Delete
                    </button>
                    <div class="modal fade" id="myModalFeed${ element.id }">
                        <div class="modal-dialog modal-dialog-centered modal-sm">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Do you want to remove the pie from the basket?
                                </div>
                                <form action="controller" method="POST">
                                    <div class="modal-footer">
                                        <input type="hidden" name="feedbackId" value="${ element.id }"/>
                                        <input type="hidden" name="command" value="delete_pie_from_basket">
                                        <input type="submit" class="btn btn-secondary" value="Delete">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                Total:
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
                <c:out value="${ total }0 BYN"/>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>