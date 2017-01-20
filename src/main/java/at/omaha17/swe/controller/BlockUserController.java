package at.omaha17.swe.controller;

import at.omaha17.swe.logic.MessageManager;
import at.omaha17.swe.logic.TechnicalException;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/block")
public class BlockUserController {


    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    /**
     * POST Request for blocking a User
     * @param request
     * @param response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userName = request.getParameter("userName");

        try {
            MessageManager.deleteMessage(userName);

        }catch (TechnicalException e){
            renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                    .render(request, response);
        }

        response.sendRedirect("/dashboard");

    }
}
