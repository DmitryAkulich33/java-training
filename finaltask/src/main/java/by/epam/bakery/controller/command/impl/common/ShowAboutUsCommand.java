package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAboutUsCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.forward("/WEB-INF/jsp/about_us.jsp");
    }
}
