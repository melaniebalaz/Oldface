package at.omaha17.swe.controller;

import at.omaha17.swe.logic.*;
import at.omaha17.swe.model.Post;
import at.omaha17.swe.model.Senior;
import at.omaha17.swe.model.Wall;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/wall")
public class WallController extends HttpServlet {
    WallManager wallManager = new WallManagerImpl();
    UserManager userManager = new UserManagerImpl();

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
            //This downcast does not work!!
            Senior senior = Senior.class.cast(userManager.getUser(userName));
            Wall wall = senior.getWall();
            try {
                Vector<Post> posts = wallManager.getPosts(wall);

                renderer.dispatcherFor("/WEB-INF/templates/internal/wall.twig")
                        .with("name", senior.getUsername())
                        .with("posts", posts)
                        .render(request, response);
            }

            catch(WallException exception){
                //Here we need another Error page
                exception.printStackTrace();
            }

        } catch (UserException e) {
            //should be redirected to technical/unknown error
        }


    }
}
