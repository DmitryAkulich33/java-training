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

public class PersonalAccountDecreasePageCommand implements Command {
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
        int userId = user.getId();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int decreasePage = currentPage - 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<OrderProduct> orderProducts;
        if (decreasePage >= 1) {
            try {
                orderProducts = serviceFactory.getOrderProductService().findLimitOrderProductByUserId(userId, (decreasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, decreasePage);
        } else {
            try {
                orderProducts = serviceFactory.getOrderProductService().findLimitOrderProductByUserId(userId, (currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        return CommandResult.forward("/WEB-INF/jsp/personal_account.jsp");
    }
}
