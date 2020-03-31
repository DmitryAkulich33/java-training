package by.epam.bakery.controller.command.impl.user;

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

public class DeletePieFromBasketCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String USER = "user";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        Pie pie = null;
        try {
            pie = serviceFactory.getPieService().findPieById(pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        Basket basket;
        double total = 0.0;
        int basketId = 0;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            basketId = basket.getId();
            total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal(total - pie.getPrice(), basketId);
            serviceFactory.getBasketProductService().deleteBasketProductByPieId(basketId, pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_basket");
    }
}
