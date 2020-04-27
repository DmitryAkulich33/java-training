package by.epam.bakery.controller.filter;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandName;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

public class RoleFilter implements Filter {
    private static final Map<CommandName, List<Integer>> commandsUsers = new HashMap<>();
    private static final String COMMAND = "command";
    private static final String USER = "user";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        List<Integer> allUsers = Arrays.asList(0, 1, 2, 3);
        List<Integer> admin = Collections.singletonList(1);
        List<Integer> courier = Collections.singletonList(2);
        List<Integer> client = Collections.singletonList(3);
        commandsUsers.put(CommandName.SHOW_MAIN_PAGE, allUsers);
        commandsUsers.put(CommandName.LOGIN, allUsers);
        commandsUsers.put(CommandName.LOG_OUT, allUsers);
        commandsUsers.put(CommandName.REGISTRATION, allUsers);
        commandsUsers.put(CommandName.REGISTRATION_USER, allUsers);
        commandsUsers.put(CommandName.SHOW_ABOUT_US, allUsers);
        commandsUsers.put(CommandName.SHOW_CONTACTS, allUsers);
        commandsUsers.put(CommandName.SHOW_DELIVERY, allUsers);
        commandsUsers.put(CommandName.SHOW_FEEDBACK, allUsers);
        commandsUsers.put(CommandName.SHOW_FEEDBACK_INCREASE_PAGE, allUsers);
        commandsUsers.put(CommandName.SHOW_FEEDBACK_DECREASE_PAGE, allUsers);
        commandsUsers.put(CommandName.SORT_BY_REDUCTION_PRICE, allUsers);
        commandsUsers.put(CommandName.SORT_BY_INCREASE_PRICE, allUsers);
        commandsUsers.put(CommandName.CHANGE_NOTE, courier);
        commandsUsers.put(CommandName.CHANGE_ORDER_STATUS, courier);
        commandsUsers.put(CommandName.COURIER_CLIENTS, courier);
        commandsUsers.put(CommandName.COURIER_ACCOUNT, courier);
        commandsUsers.put(CommandName.COURIER_CLIENTS_INCREASE_PAGE, courier);
        commandsUsers.put(CommandName.COURIER_CLIENTS_DECREASE_PAGE, courier);
        commandsUsers.put(CommandName.COURIER_ORDER, courier);
        commandsUsers.put(CommandName.COURIER_ORDER_INCREASE_PAGE, courier);
        commandsUsers.put(CommandName.COURIER_ORDER_DECREASE_PAGE, courier);
        commandsUsers.put(CommandName.ADD_FEEDBACK, client);
        commandsUsers.put(CommandName.ADD_ORDER, client);
        commandsUsers.put(CommandName.ADD_PIE, client);
        commandsUsers.put(CommandName.CHANGE_ADDRESS, client);
        commandsUsers.put(CommandName.CHANGE_NAME, client);
        commandsUsers.put(CommandName.CHANGE_PATRONYMIC, client);
        commandsUsers.put(CommandName.CHANGE_SURNAME, client);
        commandsUsers.put(CommandName.CHANGE_PHONE, client);
        commandsUsers.put(CommandName.CLEAR_BASKET, client);
        commandsUsers.put(CommandName.DELETE_PIE_FROM_BASKET, client);
        commandsUsers.put(CommandName.PERSONAL_ACCOUNT, client);
        commandsUsers.put(CommandName.PERSONAL_ACCOUNT_DECREASE_PAGE, client);
        commandsUsers.put(CommandName.PERSONAL_ACCOUNT_INCREASE_PAGE, client);
        commandsUsers.put(CommandName.SHOW_BASKET, client);
        commandsUsers.put(CommandName.ADMIN_ACCOUNT, admin);
        commandsUsers.put(CommandName.ADMIN_ADD_NEW_ORDER, admin);
        commandsUsers.put(CommandName.ADMIN_ADD_NEW_USER_FOR_ORDER, admin);
        commandsUsers.put(CommandName.ADMIN_ADD_PIE_TO_ORDER, admin);
        commandsUsers.put(CommandName.ADMIN_DELETE_PIE_FROM_ORDER, admin);
        commandsUsers.put(CommandName.ADMIN_FEEDBACK, admin);
        commandsUsers.put(CommandName.ADMIN_FEEDBACK_DECREASE_PAGE, admin);
        commandsUsers.put(CommandName.ADMIN_FEEDBACK_INCREASE_PAGE, admin);
        commandsUsers.put(CommandName.ADMIN_ORDER_PRODUCT, admin);
        commandsUsers.put(CommandName.ADMIN_ORDER_PRODUCT_INCREASE_PAGE, admin);
        commandsUsers.put(CommandName.ADMIN_ORDER_PRODUCT_DECREASE_PAGE, admin);
        commandsUsers.put(CommandName.ADMIN_PIES, admin);
        commandsUsers.put(CommandName.ADMIN_PRODUCT_TO_ORDER, admin);
        commandsUsers.put(CommandName.ADMIN_USERS, admin);
        commandsUsers.put(CommandName.ADMIN_USERS_INCREASE_PAGE, admin);
        commandsUsers.put(CommandName.ADMIN_USERS_DECREASE_PAGE, admin);
        commandsUsers.put(CommandName.CHANGE_ORDER, admin);
        commandsUsers.put(CommandName.CHANGE_PIE, admin);
        commandsUsers.put(CommandName.CHANGE_USER, admin);
        commandsUsers.put(CommandName.DELETE_FEEDBACK, admin);
        commandsUsers.put(CommandName.DELETE_ORDER, admin);
        commandsUsers.put(CommandName.DELETE_ORDER_PRODUCT, admin);
        commandsUsers.put(CommandName.DELETE_PIE, admin);
        commandsUsers.put(CommandName.DELETE_USER, admin);
        commandsUsers.put(CommandName.FIND_PIE_BY_ID, admin);
        commandsUsers.put(CommandName.FIND_PIE_BY_NAME, admin);
        commandsUsers.put(CommandName.SAVE_PIE, admin);
        commandsUsers.put(CommandName.SAVE_USER, admin);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String command = request.getParameter(COMMAND);
        if(command != null){
            CommandName commandName = CommandName.valueOf(command.toUpperCase());
            User user = (User) request.getSession().getAttribute(USER);
            int role = 0;
            if (user != null) {
                role = user.getRole();
            }
            List<Integer> roles = commandsUsers.get(commandName);
            if (roles != null && !roles.contains(role)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/common/errorRole.jsp");
                dispatcher.forward(request, servletResponse);
                return;
            }
        }
        filterChain.doFilter(request,servletResponse);
}

    @Override
    public void destroy() {

    }
}
