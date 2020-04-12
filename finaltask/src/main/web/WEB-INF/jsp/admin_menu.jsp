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
<div class="container-fluid">
    <ul class="nav">
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=show_main_page">Return to the
                homepage</a>
        </li>
        <li class="nav-item">
            <a class="link_acc nav-link" href="${request.contextPath}controller?command=log_out">Exit</a>
        </li>
    </ul>
    <div class="btn-group">
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="admin_pies">
            <input type="hidden" name="piePage" value="1">
            <input type="submit" class="change-info btn btn-primary" value="Pie">
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="admin_users">
            <input type="hidden" name="page" value="1">
            <input type="submit" class="change-info btn btn-primary" value="User">
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="admin_feedback">
            <input type="submit" class="change-info btn btn-primary" value="Feedback">
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="admin_order">
            <input type="submit" class="change-info btn btn-primary" value="Order">
        </form>
        <form action="controller" method="POST">
            <input type="hidden" name="command" value="admin_order_product">
            <input type="submit" class="change-info btn btn-primary" value="OrderProduct">
        </form>
        <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModalNewOrder">
            Add new Order
        </button>
        <div class="modal fade" id="#myTopModalNewOrder">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Enter userId</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form action="controller" method="POST">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Enter Id</span>
                                </div>
                                <input type="text" class="form-control" name="userForOrderId">
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" name="command" value="admin_add_new_user_for_order">
                                <input type="submit" value="Add order" class="btn btn-secondary">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>