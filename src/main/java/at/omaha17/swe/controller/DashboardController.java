package at.omaha17.swe.controller;

import at.omaha17.swe.logic.TechnicalException;
import at.omaha17.swe.logic.VisualizationManager;
import at.omaha17.swe.model.Dashboard;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();


        //If the user it not logged in, redirect to error page
        if(session.getAttribute("userName") == null){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

        String userName = (String) session.getAttribute("userName");

        try {

            //Dynamically loads the correct Dashboarda according the role
            Dashboard dashboard = VisualizationManager.getDashboard(userName);

            String role = dashboard.getUser().getRole();

            if (role.equals("Senior")){
                renderer.dispatcherFor("/WEB-INF/templates/internal/dashboard.twig")
                        .with("name", dashboard.getUser().getUsername())
                        .with("posts", dashboard.getPosts())
                        .render(request,response);
            }
            else if (role.equals("Admin")){
                renderer.dispatcherFor("/WEB-INF/templates/internal/admin_wall.twig")
                        .with("name", dashboard.getUser().getUsername())
                        .with("posts", dashboard.getPosts())
                        .render(request,response);
            }

            else if (role.equals("Researcher")){
                renderer.dispatcherFor("/WEB-INF/templates/internal/researcher_wall.twig")
                        .with("name", dashboard.getUser().getUsername())
                        .render(request,response);
            }



        }catch(TechnicalException exception){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

    }
}
