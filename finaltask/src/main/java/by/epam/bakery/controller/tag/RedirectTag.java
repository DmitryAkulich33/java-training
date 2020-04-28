package by.epam.bakery.controller.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class RedirectTag extends TagSupport {
    private String page;
    private static Logger log = LogManager.getLogger(StatisticTag.class.getName());

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public int doStartTag() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error(this.getClass() + ":" + e.getMessage());
        }
        return SKIP_BODY;
    }
}
