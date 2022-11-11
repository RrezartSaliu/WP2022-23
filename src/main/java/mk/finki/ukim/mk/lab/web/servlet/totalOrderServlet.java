package mk.finki.ukim.mk.lab.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "totalOrder", urlPatterns = "/totalOrder")
public class totalOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("totalOrder")==null)
            req.getSession().setAttribute("totalOrder",1);
        else req.getSession().setAttribute("totalOrder", Integer.parseInt(req.getSession().getAttribute("totalOrder").toString())+1);

        System.out.println(req.getSession().getAttribute("totalOrder"));
        resp.sendRedirect("/");
    }
}
