package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.validator.factory.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeSurnameCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_SURNAME = "newSurname";
    private static final String RIGHT_SURNAME = "rightSurname";
    private static final String WRONG_SURNAME = "wrongSurname";
    private static final String WRONG_SURNAME_MESSAGE = "The surname is wrong";
    private static final String RIGHT_SURNAME_MESSAGE = "The surname changed";
    private static final String PAGE = "page";
    private static final String COUNT = "count";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        int count = Integer.parseInt(request.getParameter(COUNT));
        request.setAttribute(PAGE, page);
        request.setAttribute(COUNT, count);
        String newSurname = request.getParameter(NEW_SURNAME);
        if(!validatorFactory.getUserDataValidator().isSurnameValid(newSurname)){
            request.setAttribute(WRONG_SURNAME, WRONG_SURNAME_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeSurname(newSurname, userId);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        user.setSurname(newSurname);
        session.setAttribute(USER, user);
        request.setAttribute(RIGHT_SURNAME, RIGHT_SURNAME_MESSAGE);
        return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
    }
}
