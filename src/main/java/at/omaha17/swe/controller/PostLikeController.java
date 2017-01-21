package at.omaha17.swe.controller;

import at.omaha17.swe.logic.MessageManager;
import at.omaha17.swe.logic.TechnicalException;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

public class PostLikeController extends HttpServlet {


    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    /**
     * Post Request for adding likes to a Post
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String postID = request.getParameter("postIDlike");

        //Which profile are we on
        String wallUserName = request.getParameter("userName");
        //Parameter whether the Like was made on the Dashboard, or on the Wall
        //If Wall, which wall

        HttpSession session=request.getSession(false);

        String myUserName = (String)session.getAttribute("userName");

        Boolean myWall = false;
        //Is it my own wall
        if (wallUserName.equals(myUserName)){
            myWall = true;
        }

        try {
            MessageManager.likeMessage(postID,wallUserName);

            response.sendRedirect(("/wall?userName="+ URLEncoder.encode(wallUserName, "UTF-8")+"&myWall="+myWall+"&userNotFound="+0));

        }catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }


    }
}