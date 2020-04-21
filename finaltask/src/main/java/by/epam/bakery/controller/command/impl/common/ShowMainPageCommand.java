package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.impl.PieServiceImpl;
import by.epam.bakery.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowMainPageCommand implements Command {
    private static final String SORT_STATUS = "sortStatus";
    private static final String PRICE_INCREASE = "increasePrice";
    private static final String PRICE_REDUCE = "reducePrice";
    private static final String PIES = "pies";


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(SORT_STATUS);
        List<Pie> pies = null;
        try {
            pies = serviceFactory.getPieService().getSortPieList(value, PRICE_INCREASE, PRICE_REDUCE);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        session.setAttribute(PIES, pies);
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
