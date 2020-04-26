<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Add new order</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <a class="link_acc nav-link" href="${request.contextPath}controller?command=admin_account">Return</a>
    <table class="table table-striped">
        <tbody>
        <tr>
            <td>User id is <c:out value="${ userForOrder.id }"/>, <c:out value="${ userForOrder.surname }"/> <c:out
                    value="${ userForOrder.name }"/> <c:out value="${ userForOrder.patronymic }"/></td>
        </tr>
        </tbody>
    </table>
    <br>
    <div>
        New order:
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Pie id</th>
            <th>Pie name</th>
            <th>Pie price</th>
            <th>Amount</th>
            <th>Cost</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="element" items="${basketProducts}" varStatus="status">
            <tr>
                <td><c:out value="${ element.pie.id }"/></td>
                <td><c:out value="${ element.pie.name }"/></td>
                <td><c:out value="${ element.pie.price }"/>0 BYN</td>
                <td>x<c:out value="${ element.amount }"/></td>
                <td><c:out value="${ element.cost }"/>0 BYN</td>
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                            data-target="#myModalAdd${ element.id }">
                        Delete
                    </button>
                    <div class="modal fade" id="myModalAdd${ element.id }">
                        <div class="modal-dialog modal-dialog-centered modal-sm">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Do you want to remove the pie from the basket?
                                </div>
                                <form action="controller" method="POST">
                                    <div class="modal-footer">
                                        <input type="hidden" name="basketProductId" value="${ element.id }"/>
                                        <input type="hidden" name="productCost" value="${ element.cost }"/>
                                        <input type="hidden" name="basketId" value="${ element.basket.id }"/>
                                        <input type="hidden" name="basketTotal" value="${ element.basket.total }"/>
                                        <input type="hidden" name="command" value="admin_delete_pie_from_order">
                                        <input type="submit" class="btn btn-secondary" value="Delete">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
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
            </td>
            <td>
            </td>
            <td>
            </td>
            <td>
                Total:
            </td>
            <td>
                <c:out value="${ total }0 BYN"/>
            </td>
            <td>
                <form action="controller" method="POST">
                    <input type="hidden" name="command" value="admin_product_to_order">
                    <input type="hidden" name="total" value="${ total }">
                    <input type="submit" class="change-info btn btn-primary" value="TO ORDER">
                </form>
            </td>
        </tr>
    </table>
    <br>
    <br>
</div>
<div class="container-fluid pt-3">
    <div>
        Our pies:
    </div>
    <br>
    <div class="wrong_message"><c:out value="${ wrong }"/></div>
    <div class="right_message"><c:out value="${ right }"/></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Picture</th>
            <th>Name</th>
            <th>Weight</th>
            <th>Price</th>
            <th>Description</th>
            <th>Amount</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="element" items="${pies}" varStatus="status">
            <tr>
                <td><c:out value="${ element.id }"/></td>
                <td><img class="image_pie_basket" src="<c:out value="${ element.picture }"/>"></td>
                <td><c:out value="${ element.name }"/></td>
                <td><c:out value="${ element.weight }"/></td>
                <td><c:out value="${ element.price }"/></td>
                <td><c:out value="${ element.description }"/></td>
                <form action="controller" method="POST">
                    <td class="product_amount">
                        <input type="text" name="pieAmount"
                               class="input_center">
                    </td>
                    <td>
                        <input type="hidden" name="pieId" value="${ element.id }">
                        <input type="hidden" name="piePrice" value="${ element.price }">
                        <input type="hidden" name="command" value="admin_add_pie_to_order">
                        <input type="submit" class="change-info btn btn-primary" value="Add to basket">
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="../common/footer.jsp"/>
    </div>
</div>
</body>
</html>