package by.epam.bakery.controller.command.impl.order;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddOrderCommand implements Command {
    private static final String USER = "user";
    private static final String TOTAL = "total";
    private static final String BASKET = "basket";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        double total = (double) session.getAttribute(TOTAL);
        try {
            serviceFactory.getOrderService().save(user.getId(), total, null, null, StatusEnum.NOTREADY.getValue());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        Basket basket = new Basket();
        session.setAttribute(BASKET, basket);
        session.setAttribute(TOTAL, null);
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
