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
    <title>Registration</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
    <a class="link_acc nav-link" href="${request.contextPath}controller?command=show_main_page">Return to the
        homepage</a>
    <br>
    <form action="controller" method="POST">
        <div class="wrong_message">
            <p><c:out value="${ message }"/></p>
        </div>
        <table class="table table-striped">
            <tbody>
            <tr>
                <td>
                    Enter your login (English)</span>
                </td>
                <td>
                    <input type="text" class="form-control" name="saveLogin" placeholder="5-12 symbols"
                           pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongLogin }"/></div>
                    <div class="right_message"><c:out value="${ rightLogin }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your password (English)
                </td>
                <td>
                    <input type="password" class="form-control" name="savePassword" placeholder="5-12 symbols"
                           pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongPassword }"/></div>
                    <div class="right_message"><c:out value="${ rightPassword }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your surname
                </td>
                <td>
                    <input type="text" class="form-control" name="saveSurname" placeholder="max 70 symbols"
                           pattern="(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)"
                           required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongSurname }"/></div>
                    <div class="right_message"><c:out value="${ rightSurname }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your name
                </td>
                <td>
                    <input type="text" class="form-control" name="saveName" placeholder="max 70 symbols"
                           pattern="(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)"
                           required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongName }"/></div>
                    <div class="right_message"><c:out value="${ rightName }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your patronymic
                </td>
                <td>
                    <input type="text" class="form-control" name="savePatronymic" placeholder="max 70 symbols"
                           pattern="(^[A-Z][a-z]{0,35}(-[A-Z])*[a-z]{0,35}$)|(^[А-Я][а-я]{0,35}(-[А-Я])*[а-я]{0,35}$)|(^[A-Z][a-z]{0,70}$)|(^[А-Я][а-я]{0,70}$)"
                           required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongPatronymic }"/></div>
                    <div class="right_message"><c:out value="${ rightPatronymic }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your address
                </td>
                <td>
                    <input type="text" class="form-control" name="saveAddress" placeholder="5-70 symbols"
                           pattern="(^.{5,70}$)" required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongAddress }"/></div>
                    <div class="right_message"><c:out value="${ rightAddress }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter your phone
                </td>
                <td>
                    <input type="text" class="form-control" name="savePhone" placeholder="8-044-1234567"
                           pattern="(^[8]-(033|029|044|017)-[1-9][0-9]{2}-[0-9]{2}-[0-9]{2}$)" required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongPhone }"/></div>
                    <div class="right_message"><c:out value="${ rightPhone }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                    Enter note
                </td>
                <td>
                    <input type="text" class="form-control" name="saveNote" placeholder="max 250 symbols"
                           pattern="(^.{0,250}$)" required>
                </td>
                <td>
                    <div class="wrong_message"><c:out value="${ wrongNote }"/></div>
                    <div class="right_message"><c:out value="${ rightNote }"/></div>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <div class="modal-footer">
                        <input type="hidden" name="command" value="registration_user">
                        <input type="submit" value="Finish registration" class="btn btn-secondary">
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="../common/footer.jsp"/>
    </div>
</div>
</body>
</html>