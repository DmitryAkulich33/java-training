package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class AdminFeedbackCommand implements Command {
    private static final String FEEDBACK = "feedback";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 10;
    private static Logger log = LogManager.getLogger(AdminFeedbackCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Login to edit feedbacks started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int page = Integer.parseInt(request.getParameter(PAGE));
        List<Feedback> feedbacks;
        try {
            feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(FEEDBACK, feedbacks);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            int count = serviceFactory.getFeedBackService().findFeedbackPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PAGE, page);
        log.debug("Login to edit reviews finished.");
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_feedback.jsp");
    }
}
