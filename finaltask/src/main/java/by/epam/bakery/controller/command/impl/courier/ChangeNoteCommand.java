package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeNoteCommand implements Command {
    private static final String CHANGE_NOTE = "changeNote";
    private static final String CHANGE_ID = "changeId";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_MESSAGE = "The entered data is not correct!";
    private static final String RIGHT_MESSAGE = "Note was changed successfully!";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String note = request.getParameter(CHANGE_NOTE);
        int userId = Integer.parseInt(request.getParameter(CHANGE_ID));
        if(!note.isEmpty()){
            try {

                serviceFactory.getUserService().changeNote(note, userId);
                session.setAttribute(RIGHT, RIGHT_MESSAGE);
            } catch (ValidatorException ex){
                session.setAttribute(WRONG, WRONG_MESSAGE);
            } catch (ServiceException e) {
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        } else {
            session.setAttribute(WRONG, WRONG_MESSAGE);
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=courier_clients&page=1");
    }
}
