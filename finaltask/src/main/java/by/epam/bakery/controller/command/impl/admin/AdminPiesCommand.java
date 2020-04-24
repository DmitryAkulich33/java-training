package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminPiesCommand implements Command {
    private static final String PIES = "pies";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies;
        try {
            pies = serviceFactory.getPieService().showAllPies();
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PIES, pies);
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_pies.jsp");
    }
}
