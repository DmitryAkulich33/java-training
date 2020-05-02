package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPieCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIE_PRICE = "piePrice";
    private static final String PIE_AMOUNT = "pieAmount";
    private static final String USER = "user";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_AMOUNT_MESSAGE = "wrongAmount";
    private static final String RIGHT_AMOUNT_MESSAGE = "rightAmount";
    private static Logger log = LogManager.getLogger(AddOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding pie to basket started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String amount = request.getParameter(PIE_AMOUNT);
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, amount, piePrice);
            int pieAmount = Integer.parseInt(amount);
            double cost = pieAmount * piePrice;
            double total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal((total + cost), basketId);
            session.setAttribute(RIGHT, RIGHT_AMOUNT_MESSAGE);
        } catch (ValidatorException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            session.setAttribute(WRONG, WRONG_AMOUNT_MESSAGE);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Adding pie to basket finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
