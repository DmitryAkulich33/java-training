package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.LoginIsNotFreeException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveUserCommand implements Command {
    private static final String SAVE_LOGIN = "saveLogin";
    private static final String SAVE_PASSWORD = "savePassword";
    private static final String SAVE_ROLE = "saveRole";
    private static final String SAVE_SURNAME = "saveSurname";
    private static final String SAVE_NAME = "saveName";
    private static final String SAVE_PATRONYMIC = "savePatronymic";
    private static final String SAVE_ADDRESS = "saveAddress";
    private static final String SAVE_PHONE = "savePhone";
    private static final String SAVE_NOTE = "saveNote";
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_LOGIN = " - this login is not free!";
    private static final String WRONG_DATA = "The entered data is not correct!";
    private static final String RIGHT_MESSAGE = "User was added successfully!";
    private static final String USERS = "users";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = request.getParameter(SAVE_LOGIN);
        String password = request.getParameter(SAVE_PASSWORD);
        String role = request.getParameter(SAVE_ROLE);
        String surname = request.getParameter(SAVE_SURNAME);
        String name = request.getParameter(SAVE_NAME);
        String patronymic = request.getParameter(SAVE_PATRONYMIC);
        String address = request.getParameter(SAVE_ADDRESS);
        String phone = request.getParameter(SAVE_PHONE);
        String note = request.getParameter(SAVE_NOTE);
        try {
            try {
                serviceFactory.getUserService().addUser(login, password, role, surname, name, patronymic, address, phone, note);
                serviceFactory.getBasketService().saveBasket(login, 0.00);
                request.setAttribute(RIGHT, RIGHT_MESSAGE);
            } catch (ValidatorException ex){
                request.setAttribute(WRONG, WRONG_DATA);
            } catch (LoginIsNotFreeException exc){
                request.setAttribute(WRONG, login + WRONG_LOGIN);
            }
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        int page = Integer.parseInt(request.getParameter(PAGE));
        List<User> users;
        try {
            users = serviceFactory.getUserService().findLimitUser((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(USERS, users);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            int count = serviceFactory.getUserService().findUserPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_users.jsp");
    }
}
