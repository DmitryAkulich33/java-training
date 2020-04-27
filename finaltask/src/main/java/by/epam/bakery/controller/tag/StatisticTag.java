package by.epam.bakery.controller.tag;

import by.epam.bakery.controller.tag.exception.TagException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class StatisticTag extends TagSupport {

    @Override
    public int doStartTag() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String amountUser;
        String amountOrders;
        String ordersCost;
        try {
            int clients = serviceFactory.getUserService().findClientAmount();
            amountUser = "<p>Number of registered users: <strong>" + clients + "!</strong></p>";
        } catch (ServiceException e) {
            amountUser = "";
        }
        try {
            int orders = serviceFactory.getOrderService().findOrdersAmount();
            amountOrders = "<p>Number of delivered orders: <strong>" + orders + "!</strong></p>";
        } catch (ServiceException e) {
            amountOrders = "";
        }
        try {
            int ordersSum = serviceFactory.getOrderService().findOrdersCost();
            ordersCost = "<p>The total amount of orders is: <strong>" + ordersSum + "0 RUB!</strong></p>";
        } catch (ServiceException e) {
            ordersCost = "";
        }
        JspWriter out = pageContext.getOut();
        try {
            out.write(amountUser + amountOrders + ordersCost);
        } catch (IOException e) {
            throw new TagException(e);
        }
        return SKIP_BODY;
    }
}
