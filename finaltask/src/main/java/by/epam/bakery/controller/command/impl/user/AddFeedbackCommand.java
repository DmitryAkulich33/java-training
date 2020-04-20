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

public class AddFeedbackCommand implements Command {
    private static final String USER = "user";
    private static final String REVIEW = "review";
    private static final String NO_LOGIN_MESSAGE = "You need to log in as a user!";
    private static final String NO_LOGIN = "noLogin";
    private static final String FEEDBACK = "feedback";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 10;

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
        } else {
            request.setAttribute(NO_LOGIN, NO_LOGIN_MESSAGE);
        }
        List<Feedback> feedbacks;
        try {
            feedbacks = serviceFactory.getFeedBackService().findLimitFeedback(0, AMOUNT);
            request.setAttribute(FEEDBACK, feedbacks);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            int count = serviceFactory.getFeedBackService().findFeedbackPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(PAGE, 1);
        return CommandResult.forward("/WEB-INF/jsp/feedback.jsp");
    }
}
