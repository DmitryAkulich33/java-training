package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAddNewUserForOrder implements Command {
    private static final String USER_FOR_ORDER_ID = "userForOrderId";
    private static final String USER_FOR_ORDER = "userForOrder";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter(USER_FOR_ORDER_ID));
        User user;
        try {
            user = serviceFactory.getUserService().findClientById(userId);
            session.setAttribute(USER_FOR_ORDER, user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
