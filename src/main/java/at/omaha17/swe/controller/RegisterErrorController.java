package at.omaha17.swe.controller;

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterErrorController {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderer.dispatcherFor("/WebContent/templates/error/registerError.twig")
                .render(request,response);

    }
}
