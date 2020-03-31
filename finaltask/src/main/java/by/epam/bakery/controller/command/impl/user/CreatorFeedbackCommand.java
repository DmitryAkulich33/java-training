package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class CreatorFeedbackCommand implements Command {
    private static final String USER = "user";
    private static final String REVIEW = "review";
    private static final String FEEDBACK = "feedback";
    private static final String NO_LOGIN = "You need to log in as a user!";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String value = request.getParameter(REVIEW);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        if(user != null) {
            try {
                serviceFactory.getFeedBackService().save(user.getId(), LocalDateTime.now(), value);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            List<Feedback> feedbacks = null;
            try {
                feedbacks = serviceFactory.getFeedBackService().showAllFeedBacks();
//                Collections.reverse(feedbacks);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            session.setAttribute("noLogin", "");
            session.setAttribute(FEEDBACK, feedbacks);
            return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
        } else {
            session.setAttribute("noLogin", NO_LOGIN);
            return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
        }
    }
}
