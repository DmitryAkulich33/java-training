package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = request.getParameter(SAVE_LOGIN);
        String password = request.getParameter(SAVE_PASSWORD);
        int role = Integer.parseInt(request.getParameter(SAVE_ROLE));
        String surname = request.getParameter(SAVE_SURNAME);
        String name = request.getParameter(SAVE_NAME);
        String patronymic = request.getParameter(SAVE_PATRONYMIC);
        String address = request.getParameter(SAVE_ADDRESS);
        String phone = request.getParameter(SAVE_PHONE);
        String note = request.getParameter(SAVE_NOTE);
        try {
            serviceFactory.getUserService().addUser(login, password, role, surname, name, patronymic, address, phone, note);
            serviceFactory.getBasketService().saveBasket(login, 0.00);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_users");
    }
}
