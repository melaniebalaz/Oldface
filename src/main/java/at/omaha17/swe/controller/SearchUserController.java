package at.omaha17.swe.controller;

import at.omaha17.swe.logic.ProfileManager;
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


@WebServlet("/search")
public class SearchUserController extends HttpServlet {


    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    /**
     * This method handles get requests from the searchbar and searches for the User in question, and renders their wall if found.
     * If not it renders the Users own wall with the user Not found error
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession(false);
        String myUserName = (String)session.getAttribute("userName");


        //Get the parameter from the GET Request, userName of the user searched for
        String searchUserName = (String)request.getAttribute("userName");

        //TODO check whether the profile actually exists or not
        //If the searched for User does not exist, render the original Wall with the search Error set to true

        try {
            Boolean userExists = ProfileManager.isProfile(searchUserName);

            if (userExists) {
                //Render the page of the other User, encode the Username
                response.sendRedirect("/wall?userName="+ URLEncoder.encode(searchUserName, "UTF-8")+"&myWall="+0+"&userNotFound="+0);
            }
            else {
                //Render the own page
                response.sendRedirect("/wall?userName="+ URLEncoder.encode(myUserName, "UTF-8")+"&myWall="+1+"&userNotFound="+1);
            }

        }catch(TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }
        
    }

}
