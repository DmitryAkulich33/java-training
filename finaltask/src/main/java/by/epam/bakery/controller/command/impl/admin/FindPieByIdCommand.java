package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class FindPieByIdCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIES = "pies";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        List<Pie> pies = new ArrayList<>();
        Pie pie = null;
        try {
            pie = serviceFactory.getPieService().findPieById(pieId);
            pies.add(pie);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute(PIES, pies);
        return CommandResult.forward("/WEB-INF/jsp/admin_pies.jsp");
    }
}
