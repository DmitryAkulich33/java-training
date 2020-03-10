package by.epam.bakery.servlet;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/addPie")
public class AddServlet extends HttpServlet{
    public Basket basket =  new Basket();

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
        Pie pie = new Pie();
        pie.setName(request.getParameter("pieName"));
        pie.setPrice(Double.parseDouble(request.getParameter("piePrice")));
        basket.getPies().add(pie);
        request.setAttribute("basket", basket);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
