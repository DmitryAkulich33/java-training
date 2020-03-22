package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClearBasketCommand implements Command {
    private static final String BASKET = "basket";
    private static final String TOTAL = "total";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        Basket basket = new Basket();
        HttpSession session = request.getSession();
        session.setAttribute(BASKET, basket);
        session.setAttribute(TOTAL, null);
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
