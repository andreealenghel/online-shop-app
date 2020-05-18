import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField username;
	private JTextField phone;
	private JTextField address;
	private JPasswordField password;
	private JTextField CodManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		lblNewLabel.setBounds(146, 13, 127, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 92, 124, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name : ");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(39, 141, 124, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username :");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 186, 124, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(39, 232, 124, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone :");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(39, 273, 124, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address :");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(39, 320, 124, 16);
		contentPane.add(lblNewLabel_6);
		
		firstName = new JTextField();
		firstName.setBounds(175, 91, 152, 22);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(174, 140, 153, 22);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(175, 180, 152, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(175, 272, 152, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(175, 319, 225, 22);
		contentPane.add(address);
		address.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(175, 231, 152, 22);
		contentPane.add(password);
		final JCheckBox checkManager = new JCheckBox("Manager");
		checkManager.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkManager.setBounds(92, 363, 98, 25);
		contentPane.add(checkManager);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Connection conn = null;
			        
			        try {
			        	Class.forName("com.mysql.jdbc.Driver").newInstance();
			        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			        	String sql = "INSERT INTO utilizatori (First_name, Last_name, Username, Password, Address, Phone, Manager) VALUES (?, ?, ?, ?, ?, ?, ?)";
			        	PreparedStatement pst = conn.prepareStatement(sql);
			        	pst.setString(1, firstName.getText());
			        	pst.setString(2, lastName.getText());
			        	pst.setString(3, username.getText());
			        	pst.setString(4, password.getText());
			        	//pst.setString( retypePassword.getText());
			        	pst.setString(5, address.getText());
			        	pst.setString(6, phone.getText());
			       
			        int manager;
			        if(checkManager.isSelected()) {
			        	String cod = CodManager.getText();
			        	if(cod.contentEquals("sef2020"))
			        		manager = 1;
			        	else
			        		throw new exceptions.WrongCode(cod);
			        }
			        else
			        	manager = 0;
			        pst.setInt(7, manager);
			        
			        String user = username.getText();
			        if(verifyUser(user))
			        	throw new exceptions.UserAlreadyExists(user);
			        
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Successfull register");
			        new LoginForm().setVisible(true);
			        dispose();
			        } catch(Exception e) {
			        	System.err.println(e);
			        }finally {
			        	try {
			        		if(conn != null)
			        			conn.close();
			        	}catch(SQLException e) {}
			        }
			    }//GEN-LAST:event_jButtonRegisterActionPerformed
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(77, 418, 113, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(233, 418, 116, 25);
		contentPane.add(btnNewButton_1);
		
		CodManager = new JTextField();
		CodManager.setText("Cod Manager");
		CodManager.setBounds(233, 365, 85, 22);
		contentPane.add(CodManager);
		CodManager.setColumns(10);
		
	
	}
	
	private boolean verifyUser(String u) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			
			String sql = "SELECT * FROM utilizatori WHERE username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				conn.close();
				return true;
			}
			
			conn.close();
		}catch(Exception e) {
			System.err.println(e);
		}
		return false;
	}
	
}
