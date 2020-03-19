package by.epam.bakery.controller.command.impl.feedback;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFeedBackCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
    }
}
