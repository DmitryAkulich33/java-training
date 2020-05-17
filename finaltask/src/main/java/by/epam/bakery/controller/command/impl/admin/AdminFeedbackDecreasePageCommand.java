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
import java.util.List;

public class AdminFeedbackDecreasePageCommand implements Command {
    private static final String FEEDBACK = "feedback";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 10;
    private static Logger log = LogManager.getLogger(AdminFeedbackDecreasePageCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Page number reduction for feedbacks started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int decreasePage = currentPage - 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<Feedback> feedbacks;
        if (decreasePage >= 1) {
            try {
                feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((decreasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(FEEDBACK, feedbacks);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, decreasePage);
        } else {
            try {
                feedbacks = serviceFactory.getFeedBackService().findLimitFeedback((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(FEEDBACK, feedbacks);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        log.debug("Page number reduction for feedbacks finished.");
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_feedback.jsp");
    }
}
