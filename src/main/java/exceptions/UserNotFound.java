package exceptions;

import javax.swing.JOptionPane;

public class UserNotFound extends Exception{
	
String user;
	
	public UserNotFound(String u) {
		super("User not found");
		JOptionPane.showMessageDialog(null, "User not found");
		user = u;
	}
	
	public String getUser() {
		return user;
	}

}
