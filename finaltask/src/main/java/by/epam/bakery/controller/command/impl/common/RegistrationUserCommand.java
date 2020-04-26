package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.LoginIsNotFreeException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationUserCommand implements Command {
    private static final String SAVE_LOGIN = "saveLogin";
    private static final String SAVE_PASSWORD = "savePassword";
    private static final String USER_ROLE = "3";
    private static final double TOTAL = 0.00;
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
    private static final String RIGHT_MESSAGE = "Registration completed successfully!";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
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
            serviceFactory.getBasketService().saveBasket(login, TOTAL);
            session.setAttribute(RIGHT, RIGHT_MESSAGE);
        } catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_DATA);
            return CommandResult.forward("/WEB-INF/jsp/user/registration.jsp");
        } catch (LoginIsNotFreeException exc){
            session.setAttribute(WRONG, login + WRONG_LOGIN);
            return CommandResult.forward("/WEB-INF/jsp/user/registration.jsp");
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
