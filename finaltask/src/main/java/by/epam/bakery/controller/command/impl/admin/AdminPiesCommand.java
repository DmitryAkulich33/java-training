package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminPiesCommand implements Command {
    private static final String PIES = "pies";
    private static Logger log = LogManager.getLogger(AdminPiesCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Login to edit pies started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies;
        try {
            pies = serviceFactory.getPieService().showAllPies();
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PIES, pies);
        log.debug("Login to edit pies finished.");
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_pies.jsp");
    }
}
