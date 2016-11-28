package at.omaha17.oldface.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.omaha17.oldface.model.User;
import at.omaha17.oldface.logic.UserManager;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/index")
public class LoginController extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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

	}

}
