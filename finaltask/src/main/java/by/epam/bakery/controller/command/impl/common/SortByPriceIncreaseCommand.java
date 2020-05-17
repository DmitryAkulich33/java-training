package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SortByPriceIncreaseCommand implements Command {
    private static final String SORT_STATUS = "sortStatus";
    private static final String PRICE_INCREASE = "increasePrice";
    private static Logger log = LogManager.getLogger(SortByPriceIncreaseCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Loading list of pies sorted by increase price started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies;
        HttpSession session = request.getSession();
        try {
            pies = serviceFactory.getPieService().sortByPriceIncrease();
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        session.setAttribute(SORT_STATUS, PRICE_INCREASE);
        session.setAttribute("pies", pies);
        log.debug("Loading list of pies sorted by increase price finished.");
        return CommandResult.forward("/WEB-INF/jsp/common/pies.jsp");
    }
}
