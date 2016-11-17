package at.omaha17.oldface.logic;

import at.omaha17.oldface.model.User;
import at.omaha17.oldface.dao.UserDAO;

public class UserManager {
	private UserDAO userDAO;

	public User authenticate(String username, String password) {
		for (User user : userDAO.getUserList()) {
			if (password == user.getPassword()) return user;
		}
		
		return null;
	}
}
