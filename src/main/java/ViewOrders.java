import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewOrders extends JFrame{
	
	private static String name;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrders frame = new ViewOrders();
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
	
	private void showOrders() {
		java.sql.Connection conn = null;
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Pay_method");
		model.addColumn("Quantity");
		model.addColumn("Product");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			String sql = "SELECT * FROM comenzi";
			java.sql.PreparedStatement pts = conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("Address"),
						rs.getString("Phone"),
						rs.getString("Pay_method"),
						rs.getInt("Quantity"),
						rs.getString("Product"),
						
						
				});
			}
			
			rs.close();
			pts.close();
			conn.close();
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(200);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(2000);
			table.getColumnModel().getColumn(3).setPreferredWidth(2000);
			table.getColumnModel().getColumn(3).setPreferredWidth(2000);
			table.getColumnModel().getColumn(3).setPreferredWidth(2000);
		}catch(Exception e) {
			System.out.println("error" + e);
		}
		
	}  

	public ViewOrders() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showOrders();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 569);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListOfProducts = new JLabel("LIST OF Orders");
		lblListOfProducts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListOfProducts.setBounds(207, 13, 184, 22);
		contentPane.add(lblListOfProducts);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				 name = model.getValueAt(index, 1).toString();
				
				
			}
		});
		table.setBackground(SystemColor.activeCaption);
		
		table.setBounds(33, 48, 536, 436);
		contentPane.add(table);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagersPage().setVisible(true);;
				dispose();
			}
		});
		btnNewButton.setBounds(392, 497, 97, 25);
		contentPane.add(btnNewButton);
	}
	/*public static String getName() {
		return name;
	}*/
	

}
