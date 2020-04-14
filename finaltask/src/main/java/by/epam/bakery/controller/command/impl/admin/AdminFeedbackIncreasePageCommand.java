package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminFeedbackIncreasePageCommand implements Command {
    private static final String FEEDBACK = "feedback";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 10;


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int increasePage = currentPage + 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<Feedback> feedbacks;
        if (increasePage <= count) {
            try {
                feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((increasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(FEEDBACK, feedbacks);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, increasePage);
        } else {
            try {
                feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(FEEDBACK, feedbacks);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        return CommandResult.forward("/WEB-INF/jsp/admin_feedback.jsp");
    }
}
