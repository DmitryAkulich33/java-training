package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAddPieToOrderCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIE_PRICE = "piePrice";
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String PIE_AMOUNT = "pieAmount";
    private static final String RIGHT_AMOUNT = "rightAmount";
    private static final String WRONG_AMOUNT = "wrongAmount";
    private static final String WRONG_AMOUNT_MESSAGE = "The number of pies is wrong";
    private static final String RIGHT_AMOUNT_MESSAGE = "Product added to basket";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
        String amount = request.getParameter(PIE_AMOUNT);
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, amount, piePrice);
            int pieAmount = Integer.parseInt(amount);
            double cost = pieAmount * piePrice;
            double total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal((total + cost), basketId);
        } catch (ValidatorException ex){
            request.setAttribute(WRONG_AMOUNT, WRONG_AMOUNT_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
        }
        catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(RIGHT_AMOUNT, RIGHT_AMOUNT_MESSAGE);
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
