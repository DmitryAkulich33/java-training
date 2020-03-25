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
                            <form>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter user Id</span>
                                    </div>
                                    <input type="text" class="form-control">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary">Find feedbacks</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary">
                Show all feedbacks
            </button>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary">
                Show last 5
            </button>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary">
                Show last 10
            </button>
        </li>
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
            <br>
            <div class="feedback media border p-3">
                <div class="media-body">
                    <h4><c:out value="${ element.user.surname }"/> <c:out value="${ element.user.name }"/><small><i> posted
                        <c:out value="${ element.localDateTime.toString().replace(\"T\", \" \") }"/></i></small></h4>
                    <p><c:out value="${ element.review }"/></p>
                </div>
            </div>
        </c:forEach>
        
        <tr>
            <td>1</td>
            <td>Ivanov</td>
            <td>Ivan</td>
            <td>3</td>
            <td>2020-02-02T09:00:00</td>
            <td>I wanted to order pies to the office for my birthday party. I did it in the morning and I got my pies at lunchtime. They were hot and looked tasty. I liked Irish pie most of all, but my collegues liked Belgian and French. Irish pie was good for me, because I am a vegetarian and I like pumpkin very much. There was a lot of filling im the pies. My birhday party was excelent. 'TastyPie', thank you very much for your work. You are the best!</td>
            <td>
                <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myModal6">
                    Delete
                </button>
                <div class="modal fade" id="myModal6">
                    <div class="modal-dialog modal-dialog-centered modal-sm">
                        <div class="modal-content">
                            <div class="modal-body">
                                Do you want to remove the feedback from the database?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary">Delete</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
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