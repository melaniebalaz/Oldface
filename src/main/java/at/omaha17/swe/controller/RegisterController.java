package at.omaha17.swe.controller;

import at.omaha17.swe.logic.RegistrationFailedException;
import at.omaha17.swe.logic.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String password = request.getParameter("password");

        try {
            manager.registerUser("ROLE_SENIOR", name, password);
        } catch (RegistrationFailedException exception){
            response.sendRedirect("/registerError");
        }

        //redirect to the wall page
        HttpSession session=request.getSession();
        session.setAttribute("userName", name);
        response.sendRedirect("/wall");

    }

}
