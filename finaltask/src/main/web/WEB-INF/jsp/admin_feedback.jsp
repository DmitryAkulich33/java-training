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
<div class="container">
    <br>
    <br>
    <h2>Feedbacks:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal4">
                Find feedbacks by user Id
            </button>
            <div class="modal fade" id="myModal4">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find feedback</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter user Id</span>
                                    </div>
                                    <input type="text" class="form-control" name="userId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_feedback_by_user">
                                    <input type="submit" class="btn btn-secondary" value="Find feedbacks">
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
                <input type="hidden" name="command" value="admin_feedback">
                <input type="submit" class="change-info btn btn-primary" value="Show all feedbacks">
            </form>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModalLast">
                Show the latest feedbacks
            </button>
            <div class="modal fade" id="myModalLast">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Enter amount of the latest feedbacks</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Amount</span>
                                    </div>
                                    <input type="text" class="form-control" name="amount">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="show_last_feedback">
                                    <input type="submit" class="btn btn-secondary" value="Find feedbacks">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
<%--        <li class="li_admin nav-item">--%>
<%--            <form action="controller" method="POST">--%>
<%--                <input type="hidden" name="command" value="show_ten_feedback">--%>
<%--                <input type="submit" class="change-info btn btn-primary" value="Show last 10">--%>
<%--            </form>--%>
<%--        </li>--%>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Surname</th>
            <th>Name</th>
            <th>UserId</th>
            <th>Date</th>
            <th>Review</th>
            <th>Action</th>
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
                    Delete
                </button>
                <div class="modal fade" id="myModalFeed${ element.id }">
                    <div class="modal-dialog modal-dialog-centered modal-sm">
                        <div class="modal-content">
                            <div class="modal-body">
                                Do you want to remove the feedback from the database?
                            </div>
                            <form action="controller" method="POST">
                                <div class="modal-footer">
                                    <input type="hidden" name="feedbackId" value="${ element.id }"/>
                                    <input type="hidden" name="command" value="delete_feedback">
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