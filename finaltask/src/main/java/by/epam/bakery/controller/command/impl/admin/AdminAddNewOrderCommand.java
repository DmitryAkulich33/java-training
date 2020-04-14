package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AdminAddNewOrderCommand implements Command {
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String PIES = "pies";
    private static final String TOTAL = "total";
    private static final String BASKET_PRODUCTS = "basketProducts";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        List<Pie> pies;
        try {
            pies = serviceFactory.getPieService().showAllPies();
            request.setAttribute(PIES, pies);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            double total = basket.getTotal();
            if(total == 0) {
                request.setAttribute(TOTAL, total);
            } else {
                List<Pie> basketProducts = serviceFactory.getPieService().findPieByBasketId(basketId);
                request.setAttribute(TOTAL, total);
                request.setAttribute(BASKET_PRODUCTS, basketProducts);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.forward("/WEB-INF/jsp/admin_add_new_order.jsp");
    }
}