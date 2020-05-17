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
		getContentPane().setBackground(new Color(0, 51, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of the Product ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 98, 156, 41);
		getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(220, 108, 123, 27);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete a product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(127, 27, 169, 27);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagersPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(246, 201, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
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
		btnNewButton_1.setBounds(46, 201, 97, 25);
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
