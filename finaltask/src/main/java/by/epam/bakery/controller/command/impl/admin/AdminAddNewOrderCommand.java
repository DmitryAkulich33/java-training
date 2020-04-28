package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class AdminAddNewOrderCommand implements Command {
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String PIES = "pies";
    private static final String TOTAL = "total";
    private static final String BASKET_PRODUCT = "basketProducts";
    private static Logger log = LogManager.getLogger(AdminAddNewOrderCommand.class.getName());


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding a new order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        List<Pie> pies;
        try {
            pies = serviceFactory.getPieService().showAllPies();
            request.setAttribute(PIES, pies);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            double total = basket.getTotal();
            List<BasketProduct> basketProducts = serviceFactory.getBasketProductService().findProductByBasketId(basketId);
            session.setAttribute(BASKET_PRODUCT, basketProducts);
            request.setAttribute(TOTAL, total);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Adding a new order finished.");
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_add_new_order.jsp");
    }
}
