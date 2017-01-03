package at.omaha17.swe.controller;

import at.omaha17.swe.logic.TechnicalException;
import at.omaha17.swe.logic.VisualizationManager;
import at.omaha17.swe.model.Post;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String userName = (String) session.getAttribute("userName");
        try {
            Vector<Post> posts = VisualizationManager.getDashboard(userName);
            renderer.dispatcherFor("/WEB-INF/templates/internal/dashboard.twig")
                    .with("name", userName)
                    .with("posts", posts)
                    .render(request,response);

        }catch(TechnicalException exception){
            //redirect to Dashboard Error Page
        }

    }
}
