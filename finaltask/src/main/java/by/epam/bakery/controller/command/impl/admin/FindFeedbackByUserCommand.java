package by.epam.bakery.controller.command.impl.admin;

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

public class FindFeedbackByUserCommand implements Command {
    private static final String USER_ID = "userId";
    private static final String FEEDBACK = "feedback";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter(USER_ID));
        List<Feedback> feedbacks = null;
        try {
            feedbacks = serviceFactory.getFeedBackService().findFeedbackByUserId(userId);
//            Collections.reverse(feedbacks);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        session.setAttribute(FEEDBACK, feedbacks);
        return CommandResult.forward("/WEB-INF/jsp/admin_feedback.jsp");
    }
}
