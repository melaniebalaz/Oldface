package at.omaha17.swe.controller;

import at.omaha17.swe.logic.AuthenticationException;
import at.omaha17.swe.logic.AuthenticationManager;
import at.omaha17.swe.model.User;
import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("")
public class LoginController extends HttpServlet {

    /**
     * The jtwig file renderer
     */
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

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
		String name = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			User user = AuthenticationManager.loginUser(name, password);

			HttpSession session=request.getSession();
			session.setAttribute("userName", name);

			String role = user.getRole();


			//If the user is a Senior, show their wall, otherwise redirect to the dashboard for Admin and Researcher
			if (role.equals("Senior")){
				response.sendRedirect("/wall");
			}
			else {
				response.sendRedirect("/dashboard");
			}

        }
        catch(AuthenticationException exception){

			//If the authentication fails redirect to error page
			if(exception.isTechnical()){
			    //This later needs to be redirected to the general error twig page
                renderer.dispatcherFor("/WEB-INF/templates/error/error.twig")
                        .render(request,response);
            }

            else {
				//FIND OUT THE REASON OF FAILURE, IF NOT TECHNICAL
				switch (exception.getReason()) {
					case BLOCKED_USER: {
						renderer.dispatcherFor("/WEB-INF/templates/external/login.twig")
								.with("blocked", true)
								.render(request,response);
						break;
					}
					case INVALID_PASSWORD:
						renderer.dispatcherFor("/WEB-INF/templates/external/login.twig")
								.with("error", true)
								.render(request,response);
						break;
					case INVALID_USER:
						renderer.dispatcherFor("/WEB-INF/templates/external/login.twig")
								.with("error", true)
								.render(request,response);
						break;
				}
			}

		}

	}

	//After login redirect to Wall

}
