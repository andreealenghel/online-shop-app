import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
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
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DeleteProduct extends JFrame{
	private JTextField name;
	public DeleteProduct() {
		getContentPane().setBackground(new Color(30, 144, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of the Product ");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 98, 216, 41);
		getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(247, 107, 123, 27);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete a product");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel_1.setBounds(89, 27, 219, 41);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagersPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(239, 184, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
				try {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
				String sql = "DELETE FROM prducts WHERE Name=?";
				 
				PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
				pst.setString(1, name.getText());
				 
				int rowsDeleted = pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Successful deleted");
				new ManagersPage().setVisible(true);
				dispose();
			}catch (Exception e) {
				System.err.println(e);
			}finally {
				try {
					if (conn != null)
						conn.close();
				}catch(SQLException e) {}
			}
			}
		});
		btnNewButton_1.setBounds(75, 184, 97, 25);
		getContentPane().add(btnNewButton_1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteProduct delete = new DeleteProduct();
					delete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
