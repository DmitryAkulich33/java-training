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

public class ChangeNameCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_NAME = "newName";
    private static final String RIGHT_NAME = "rightName";
    private static final String WRONG_NAME = "wrongName";
    private static final String WRONG_NAME_MESSAGE = "The name is wrong";
    private static final String RIGHT_NAME_MESSAGE = "The name changed";
    private static final String PAGE = "page";
    private static final String COUNT = "count";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        int count = Integer.parseInt(request.getParameter(COUNT));
        request.setAttribute(PAGE, page);
        request.setAttribute(COUNT, count);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newName = request.getParameter(NEW_NAME);
        if(!validatorFactory.getUserDataValidator().isNameValid(newName)){
            request.setAttribute(WRONG_NAME, WRONG_NAME_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeName(newName, userId);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        user.setName(newName);
        session.setAttribute(USER, user);
        request.setAttribute(RIGHT_NAME, RIGHT_NAME_MESSAGE);
        return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
    }
}
