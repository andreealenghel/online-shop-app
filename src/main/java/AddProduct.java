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
		getContentPane().setBackground(new Color(255, 218, 185));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(53, 130, 94, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(53, 194, 137, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Picture");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(56, 262, 97, 36);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(53, 334, 72, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add a new product");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_4.setBounds(101, 28, 317, 70);
		getContentPane().add(lblNewLabel_4);
		
		Name = new JTextField();
		Name.setBounds(182, 139, 172, 30);
		getContentPane().add(Name);
		Name.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(182, 194, 243, 42);
		getContentPane().add(Description);
		Description.setColumns(10);
		
		Picture = new JTextField();
		Picture.setBounds(182, 261, 160, 44);
		getContentPane().add(Picture);
		Picture.setColumns(10);
		
		Price = new JTextField();
		Price.setBounds(182, 336, 126, 36);
		getContentPane().add(Price);
		Price.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
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
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBackground(new Color(255, 250, 240));
		btnSave.setBounds(299, 415, 119, 36);
		getContentPane().add(btnSave);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagersPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 250, 240));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(100, 415, 119, 36);
		getContentPane().add(btnNewButton);
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
