package at.omaha17.swe.controller;

import at.omaha17.swe.logic.TechnicalException;
import at.omaha17.swe.logic.VisualizationManager;
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


    /**
     * Request for rendering a Wall
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Username of the User whichever page has been requested
        String userName = request.getParameter("userName");
        String userNotFoundParameter = request.getParameter("userNotFound");

        Boolean userNotFound = false;
        if(userNotFoundParameter.equals("1")){
            userNotFound = true;
        }

        HttpSession session=request.getSession(false);
        String myUserName = (String)session.getAttribute("userName");

        if(userName.equals("home")){
            userName = myUserName;
        }

        Boolean myWall = false;
        //Is it my own wall
        if (userName.equals(myUserName)){
            myWall = true;
        }



        try {
            Wall wall = VisualizationManager.getWall(userName);

            renderer.dispatcherFor("/WEB-INF/templates/internal/wall.twig")
                    .with("name", wall.getUser().getUsername())
                    .with("abstract", wall.getUser().getAbstract())
                    .with("posts", wall.getPosts())
                    .with("myWall", myWall)
                    .with("userNotFound",userNotFound)
                    .with("displayName", wall.getUser().getDisplayName())
                    .render(request, response);
        }

        catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
