package at.omaha17.swe.controller;

import at.omaha17.swe.logic.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.jtwig.web.servlet.JtwigRenderer;

/**
 * The Register Controller is responsible for the first time registering of a User.
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private UserManager manager;

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    public RegisterController(UserManager manager) {
        this.manager = manager;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //This just renders the register page, static page
        renderer.dispatcherFor("/WebContent/templates/external/register.twig")
                .render(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        manager.registerUser()

        //Now sent the user details to the user manager with the method call of register user
        //Hope that this call returns me a authentification token
        //Wrap the whole thing in a try catch block, if I get an exception render the error page

        //redirect to the wall page
        response.sendRedirect("/wall");

    }

}
