package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
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
    private static final String WRONG = "wrong";
    private static final String RIGHT = "right";
    private static final String WRONG_FEEDBACK = "The entered data is not correct!";
    private static final String RIGHT_FEEDBACK = "Your feedback has been successfully added.";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String value = request.getParameter(REVIEW);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        try {
            serviceFactory.getFeedBackService().save(user.getId(), LocalDateTime.now(), value);
            session.setAttribute(RIGHT, RIGHT_FEEDBACK);
        }  catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_FEEDBACK);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_feedback&page=1");
    }
}
