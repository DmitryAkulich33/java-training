<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="rdct" uri="/WEB-INF/tld/RedirectTag.tld" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pie" class="by.epam.bakery.domain.Pie" scope="application"/>
<%--<jsp:useBean id="basket" class="by.epam.bakery.domain.Basket" scope="application"/>--%>
<%--<jsp:useBean id="user" class="by.epam.bakery.domain.User" scope="application"/>--%>
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
    <title>Bakery</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="login.jsp"/>
<jsp:include page="menu.jsp"/>
<div class="container-fluid pt-3">
    <br>
    <div>
        <button type="button" class="dropdown_sort btn btn-primary" data-toggle="dropdown">
            Sort by
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${request.contextPath}controller?command=sort_by_increase_price">price
                increase</a>
            <a class="dropdown-item" href="${request.contextPath}controller?command=sort_by_reduction_price">price
                reduction</a>
        </div>
    </div>
    <ul class="ul_pie">
        <c:forEach var="element" items="${pies}" varStatus="status">
            <li class="li_pie">
                <table class="table_pie">
                    <tr>
                        <td class="product_width" rowspan="5"><img class="image_pie rounded"
                                                                   src="<c:out value="${ element.picture }"/>">
                        </td>
                        <td class="product_name"><c:out value="${ element.name }"/></td>
                    <tr>
                        <td class="product_description"><c:out value="${ element.description }"/></td>
                    </tr>
                    <tr>
                        <td class="product_weight"><c:out value="${ element.weight }"/> gramm</td>
                    </tr>
                    <tr>
                        <td class="product_price">
                            <mark><c:out value="${ element.price }"/>0 BYN</mark>
                        </td>
                    </tr>
                    <tr>
                        <c:choose>
                            <c:when test="${user.role == 3}">
                                <td class="button_navbar_menu">
                                    <form action="controller" method="POST">
                                        <input type="hidden" name="pieId" value="${ element.id }"/>
                                        <input type="hidden" name="piePrice" value="${ element.price }"/>
                                        <input type="hidden" name="command" value="add_pie">
                                        <input type="submit" name="button" class="in_basket" value="TO BASKET"/>
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td class="button_navbar_menu">
                                    <input type="submit" name="button" class="in_basket" value="TO BASKET"
                                           data-toggle="modal" data-target="#myModalBasket"/>
                                    <div class="modal fade" id="myModalBasket">
                                        <div class="modal-dialog modal-dialog-centered modal-sm">
                                            <div class="modal-content">
                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;
                                                    </button>
                                                </div>
                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                    You need to log in as a user!
                                                </div>
                                                <!-- Modal footer -->
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">Close
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
            </li>
        </c:forEach>
    </ul>
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>