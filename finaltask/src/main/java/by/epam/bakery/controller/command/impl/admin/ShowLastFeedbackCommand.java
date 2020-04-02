package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class ShowLastFeedbackCommand implements Command {
    private static final String AMOUNT = "amount";
    private static final String FEEDBACK = "feedback";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int amount = Integer.parseInt(request.getParameter(AMOUNT));
        List<Feedback> allFeedback = null;
        try {
            allFeedback = serviceFactory.getFeedBackService().findNecessaryFeedbackAmount(amount);
            request.setAttribute(FEEDBACK, allFeedback);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.forward("/WEB-INF/jsp/admin_feedback.jsp");
    }
}
