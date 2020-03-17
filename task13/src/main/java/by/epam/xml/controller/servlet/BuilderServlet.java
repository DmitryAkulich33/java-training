package by.epam.xml.controller.servlet;

import by.epam.xml.controller.Controller;
import by.epam.xml.domain.*;
import by.epam.xml.service.Director;
import by.epam.xml.service.builder.OrderDOMBuilder;
import by.epam.xml.service.builder.OrderSAXBuilder;
import by.epam.xml.service.builder.OrderStAXBuilder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/choose")
@MultipartConfig
public class BuilderServlet extends HttpServlet {
    private static Logger log = LogManager.getLogger(BuilderServlet.class.getName());
    private Controller controller = new Controller();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filePath = "";
        String parserValue = "";
        try{
            ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> parts = fileUpload.parseRequest(request);
            for (FileItem part: parts) {
                if (!part.isFormField()){
                    filePath = "d:/java-training/task13/src/main/resources/uploads/" + part.getName();
//                    filePath = "e:/myjava/task13/src/main/resources/uploads/" + part.getName();
                    File file = new File(filePath);
                    part.write(file);
                    log.info("Text path is " + filePath);
                } else {
                    parserValue = part.getString();
                    log.info("Selected parser is " + filePath);
                }
            }
        } catch (Exception e){
            log.error("Problems with servlet: " + e.getMessage());
        }

        Set<Order> orders = controller.execute(parserValue, filePath);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/WEB-INF/jsp/table.jsp").forward(request, response);
    }

    private Set<Order> createSet(String parserValue, String filePath){
        Set<Order> orders = new HashSet<>();
        switch (parserValue) {
            case "sax":
                orders = Director.createOrders(new OrderSAXBuilder(), filePath);
                break;
            case "stax":
                orders = Director.createOrders(new OrderStAXBuilder(), filePath);
                break;
            case "dom":
                orders = Director.createOrders(new OrderDOMBuilder(), filePath);
                break;
        }
        return orders;
    }
}

