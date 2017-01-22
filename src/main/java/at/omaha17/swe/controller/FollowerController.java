package at.omaha17.swe.controller;

import at.omaha17.swe.logic.ProfileManager;
import at.omaha17.swe.logic.TechnicalException;
import at.omaha17.swe.model.Senior;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Vector;


@WebServlet("/follow")
public class FollowerController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String followsUserName = request.getParameter("followsUser");
        HttpSession session=request.getSession(false);
        String followerUserName = (String)session.getAttribute("userName");

        try {
            ProfileManager.followProfile(followerUserName,followsUserName);
            response.sendRedirect("/wall?userName="+ URLEncoder.encode(followsUserName, "UTF-8")+"&userNotFound="+0);

        }catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/error/error.twig")
                    .render(request,response);
        }

    }


    /**
     * Request for rendering a Wall
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageUserName = request.getParameter("userName");

        try {
            Vector<Senior> followers = ProfileManager.getProfileFollower(currentPageUserName);
            renderer.dispatcherFor("/WEB-INF/templates/internal/showFriends.twig")
                    .with("name",currentPageUserName)
                    .with("friends",followers)
                    .render(request,response);
            
        }catch(TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request,response);
        }

    }
}
