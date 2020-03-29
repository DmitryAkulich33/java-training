package by.epam.bakery.controller.command.impl.feedback;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class ShowFeedbackCommand implements Command {
    private static final String FEEDBACK = "feedback";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        List<Feedback> feedbacks = null;
        try {
            feedbacks = serviceFactory.getFeedBackService().showAllFeedBacks();
//            Collections.reverse(feedbacks);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        session.setAttribute("noLogin", "");
        session.setAttribute(FEEDBACK, feedbacks);
        return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
    }
}
