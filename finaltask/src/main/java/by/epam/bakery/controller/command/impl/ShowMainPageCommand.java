package by.epam.bakery.controller.command.impl;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.factory.ServiceFactory;
import by.epam.bakery.service.impl.PieServiceImpl;
import by.epam.bakery.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowMainPageCommand implements Command {
//    private PieServiceImpl pieServiceImpl;
//
//    public ShowMainPageCommand(PieServiceImpl pieServiceImpl){
//        this.pieServiceImpl = pieServiceImpl;
//    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Pie> pies = new ArrayList<>();
        try {
//            pies = pieServiceImpl.showAllPies();
            pies = serviceFactory.getPieService().showAllPies();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("pies", pies);
        return CommandResult.forward("/WEB-INF/jsp/pies.jsp");
    }
}
