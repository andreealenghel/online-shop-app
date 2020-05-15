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
		setBounds(100, 100, 456, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 130, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(143, 45, 127, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 92, 124, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(39, 121, 124, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 150, 124, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(39, 192, 124, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(39, 221, 124, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(39, 250, 124, 16);
		contentPane.add(lblNewLabel_6);
		
		firstName = new JTextField();
		firstName.setBounds(187, 89, 116, 22);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(187, 118, 116, 22);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		username = new JTextField();
		username.setBounds(187, 150, 116, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(187, 218, 116, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		address = new JTextField();
		address.setBounds(187, 247, 116, 22);
		contentPane.add(address);
		address.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(187, 189, 116, 22);
		contentPane.add(password);
		final JCheckBox checkManager = new JCheckBox("Manager");
		checkManager.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkManager.setBounds(50, 289, 113, 25);
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
		btnNewButton.setBounds(66, 329, 127, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(238, 329, 97, 25);
		contentPane.add(btnNewButton_1);
		
		CodManager = new JTextField();
		CodManager.setText("Cod Manager");
		CodManager.setBounds(187, 291, 116, 22);
		contentPane.add(CodManager);
		CodManager.setColumns(10);
		
	
	}
}
