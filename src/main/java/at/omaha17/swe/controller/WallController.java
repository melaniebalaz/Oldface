package at.omaha17.swe.controller;

import at.omaha17.swe.logic.WallManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wall")
public class WallController extends HttpServlet {
    WallManager manager;

    public WallController(WallManager manager){
        this.manager = manager;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**

        request.setAttribute("variable", "Hello");

        renderer.dispatcherFor("/WebContent/templates/internal/wall.twig")
                .with("firstname", firstName)
                .render(request, response);

         **/

    }
}
