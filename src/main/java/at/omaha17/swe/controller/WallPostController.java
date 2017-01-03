package at.omaha17.swe.controller;

import at.omaha17.swe.logic.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/post")
public class WallPostController extends HttpServlet {

    /**
    public WallPostController(WallManager manager){
        this.manager = manager;
    }
     **/

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String postContent = request.getParameter("blogPost");

        HttpSession session=request.getSession();
        String userName = (String) session.getAttribute("userName");

        try {
            //add the new post
            MessageManager.addPost(userName, userName, postContent);
            //redirect to the Wall Controller which loads all the current posts
            response.sendRedirect("/wall");

        }catch(TechnicalException exception){
            //redirect to Error posting Post page
            //If the current user cannot be found, redirect to to the logout Page
            response.sendRedirect("/logout");
        }

    }
}
