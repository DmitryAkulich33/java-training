package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeNoteCommand implements Command {
    private static final String CHANGE_NOTE = "changeNote";
    private static final String CHANGE_ID = "changeId";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_MESSAGE = "wrongMessage";
    private static final String RIGHT_MESSAGE = "rightNote";
    private static Logger log = LogManager.getLogger(ChangeNoteCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Changing note started.");
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String note = request.getParameter(CHANGE_NOTE);
        int userId = Integer.parseInt(request.getParameter(CHANGE_ID));
        if (!note.isEmpty()) {
            try {
                serviceFactory.getUserService().changeNote(note, userId);
                session.setAttribute(RIGHT, RIGHT_MESSAGE);
            } catch (ValidatorException ex) {
                log.error(this.getClass() + ":" + ex.getMessage());
                session.setAttribute(WRONG, WRONG_MESSAGE);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        } else {
            session.setAttribute(WRONG, WRONG_MESSAGE);
        }
        log.debug("Changing note finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=courier_clients&page=1");
    }
}
