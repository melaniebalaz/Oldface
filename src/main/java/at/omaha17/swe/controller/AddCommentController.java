package at.omaha17.swe.controller;

import at.omaha17.swe.logic.MessageManager;
import at.omaha17.swe.logic.TechnicalException;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/comment")
public class AddCommentController extends HttpServlet {


    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        String postID = request.getParameter("postID");

        //Username of who made the comment
        String currentPageUserName = request.getParameter("wallUserName");

        HttpSession session=request.getSession(false);
        String myUserName = (String) session.getAttribute("userName");


        Boolean myWall = false;
        //Is it my own wall
        if (currentPageUserName.equals(myUserName)){
            myWall = true;
        }

        try {
            MessageManager.addComment(postID, myUserName, comment);
            response.sendRedirect(("/wall?userName="+ URLEncoder.encode(currentPageUserName, "UTF-8")+"&userNotFound="+0));
        }catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }



    }
}
