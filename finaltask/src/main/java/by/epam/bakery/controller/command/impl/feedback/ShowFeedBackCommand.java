package by.epam.bakery.controller.command.impl.feedback;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.FeedBack;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class ShowFeedBackCommand implements Command {
    private static final String FEEDBACK = "feedback";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        List<FeedBack> feedBacks = null;
        try {
            feedBacks = serviceFactory.getFeedBackService().showAllFeedBacks();
            Collections.reverse(feedBacks);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        session.setAttribute("noLogin", "");
        session.setAttribute(FEEDBACK, feedBacks);
        return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
    }
}
