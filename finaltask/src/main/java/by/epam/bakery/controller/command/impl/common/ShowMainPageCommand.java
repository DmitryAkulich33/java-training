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

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(SORT_STATUS);
        List<Pie> pies = getList(value);
        request.setAttribute("pies", pies);
        return CommandResult.forward("/WEB-INF/jsp/pies.jsp");
    }

    public List<Pie> getList (String value){
        List<Pie> pies = new ArrayList<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            if (value != null) {
                if (value.equals(PRICE_INCREASE)) {
                    pies = serviceFactory.getPieService().sortByPriceIncrease();
                } else if (value.equals(PRICE_REDUCE)) {
                    pies =serviceFactory.getPieService().sortByPriceReduce();
                }
            } else {
                pies = serviceFactory.getPieService().showAllPies();
            }
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return pies;
    }
}
