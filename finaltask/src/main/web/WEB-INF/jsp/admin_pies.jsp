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
    <h2>Pies:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal3">
                Add new pie
            </button>
            <div class="modal fade" id="myTopModal3">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Add new pie</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Picture</span>
                                    </div>
                                    <input type="text" class="form-control" name="savePicture">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Name</span>
                                    </div>
                                    <input type="text" class="form-control" name="saveName">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Weight</span>
                                    </div>
                                    <input type="text" class="form-control" name="saveWeight">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Price</span>
                                    </div>
                                    <input type="text" class="form-control" name="savePrice">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Description</span>
                                    </div>
                                    <input type="text" class="form-control" name="saveDescription">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="save_pie">
                                    <input type="submit" value="Add pie" class="btn btn-secondary">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal4">
                Find pie by id
            </button>
            <div class="modal fade" id="myTopModal4">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find pie</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter Id</span>
                                    </div>
                                    <input type="text" class="form-control" name="pieId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_pie_by_id">
                                    <input type="submit" value="Find pie" class="btn btn-secondary">
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
                Find pie by name
            </button>
            <div class="modal fade" id="myTopModal5">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find pie</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter id</span>
                                    </div>
                                    <input type="text" class="form-control" name="pieName">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_pie_by_name">
                                    <input type="submit" value="Find pie" class="btn btn-secondary">
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
                <input type="hidden" name="command" value="admin_pies">
                <input type="submit" class="change-info btn btn-primary" value="Show all pies">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Picture</th>
            <th>Name</th>
            <th>Weight</th>
            <th>Price</th>
            <th>Description</th>
            <th>Action</th>
            <th></th>
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
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                            data-target="#myModal${ element.id }">
                        Delete
                    </button>
                    <div class="modal fade" id="myModal${ element.id }">
                        <div class="modal-dialog modal-dialog-centered modal-sm">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Do you want to remove the pie from the database?
                                </div>
                                <div class="modal-footer">
                                    <form action="controller" method="POST">
                                        <input type="hidden" name="delId" value="${ element.id }"/>
                                        <input type="hidden" name="command" value="delete_pie">
                                        <input type="submit" class="btn btn-secondary" value="Delete">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                            data-target="#mySecModal${ element.id }">
                        Change
                    </button>
                    <div class="modal fade" id="mySecModal${ element.id }">
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
                                                <span class="input-group-text">New picture</span>
                                            </div>
                                            <input type="text" class="form-control" name="changePicture">
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">New name</span>
                                            </div>
                                            <input type="text" class="form-control" name="changeName">
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">New weight</span>
                                            </div>
                                            <input type="text" class="form-control" name="changeWeight">
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">New price</span>
                                            </div>
                                            <input type="text" class="form-control" name="changePrice">
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">New description</span>
                                            </div>
                                            <input type="text" class="form-control" name="changeDescription">
                                        </div>
                                        <div class="modal-footer">
                                            <input type="hidden" name="changeId" value="${ element.id }"/>
                                            <input type="hidden" name="command" value="change_pie">
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