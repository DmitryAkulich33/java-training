package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.validator.factory.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPieCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIE_PRICE = "piePrice";
    private static final String PIE_AMOUNT = "pieAmount";
    private static final String USER = "user";
    private static final String RIGHT_AMOUNT = "rightAmount";
    private static final String WRONG_AMOUNT = "wrongAmount";
    private static final String WRONG_AMOUNT_MESSAGE = "The number of pies is wrong";
    private static final String RIGHT_AMOUNT_MESSAGE = "Product added to basket";
    private static final String ADDED_PIE_ID = "addedPieId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ValidatorFactory validatorFactory = new ValidatorFactory();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String amount = request.getParameter(PIE_AMOUNT);
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        request.setAttribute(ADDED_PIE_ID, pieId);
        if(!validatorFactory.getPieDataValidator().isPieAmountValid(amount)){
            request.setAttribute(WRONG_AMOUNT, WRONG_AMOUNT_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
        }
        int pieAmount = Integer.parseInt(amount);
        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
        double cost = pieAmount * piePrice;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            int basketId = basket.getId();
            double total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal((total + cost), basketId);
            serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, pieAmount, cost);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(RIGHT_AMOUNT, RIGHT_AMOUNT_MESSAGE);
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
