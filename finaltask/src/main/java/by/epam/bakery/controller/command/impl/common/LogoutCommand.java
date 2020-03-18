package by.epam.bakery.controller.command.impl.common;

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

public class LogoutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies = new ArrayList<>();
        try {
            pies = serviceFactory.getPieService().showAllPies();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("pies", pies);
        return CommandResult.forward("/WEB-INF/jsp/pies.jsp");
    }
}
