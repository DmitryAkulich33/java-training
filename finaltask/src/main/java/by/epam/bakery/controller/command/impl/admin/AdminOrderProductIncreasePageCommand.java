package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrderProductIncreasePageCommand implements Command {
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int increasePage = currentPage + 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<OrderProduct> orderProducts;
        if (increasePage <= count) {
            try {
                orderProducts = serviceFactory.getOrderProductService().findLimitOrderProduct((increasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, increasePage);
        } else {
            try {
                orderProducts= serviceFactory.getOrderProductService().findLimitOrderProduct((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        return CommandResult.forward("/WEB-INF/jsp/admin_order_product.jsp");
    }
}
