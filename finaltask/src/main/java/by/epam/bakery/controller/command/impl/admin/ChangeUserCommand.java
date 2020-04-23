package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeUserCommand implements Command {
    private static final String CHANGE_ROLE = "changeRole";
    private static final String CHANGE_ADDRESS = "changeAddress";
    private static final String CHANGE_PHONE = "changePhone";
    private static final String CHANGE_NOTE = "changeNote";
    private static final String CHANGE_ID = "changeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String address = request.getParameter(CHANGE_ADDRESS);
        String phone = request.getParameter(CHANGE_PHONE);
        String note = request.getParameter(CHANGE_NOTE);
        String role = request.getParameter(CHANGE_ROLE);
        int userId = Integer.parseInt(request.getParameter(CHANGE_ID));
        if(!address.isEmpty()){
            try {
                serviceFactory.getUserService().changeAddress(address, userId);
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
        if(!phone.isEmpty()){
            try {
                serviceFactory.getUserService().changePhone(phone, userId);
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
        if(!note.isEmpty()){
            try {
                serviceFactory.getUserService().changeNote(note, userId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        if(!role.isEmpty()){
            try {
                int userRole = Integer.parseInt(role);
                serviceFactory.getUserService().changeRole(userRole, userId);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_users&page=1");
    }
}
