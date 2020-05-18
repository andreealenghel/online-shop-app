import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MakeOrder extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField pay;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeOrder frame = new MakeOrder();
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
	public MakeOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroducetiDatele = new JLabel("FILL IN THE FORM");
		lblIntroducetiDatele.setForeground(new Color(0, 0, 128));
		lblIntroducetiDatele.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIntroducetiDatele.setBounds(113, 34, 221, 30);
		contentPane.add(lblIntroducetiDatele);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblName.setBounds(22, 95, 84, 30);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(162, 100, 221, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setForeground(new Color(0, 0, 128));
		lblAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblAddress.setBounds(22, 153, 96, 16);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(162, 151, 221, 22);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PHONE:");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 203, 85, 16);
		contentPane.add(lblNewLabel);
		
		phone = new JTextField();
		phone.setBounds(162, 201, 221, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblPayMethod = new JLabel("PAY METHOD:");
		lblPayMethod.setForeground(new Color(0, 0, 128));
		lblPayMethod.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblPayMethod.setBounds(22, 249, 127, 22);
		contentPane.add(lblPayMethod);
		
		pay = new JTextField();
		pay.setBounds(161, 250, 222, 22);
		contentPane.add(pay);
		pay.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setForeground(new Color(0, 0, 255));
		lblQuantity.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblQuantity.setBounds(22, 303, 96, 16);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(162, 301, 116, 22);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton btnOrder = new JButton("ORDER");
		
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection conn = null;
			        
			        try {
			        	Class.forName("com.mysql.jdbc.Driver").newInstance();
			        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			        	String sql = "INSERT INTO comenzi (Name, Address, Phone, Pay_method, Qunatity, Product) VALUES (?, ?, ?, ?, ?, ?)";
			        	PreparedStatement pst = conn.prepareStatement(sql);
			        	pst.setString(0, name.getText());
			        	pst.setString(1, address.getText());
			        	pst.setString(2, phone.getText());
			        	pst.setString(3, pay.getText());
			        	//pst.setString( retypePassword.getText());
			        	pst.setString(4, quantity.getText());
			        	//pst.setString(5, ViewProducts.getName());
			        	
			}catch (Exception e1) {
				System.err.println(e);
			}finally {
				try {
					if(conn != null)
						conn.close();
					
				}catch(SQLException x) {}
			}
			}
		});
		btnOrder.setBounds(80, 376, 97, 25);
		contentPane.add(btnOrder);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewProducts().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(237, 376, 97, 25);
		contentPane.add(btnCancel);
	}
}
