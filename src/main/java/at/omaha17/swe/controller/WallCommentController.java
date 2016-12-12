package at.omaha17.swe.controller;

import at.omaha17.swe.logic.UserManager;
import at.omaha17.swe.logic.UserManagerImpl;
import at.omaha17.swe.logic.WallManager;
import at.omaha17.swe.logic.WallManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class WallCommentController extends HttpServlet {

    WallManager wallManager = new WallManagerImpl();
    UserManager userManager = new UserManagerImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postContent = request.getParameter("comment");
        String postID = request.getParameter("postID");

        //wallManager.addComment(Post post, Senior author, String postContent);


    }
}
