package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.bakery.service.validator.factory.ValidatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCommand implements Command {
    private static Logger log = LogManager.getLogger(LoginCommand.class.getName());
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final String WRONG_LOGIN = "Incorrect login or password!";
    private static final String WRONG_DATA = "The entered data is not correct!";
    private static final String MESSAGE = "message";
    private static final String NO_RECORDS = "No records";


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        HttpSession session = request.getSession();
        User user;
        try {
            user = serviceFactory.getUserService().login(login, password);
            session.setAttribute(USER, user);
        } catch (ValidatorException ex){
            request.setAttribute(MESSAGE, WRONG_DATA);
            return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
        } catch (ServiceException e) {
            if(e.getCause().getMessage().equals(NO_RECORDS)){
                request.setAttribute(MESSAGE, WRONG_LOGIN);
            } else {
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        }
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
