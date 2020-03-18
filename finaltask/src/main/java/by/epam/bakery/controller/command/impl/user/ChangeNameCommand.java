package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeNameCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_NAME = "newName";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newName = request.getParameter(NEW_NAME);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeName(newName, userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        user.setName(newName);
        session.setAttribute(USER, user);
        return CommandResult.redirect(request.getContextPath() + "controller?command=personal_account");
    }
}
