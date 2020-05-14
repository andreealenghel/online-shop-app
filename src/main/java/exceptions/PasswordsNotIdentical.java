package exceptions;

import javax.swing.JOptionPane;

public class PasswordsNotIdentical extends Exception{

String user;
	
	public PasswordsNotIdentical(String u) {
		super("The 2 passwords are not identical");
		JOptionPane.showMessageDialog(null, "This username already exists");
		user = u;
	}
	
	public String getUser() {
		return user;
	}
	
}
