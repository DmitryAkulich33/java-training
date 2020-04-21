package by.epam.bakery.controller.command.impl.common;

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
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 10;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        List<Feedback> feedbacks;
        try {
            feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((page - 1) * AMOUNT, AMOUNT);
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
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/common/feedback.jsp");
    }
}
