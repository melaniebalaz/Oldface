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


@WebServlet("/editProfile")
public class EditProfileInfoController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();


    /**
     * Post Request for posting the new short abstract that should be portrayed on the Users Wall
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession(false);

        String userName = (String) session.getAttribute("userName");

        String newAbstract = request.getParameter("abstract");
        String newDisplayName = request.getParameter("displayName");

        try {
            ProfileManager.updateProfile(userName,newDisplayName,newAbstract);
            response.sendRedirect("/wall?userName="+ URLEncoder.encode(userName, "UTF-8")+"&userNotFound="+0);
        }
        catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
