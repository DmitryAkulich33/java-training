package by.epam.bakery.controller.command.impl.order;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

public class AddOrderCommand implements Command {
    private static final String USER = "user";
    private static final String TOTAL = "total";
    private static final String BASKET = "basket";
    private static final String BASKET_PRODUCT = "basketProducts";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        Basket basket;
        double total = 0.0;
        int basketId = 0;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            basketId = basket.getId();
            total = basket.getTotal();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (total == 0) {
            return CommandResult.forward("/WEB-INF/jsp/basket.jsp");
        } else {
            try {
                serviceFactory.getOrderService().save(userId, total, null, null, StatusEnum.NOT_READY.getValue());
                Order order = serviceFactory.getOrderService().findLastOrderByUserId(userId);
                int orderId = order.getId();
                List<Pie> pies = serviceFactory.getPieService().findPieByBasketId(basketId);
                for(Pie pie: pies){

                }

//                List<Pie> basketProducts = serviceFactory.getPieService().findPieByBasketId(basketId);
//                session.setAttribute(TOTAL, total);
//                session.setAttribute(BASKET_PRODUCT, basketProducts);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

        return CommandResult.redirect(request.getContextPath() + "controller?command=clear_basket");
    }
}
