package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminDeletePieFromOrderCommand implements Command {
    private static final String BASKET_PRODUCT_ID = "basketProductId";
    private static final String BASKET_PRODUCT_COST = "productCost";
    private static final String BASKET_ID = "basketId";
    private static final String BASKET_TOTAL = "basketTotal";
    private static Logger log = LogManager.getLogger(AdminDeletePieFromOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting pie from order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int basketProductId = Integer.parseInt(request.getParameter(BASKET_PRODUCT_ID));
        int basketId = Integer.parseInt(request.getParameter(BASKET_ID));
        double productCost = Double.parseDouble(request.getParameter(BASKET_PRODUCT_COST));
        double basketTotal = Double.parseDouble(request.getParameter(BASKET_TOTAL));
        try {
            serviceFactory.getBasketProductService().deleteBasketProductById(basketProductId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            serviceFactory.getBasketService().changeTotal(basketTotal - productCost, basketId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Deleting pie from order finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
