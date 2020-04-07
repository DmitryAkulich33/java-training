package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeNoteCommand implements Command {
    private static final String CHANGE_NOTE = "changeNote";
    private static final String CHANGE_ID = "changeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String note = request.getParameter(CHANGE_NOTE);
        int userId = Integer.parseInt(request.getParameter(CHANGE_ID));
        if(!note.isEmpty()){
            try {
                serviceFactory.getUserService().changeNote(note, userId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=courier_clients");
    }
}
