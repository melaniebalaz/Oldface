package at.omaha17.swe.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class AdminFunctionalityController extends HttpServlet {

    /**
     * POST Request for deleting a post
     * @param request
     * @param response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    /**
     * GET Request for blocking a User
     * @param request
     * @param response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
