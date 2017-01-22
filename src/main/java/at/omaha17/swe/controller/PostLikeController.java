package at.omaha17.swe.controller;

import at.omaha17.swe.logic.MessageManager;
import at.omaha17.swe.logic.TechnicalException;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/like")
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

        String postID = request.getParameter("id");

        //Which profile are we on
        String currentPageUserName = request.getParameter("userName");

        try {
            MessageManager.likeMessage(postID,currentPageUserName);

            response.sendRedirect(("/wall?userName="+ URLEncoder.encode(currentPageUserName, "UTF-8")+"&userNotFound="+0));

        }catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }


    }
}
