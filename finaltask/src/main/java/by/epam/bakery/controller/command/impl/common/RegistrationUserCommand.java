package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationUserCommand implements Command {
    private static final String SAVE_LOGIN = "saveLogin";
    private static final String SAVE_PASSWORD = "savePassword";
    private static final int USER_ROLE = 3;
    private static final String SAVE_SURNAME = "saveSurname";
    private static final String SAVE_NAME = "saveName";
    private static final String SAVE_PATRONYMIC = "savePatronymic";
    private static final String SAVE_ADDRESS = "saveAddress";
    private static final String SAVE_PHONE = "savePhone";
    private static final String SAVE_NOTE = "saveNote";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = request.getParameter(SAVE_LOGIN);
        String password = request.getParameter(SAVE_PASSWORD);
        String surname = request.getParameter(SAVE_SURNAME);
        String name = request.getParameter(SAVE_NAME);
        String patronymic = request.getParameter(SAVE_PATRONYMIC);
        String address = request.getParameter(SAVE_ADDRESS);
        String phone = request.getParameter(SAVE_PHONE);
        String note = request.getParameter(SAVE_NOTE);
        try {
            serviceFactory.getUserService().addUser(login, password, USER_ROLE, surname, name, patronymic, address, phone, note);
            serviceFactory.getBasketService().saveBasket(login, 0.00);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}