package at.omaha17.swe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.omaha17.swe.logic.AuthenticationFailedException;
import at.omaha17.swe.logic.UserManager;
import at.omaha17.swe.logic.UserManagerImpl;
import org.jtwig.web.servlet.JtwigRenderer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("")
public class LoginController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

	private UserManager manager = new UserManagerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /** Dependency Injection - next iteration
    public LoginController(UserManager manager) {
        this.manager = manager;
    }
     **/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        renderer.dispatcherFor("/WEB-INF/templates/external/login.twig")
                .render(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try {
            manager.authenticateUser(name,password);
        }catch(AuthenticationFailedException exception){
			//If the authentication fails redirect to error page
            response.sendRedirect("/loginError");
        }

        HttpSession session=request.getSession();
        session.setAttribute("userName", name);
        response.sendRedirect("/wall");
	}

	//After login redirect to Wall

}
