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

public class AdminDeletePieFromOrderCommand implements Command {
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String PIE_ID_FOR_DELETE = "pieIdForDelete";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();

        int pieId = Integer.parseInt(request.getParameter(PIE_ID_FOR_DELETE));
        Pie pie = null;
        try {
            pie = serviceFactory.getPieService().findPieById(pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        Basket basket;
        double total;
        int basketId;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            basketId = basket.getId();
            total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal(total - pie.getPrice(), basketId);
            serviceFactory.getBasketProductService().deleteBasketProductByPieId(basketId, pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
