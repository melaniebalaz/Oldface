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


    /**
     * Post Request for posting the new short abstract that should be portrayed on the Users Wall
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();

        //If the user it not logged in, redirect to error page
        if(session.getAttribute("userName") == null){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

        String userName = (String) session.getAttribute("userName");

        String newAbstract = request.getParameter("abstract");
        String newDisplayName = request.getParameter("displayName");

        try {
            ProfileManager.updateProfile(userName,newDisplayName,newAbstract);
            response.sendRedirect("/wall");
        }
        catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO
        //Check if a session already exists, if not throw an error (You are not logged in!)
        HttpSession session=request.getSession();


        //If the user it not logged in, redirect to error page
        if(session.getAttribute("userName") == null){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

        String userName = (String) session.getAttribute("userName");

        try {
            Wall wall = VisualizationManager.getWall(userName);

            renderer.dispatcherFor("/WEB-INF/templates/internal/wall.twig")
                    .with("name", wall.getUser().getUsername())
                    .with("abstract", wall.getUser().getAbstract())
                    .with("posts", wall.getPosts())
                    .with("myWall", true)
                    .with("displayName", wall.getUser().getDisplayName())
                    .render(request, response);
        }

        catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
