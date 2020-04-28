package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminProductToOrder implements Command {
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final double TOTAL = 0.0;
    private static final String BASKET_TOTAL = "total";
    private static final String BASKET_PRODUCT = "basketProducts";
    private static Logger log = LogManager.getLogger(AdminProductToOrder.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding products to order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        int userId = user.getId();
        double basketTotal = Double.parseDouble(request.getParameter(BASKET_TOTAL));
        if (basketTotal == 0) {
            return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
        } else {
            try {
                serviceFactory.getOrderService().save(userId, basketTotal, null, null, StatusEnum.NOT_READY.getValue());
                Order order = serviceFactory.getOrderService().findLastOrderByUserId(userId);
                int orderId = order.getId();
                List<BasketProduct> basketProducts = (List<BasketProduct>) session.getAttribute(BASKET_PRODUCT);
                for(BasketProduct basketProduct: basketProducts){
                    serviceFactory.getOrderProductService().save(orderId, basketProduct.getPie().getId(), basketProduct.getAmount(), basketProduct.getCost());
                }
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        }
        session.removeAttribute(BASKET_PRODUCT);
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            serviceFactory.getBasketService().changeTotal(TOTAL, basketId);
            serviceFactory.getBasketProductService().deleteBasketProductByBasketId(basketId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Adding products to order finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
