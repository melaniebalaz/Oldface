package at.omaha17.swe.controller;

import at.omaha17.swe.logic.*;
import at.omaha17.swe.model.Wall;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/wall")
public class WallController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    /*
    public WallController(WallManager manager){

        this.wallManager = wallManager;
        this.userManager = userManager;
    }
    */

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        String userName = (String) session.getAttribute("userName");

        try {
            Wall wall = VisualizationManager.getWall(userName);

            renderer.dispatcherFor("/WEB-INF/templates/internal/wall.twig")
                    .with("name", wall.getUser().getUsername())
                    .with("abstract", wall.getUser().getAbstract())
                    .with("posts", wall.getPosts())
                    .render(request, response);
        }

        catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
