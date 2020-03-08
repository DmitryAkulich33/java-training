<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pie" class="by.epam.bakery.domain.Pie" scope="application"/>
<jsp:useBean id="basket" class="by.epam.bakery.domain.Basket" scope="application"/>
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
<jsp:include page="header.jsp" />
<div class="container-fluid pt-3">
    <div class="row">
        <ul class="ul_pages">
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="about.jsp" class="a_link"><img src="image/group.png" class="ico"> ABOUT US</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="bakery_menu.html" class="a_link"><img src="image/magazine.png" class="ico"> OUR
                        PIES</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="bakery_contacts.html" class="a_link"><img src="image/hours.png" class="ico"> CONTACTS</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="bakery_delivery.html" class="a_link"><img src="image/runner.png" class="ico"> DELIVERY</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="bakery_feedback.html" class="a_link"><img src="image/pen.png" class="ico">
                        FEEDBACK</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">

                        <button type="button" class="in_basket_menu h5" data-toggle="modal" data-target="#myModal">
                            <a href="#" class="a_link"><img src="image/basket.png" class="ico"> BASKET</a>
                        </button>

                    <div class="modal fade" id="myModal">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Your basket:</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <table class="text_basket">
                                        <c:forEach var="elem" items="${basket.pies}" varStatus="status">
                                            <tr>
                                                <td>Pie is <c:out value="${ elem.name }" />, price is <c:out value="${ elem.price}" /></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">To order
                                    </button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </li>
        </ul>
    </div>
    <br>
    <ul class="ul_pie">
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Belarus.png">
                    </td>
                    <td class="product_name">Belorussian</td>
                <tr>
                    <td class="product_description">Signature dough, rustic potatoes, with cracklings, fried mushrooms,
                        caraway seeds and coriander
                    </td>
                </tr>
                <tr>
                    <td class="product_weight">1,0 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>24.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <form action="addPie" method="POST">
                            <input type="hidden" name="pieName" value="Belorussian"/>
                            <input type="hidden" name="piePrice" value="24.00"/>
                            <input type="submit" name="button" class="in_basket" value="BUY"/>

                        </form>

                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Ital.png"></td>
                    <td class="product_name">Italian</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough, sunny lemon with vitamin zest and peppermint</td>
                </tr>
                <tr>
                    <td class="product_weight">0,95 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>22.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <form action="addPie" method="POST">
                            <input type="hidden" name="pieName" value="Italian"/>
                            <input type="hidden" name="piePrice" value="22.00"/>
                            <input type="submit" name="button" class="in_basket" value="BUY"/>

                        </form>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Germ.jpg"></td>
                    <td class="product_name">Deutsch</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough, juicy flavored strawberries with ricotta</td>
                </tr>
                <tr>
                    <td class="product_weight">1,05 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>26.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/france.png">
                    </td>
                    <td class="product_name">French</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough, ripe spicy cherry with hints of clove</td>
                </tr>
                <tr>
                    <td class="product_weight">1,0 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>25.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Belg.png"></td>
                    <td class="product_name">Belgian</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough with delicate, fragrant raspberries</td>
                </tr>
                <tr>
                    <td class="product_weight">0,9 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>20.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Goland.png">
                    </td>
                    <td class="product_name">Dutch</td>
                </tr>
                <tr>
                    <td class="product_description">Signature Dough, Flavored Hazelnut Poppy</td>
                </tr>
                <tr>
                    <td class="product_weight">1,0 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>27.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/grec2.png">
                    </td>
                    <td class="product_name">Greek</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough, flavored blackberries in cream cheese</td>
                </tr>
                <tr>
                    <td class="product_weight">1,1 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>28.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
        <li class="li_pie">
            <table class="table_pie">
                <tr>
                    <td class="product_width" rowspan="5"><img class="image_pie rounded" src="image/Irla.png"></td>
                    <td class="product_name">Irish</td>
                </tr>
                <tr>
                    <td class="product_description">Signature dough, stewed carrots with pumpkin in soft cheese, with
                        onions
                        and celery
                    </td>
                </tr>
                <tr>
                    <td class="product_wight">1,0 kg.</td>
                </tr>
                <tr>
                    <td class="product_price">
                        <mark>25.00 BYN</mark>
                    </td>
                </tr>
                <tr>
                    <td class="button_navbar_menu">
                        <button class="in_basket" type="button">
                            <span class="txt">BUY</span>
                            <span class="ico"></span>
                        </button>
                    </td>
                </tr>
            </table>
        </li>
    </ul>
    <div class="footer">
        <jsp:include page="footer.jsp" />
    </div>

</div>
</body>
</html>