package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PersonalAccountCommand implements Command {
    private static final String USER = "user";
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int page = Integer.parseInt(request.getParameter(PAGE));
        int userId = user.getId();
        List<OrderProduct> orderProducts;
        try {
            orderProducts = serviceFactory.getOrderProductService().findLimitOrderProductByUserId(userId, (page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(ORDER_PRODUCTS, orderProducts);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            int count = serviceFactory.getOrderService().findOrderByUserIdPageAmount(AMOUNT, userId);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
    }
}
