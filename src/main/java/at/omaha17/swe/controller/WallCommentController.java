package at.omaha17.swe.controller;

import at.omaha17.swe.logic.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/comment")
public class WallCommentController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        String postID = request.getParameter("postID");

        HttpSession session=request.getSession();
        String userName = (String) session.getAttribute("userName");

        try {
            MessageManager.addComment(postID, userName, comment);
            //Need to make a different redirect if a comment has been added on the dashboard..two controllers?
            response.sendRedirect("/wall");
        }catch(TechnicalException exception){
            //redirect to Comment error page
        }



    }
}
