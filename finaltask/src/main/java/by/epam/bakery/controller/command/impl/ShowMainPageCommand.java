package by.epam.bakery.controller.command.impl;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.PieService;
import by.epam.bakery.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowMainPageCommand implements Command {
    private PieService pieService;

    public ShowMainPageCommand(PieService pieService){
        this.pieService = pieService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        List<Pie> pies = new ArrayList<>();
        try {
            pies = pieService.showAllPies();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("pies", pies);
        return CommandResult.forward("/WEB-INF/jsp/pies.jsp");
    }
}
