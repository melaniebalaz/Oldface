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

/**
 * Servlet implementation class LoginController
 */
@WebServlet("")
public class LoginController extends HttpServlet {

	UserManager manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController(UserManager manager) {
        this.manager = manager;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		try {
            manager.authenticateUser(name,password);
        }catch(AuthenticationFailedException exception){
            response.sendRedirect("/loginError");
        }

        HttpSession session=request.getSession();
        session.setAttribute("userName", name);
        response.sendRedirect("/wall");


	}

	//After login redirect to Wall

}
