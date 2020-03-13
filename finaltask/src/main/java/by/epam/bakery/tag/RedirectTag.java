package by.epam.bakery.tag;

import by.epam.bakery.tag.exception.TagException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class RedirectTag extends TagSupport {
    private String page;

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
            throw new TagException(e);
        }
        return SKIP_BODY;
    }
}
