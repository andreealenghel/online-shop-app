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

public class Modify extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Modify() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mofify a product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(115, 13, 195, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name of the product");
		lblNewLabel_1.setBounds(26, 66, 147, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New name");
		lblNewLabel_2.setBounds(26, 96, 108, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New price");
		lblNewLabel_3.setBounds(26, 137, 118, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New description");
		lblNewLabel_4.setBounds(26, 181, 118, 16);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(194, 63, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 93, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 134, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 178, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagersPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(296, 213, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				try {
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
					String sql = "UPDATE prducts SET Name =?, Price =?, Description=?  WHERE  Name =? ";
					
					PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Successful modified");
					new ManagersPage().setVisible(true);
					dispose();
				}catch(Exception e1) {
		        	System.err.println(e1);
		        }finally {
		        	try {
		        		if(conn != null)
		        			conn.close();
		        	}catch(SQLException e1) {}
		        }
			}
		});
		btnNewButton_1.setBounds(76, 210, 97, 25);
		getContentPane().add(btnNewButton_1);
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify frame = new Modify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
