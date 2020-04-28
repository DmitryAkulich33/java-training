package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class FindPieByIdCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIES = "pies";
    private static final String WRONG = "wrong";
    private static final String WRONG_MESSAGE = "The entered data is not correct!";
    private static final String WRONG_ID = "The entered id not found in database";
    private static final String NO_RECORDS = "No records";
    private static Logger log = LogManager.getLogger(FindPieByIdCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Search pie by id started.");
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String pieId = request.getParameter(PIE_ID);
        List<Pie> pies = new ArrayList<>();
        Pie pie;
        try {
            pie = serviceFactory.getPieService().findPieById(pieId);
            pies.add(pie);
        } catch (ValidatorException ex){
            log.error(this.getClass() + ":" + ex.getMessage());
            session.setAttribute(WRONG, WRONG_MESSAGE);
            return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            if(e.getCause().getMessage().equals(NO_RECORDS)){
                session.setAttribute(WRONG, WRONG_ID);
                return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
            } else {
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        }
        request.setAttribute(PIES, pies);
        log.debug("Search pie by id finished.");
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_pies.jsp");
    }
}
