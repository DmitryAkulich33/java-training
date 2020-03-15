package by.epam.bakery.controller.command.impl;

import by.epam.bakery.controller.RedirectUrlCreator;
import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.UserService;
import by.epam.bakery.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";

    private UserService userService;

    public LoginCommand(UserService service) {
        this.userService = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        Optional<User> user = Optional.empty();
        try {
            user = userService.login(login, password);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        HttpSession session = request.getSession();
        if(user.isPresent()){
            session.setAttribute(USER, user);
        }
//        return CommandResult.redirect(RedirectUrlCreator.create("show_main_page"));
        return CommandResult.forward("/WEB-INF/jsp/pies.jsp");
    }
}
