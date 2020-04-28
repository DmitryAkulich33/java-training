package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePieCommand implements Command {
    private static final String DEL_ID = "delId";
    private static Logger log = LogManager.getLogger(DeletePieCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Deleting pie started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int pieId = Integer.parseInt(request.getParameter(DEL_ID));
        try {
            serviceFactory.getPieService().deletePie(pieId);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Deleting pie finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
    }
}
