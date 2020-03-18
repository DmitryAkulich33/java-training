package by.epam.bakery.controller.command.impl;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePatronymicCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_PATRONYMIC = "newPatronymic";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newPatronymic = request.getParameter(NEW_PATRONYMIC);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changePatronymic(newPatronymic, userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        user.setPatronymic(newPatronymic);
        session.setAttribute(USER, user);
        return CommandResult.redirect(request.getContextPath() + "controller?command=personal_account");
    }
}

