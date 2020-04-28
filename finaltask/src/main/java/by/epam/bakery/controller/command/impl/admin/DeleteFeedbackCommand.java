package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFeedbackCommand implements Command {
    private static final String FEEDBACK_ID = "feedbackId";
    private static Logger log = LogManager.getLogger(DeleteFeedbackCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting feedback started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int feedbackId = Integer.parseInt(request.getParameter(FEEDBACK_ID));
        try {
            serviceFactory.getFeedBackService().deleteFeedback(feedbackId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Deleting feedback finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_feedback&page=1");
    }
}
