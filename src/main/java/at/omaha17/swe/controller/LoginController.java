package at.omaha17.swe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.omaha17.swe.logic.UserManagerInterface;
import at.omaha17.swe.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	UserManagerInterface manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController(UserManagerInterface manager) {
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
        //manager.authenticate();

        response.setHeader("Set-Cookie", "authenticationToken=" );
	}

	//After login redirect to Wall

}
