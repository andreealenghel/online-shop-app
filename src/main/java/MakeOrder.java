import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 440, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroducetiDatele = new JLabel("INTRODUCETI DATELE");
		lblIntroducetiDatele.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIntroducetiDatele.setBounds(130, 13, 176, 30);
		contentPane.add(lblIntroducetiDatele);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 74, 55, 30);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(131, 79, 221, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(22, 136, 84, 16);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(130, 134, 221, 22);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PHONE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 190, 85, 16);
		contentPane.add(lblNewLabel);
		
		phone = new JTextField();
		phone.setBounds(131, 188, 221, 22);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblPayMethod = new JLabel("PAY METHOD:");
		lblPayMethod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPayMethod.setBounds(22, 237, 106, 22);
		contentPane.add(lblPayMethod);
		
		pay = new JTextField();
		pay.setBounds(130, 238, 222, 22);
		contentPane.add(pay);
		pay.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(32, 287, 96, 16);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(130, 285, 116, 22);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JButton btnOrder = new JButton("ORDER");
		
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection conn = null;
			        
			        try {
			        	Class.forName("com.mysql.jdbc.Driver").newInstance();
			        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			        	String sql = "INSERT INTO comenzi (Name, Address, Phone, Pay_method, Quantity, Product) VALUES (?, ?, ?, ?, ?, ?)";
			        	PreparedStatement pst = conn.prepareStatement(sql);
			        	pst.setString(1, name.getText());
			        	pst.setString(2, address.getText());
			        	pst.setString(3, phone.getText());
			        	pst.setString(4, pay.getText());
			        	//pst.setString( retypePassword.getText());
			        	pst.setString(5, quantity.getText());
			        	pst.setString(6, "product");
			        	
			        	pst.executeUpdate();
			        	JOptionPane.showMessageDialog(null, "Order placed");
			        	new ViewProducts().setVisible(true);;
			        	dispose();
			        	
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
		btnOrder.setBounds(83, 369, 97, 25);
		contentPane.add(btnOrder);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewProducts().setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(240, 369, 97, 25);
		contentPane.add(btnCancel);
	}
}
