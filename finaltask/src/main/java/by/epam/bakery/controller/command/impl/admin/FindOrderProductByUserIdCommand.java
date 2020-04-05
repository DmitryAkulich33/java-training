package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindOrderProductByUserIdCommand implements Command {
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String USER_ID = "userId";


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<OrderProduct> orderProducts;
        int userId = Integer.parseInt(request.getParameter(USER_ID));
        try {
            orderProducts = serviceFactory.getOrderProductService().findByUserId(userId);
            request.setAttribute(ORDER_PRODUCTS, orderProducts);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.forward("/WEB-INF/jsp/admin_order_product.jsp");
    }
}
