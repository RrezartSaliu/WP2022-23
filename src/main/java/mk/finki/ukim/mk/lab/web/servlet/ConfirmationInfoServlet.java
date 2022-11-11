package mk.finki.ukim.mk.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Confirmation", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("balloonType", req.getSession().getAttribute("balloonType"));
        webContext.setVariable("balloonSize", req.getSession().getAttribute("balloonSize"));
        webContext.setVariable("clientName", req.getParameter("clientName"));
        webContext.setVariable("clientAddress", req.getParameter("clientAddress"));
        webContext.setVariable("clientIp", req.getRemoteAddr());
        webContext.setVariable("clientBrowser", req.getHeader("User-Agent"));
        springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }
}
