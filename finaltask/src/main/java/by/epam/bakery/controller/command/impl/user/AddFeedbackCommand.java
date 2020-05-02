package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class AddFeedbackCommand implements Command {
    private static final String USER = "user";
    private static final String REVIEW = "review";
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_FEEDBACK = "wrongMessage";
    private static final String RIGHT_FEEDBACK = "rightFeedback";
    private static Logger log = LogManager.getLogger(AddFeedbackCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding feedback started.");
        String value = request.getParameter(REVIEW);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        try {
            serviceFactory.getFeedBackService().save(user.getId(), LocalDateTime.now(), value);
            session.setAttribute(RIGHT, RIGHT_FEEDBACK);
        } catch (ValidatorException ex) {
            log.error(this.getClass() + ":" + ex.getMessage());
            session.setAttribute(WRONG, WRONG_FEEDBACK);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Adding feedback finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_feedback&page=1");
    }
}
