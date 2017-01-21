package at.omaha17.swe.controller;

import at.omaha17.swe.logic.*;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/post")
public class AddPostController extends HttpServlet {

    /**
    public AddPostController(WallManager manager){
        this.manager = manager;
    }
     **/

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String postContent = request.getParameter("blogPost");

        //person whose profile
        String wallUserName = request.getParameter("userName");

        HttpSession session=request.getSession(false);

        String myUserName = (String) session.getAttribute("userName");


        Boolean myWall = false;
        //Is it my own wall
        if (wallUserName.equals(myUserName)){
            myWall = true;
        }


        try {
            //add the new post
            MessageManager.addPost(wallUserName, myUserName, postContent);
            //redirect to the Wall Controller which loads all the current posts
            response.sendRedirect(("/wall?userName="+ URLEncoder.encode(wallUserName, "UTF-8")+"&myWall="+myWall+"&userNotFound="+0));

        }catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
