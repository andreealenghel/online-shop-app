package exceptions;

import javax.swing.JOptionPane;

public class UserAlreadyExists extends Exception{

	String user;
	
	public UserAlreadyExists(String u) {
		super("This username already exists.");
		JOptionPane.showMessageDialog(null, "This username already exists");
		user = u;
	}
	
	public String getUser() {
		return user;
	}
	
}
