package at.omaha17.swe.controller;

import at.omaha17.swe.logic.AuthenticationException;
import at.omaha17.swe.logic.AuthenticationManager;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static at.omaha17.swe.model.User.*;

/**
 * The Register Controller is responsible for the first time registering of a User.
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //This just renders the register page, static page
        renderer.dispatcherFor("/WEB-INF/templates/external/register.twig")
                .render(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {

            //redirect to the wall page
            HttpSession session=request.getSession();
            session.setAttribute("userName", name);
            session.setAttribute("role", role);


            if (role.equals("Senior")){
                AuthenticationManager.registerUser(ROLE_SENIOR, name, password);
                response.sendRedirect("/wall");
            }
            else if(role.equals("Admin")) {
                AuthenticationManager.registerUser(ROLE_ADMIN, name, password);
                response.sendRedirect("/dashboard");
            }
            else if(role.equals("Researcher")){
                AuthenticationManager.registerUser(ROLE_RESEARCHER, name, password);
                response.sendRedirect("/dashboard");

            }


        } catch (AuthenticationException exception){
            if (exception.isTechnical())
                renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                        .render(request, response);
            else
                renderer.dispatcherFor("/WEB-INF/templates/external/register.twig")
                        .with("error", true)
                        .render(request, response);
        }

    }

}
