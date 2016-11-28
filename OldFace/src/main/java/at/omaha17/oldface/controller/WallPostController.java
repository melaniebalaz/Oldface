package at.omaha17.oldface.controller;

import at.omaha17.oldface.logic.WallManagerInterface;
import at.omaha17.oldface.model.Wall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wall")
public class WallPostController extends HttpServlet {
    WallManagerInterface manager;

    public WallPostController(WallManagerInterface manager){
        this.manager = manager;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //return the JSP Page
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String authToken = request.getCookies()["authentication-token"];

        //add a new Post to the Wall of the User
    }
}
