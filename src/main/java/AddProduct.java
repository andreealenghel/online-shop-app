import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddProduct extends JFrame {
	private JTextField Name;
	private JTextField Description;
	private JTextField Picture;
	private JTextField Price;
	public AddProduct() {
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(255, 153, 0));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(70, 127, 83, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(70, 202, 94, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Picture");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(70, 279, 83, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(70, 346, 56, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add a new product");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(184, 13, 370, 30);
		getContentPane().add(lblNewLabel_4);
		
		Name = new JTextField();
		Name.setBounds(272, 132, 116, 22);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(272, 204, 116, 22);
		getContentPane().add(Description);
		Description.setColumns(10);
		
		Picture = new JTextField();
		Picture.setBounds(272, 277, 116, 22);
		getContentPane().add(Picture);
		Picture.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(272, 344, 116, 22);
		getContentPane().add(Price);
		Price.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	        	conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
	        	String sql = "INSERT INTO prducts (Name, Price, Description, Image) VALUES (?, ?, ?, ?)";
	        	PreparedStatement pst = conn.prepareStatement(sql);
	        	pst.setString(1, Name.getText());
	        	pst.setString(2, Price.getText());
	        	pst.setString(3, Description.getText());
	        	pst.setString(4, Picture.getText());
	        	
	        	 pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Successfull added");
			        new ManagersPage().setVisible(true);
			        dispose();
			}catch(Exception e) {
	        	System.err.println(e);
	        }finally {
	        	try {
	        		if(conn != null)
	        			conn.close();
	        	}catch(SQLException e) {}
	        }
			
		}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBackground(new Color(0, 51, 255));
		btnSave.setBounds(457, 410, 97, 25);
		getContentPane().add(btnSave);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
