package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeSurnameCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_SURNAME = "newSurname";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_SURNAME_MESSAGE = "The new surname is wrong";
    private static final String RIGHT_SURNAME_MESSAGE = "The surname changed";
    private static final String PAGE = "page";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String page = request.getParameter(PAGE);
        String newSurname = request.getParameter(NEW_SURNAME);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeSurname(newSurname, userId);
            user.setSurname(newSurname);
            session.setAttribute(USER, user);
            session.setAttribute(RIGHT, RIGHT_SURNAME_MESSAGE);
        } catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_SURNAME_MESSAGE);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=personal_account&page=" + page);
    }
}
