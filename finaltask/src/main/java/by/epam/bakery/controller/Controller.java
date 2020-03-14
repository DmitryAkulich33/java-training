package by.epam.bakery.controller;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR_PARAMETER = "&error=";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
//        CommandFactory factory = new CommandFactory();
        CommandProvider commandProvider = new CommandProvider();
//        Command concreteCommand = factory.findCommand(command);
        Command concreteCommand = commandProvider.getCommand(command);
        CommandResult result = concreteCommand.execute(request, response);
        dispatch(request, response, result);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, CommandResult result) throws ServletException, IOException {
        if (result != null) {
            String page = result.getPage();
            if (result.isRedirect()) {
                response.sendRedirect(request.getContextPath() + page);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        }
    }

//    private String createRedirectExceprion(Throwable exception){
//        String error = exception.getMessage();
//        String url = RedirectUrlCreator.create(CommandName.SHOW_ERROR_PAGE) + ERROR_PARAMETER + error;
//        return url;
//    }
}

