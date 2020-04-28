package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.impl.PieServiceImpl;
import by.epam.bakery.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static Logger log = LogManager.getLogger(ShowMainPageCommand.class.getName());


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Loading list of pies started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(SORT_STATUS);
        List<Pie> pies;
        try {
            pies = serviceFactory.getPieService().getSortPieList(value, PRICE_INCREASE, PRICE_REDUCE);
            session.setAttribute(PIES, pies);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Loading list of pies finished.");
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
