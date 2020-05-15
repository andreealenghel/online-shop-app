package exceptions;

import javax.swing.JOptionPane;

public class WrongCode extends Exception{

String user;
	
	public WrongCode(String u) {
		super("Wrong code");
		JOptionPane.showMessageDialog(null, "Wrong Code");
		user = u;
	}
	
	public String getUser() {
		return user;
	}
}
