<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XML PARSING</title>
</head>
<body>
<p>Choose the type of parser:</p>
<br>
<form action="choose" method="POST" enctype="multipart/form-data">
    <%--    <form action="choose" method="POST">--%>
    <input type="file" name="data" />
    <br>
    <input type="radio" id="sax" name="parser" value="sax">
    <label for="sax">SAX</label><br>
    <input type="radio" id="stax" name="parser" value="stax">
    <label for="stax">StAX</label><br>
    <input type="radio" id="dom" name="parser" value="dom">
    <label for="dom">DOM</label>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>