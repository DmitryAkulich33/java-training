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

public class ChangeAddressCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_ADDRESS = "newAddress";
    private static final String RIGHT_ADDRESS = "rightAddress";
    private static final String WRONG_ADDRESS = "wrongAddress";
    private static final String WRONG_ADDRESS_MESSAGE = "The address is wrong";
    private static final String RIGHT_ADDRESS_MESSAGE = "The address changed";
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
        String newAddress = request.getParameter(NEW_ADDRESS);
        if(!validatorFactory.getUserDataValidator().isAddressValid(newAddress)){
            request.setAttribute(WRONG_ADDRESS, WRONG_ADDRESS_MESSAGE);
            return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeAddress(newAddress, userId);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        user.setAddress(newAddress);
        session.setAttribute(USER, user);
        request.setAttribute(RIGHT_ADDRESS, RIGHT_ADDRESS_MESSAGE);
        return CommandResult.forward("/WEB-INF/jsp/user/personal_account.jsp");
    }
}
