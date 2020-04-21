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

public class SortByPriceReductionCommand implements Command {
    private static final String SORT_STATUS = "sortStatus";
    private static final String PRICE_REDUCE = "reducePrice";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies = new ArrayList<>();
        HttpSession session = request.getSession();
        try {
            pies = serviceFactory.getPieService().sortByPriceReduce();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        session.setAttribute(SORT_STATUS, PRICE_REDUCE);
        request.setAttribute("pies", pies);
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
