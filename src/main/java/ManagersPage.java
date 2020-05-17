import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagersPage extends JFrame {
	private static String name;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagersPage frame = new ManagersPage();
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
	
	private void showProducts() {
		java.sql.Connection conn = null;
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Description");
		model.addColumn("Image");
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin","root", "");
			String sql = "SELECT * FROM prducts";
			java.sql.PreparedStatement pts = conn.prepareStatement(sql);
			ResultSet rs = pts.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Name"),
						rs.getString("Price"),
						rs.getString("Description"),
						rs.getBlob("Image"),
						
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
		}catch(Exception e) {
			System.out.println("error" + e);
		}
		
	}  

	public ManagersPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showProducts();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 681);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListOfProducts = new JLabel("LIST OF PRODUCTS");
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
				
				new MakeOrder().setVisible(true);
				dispose();
				
			}
		});
		table.setBackground(SystemColor.activeCaption);
		
		table.setBounds(45, 48, 536, 436);
		contentPane.add(table);
		
		JButton btnAddProduct = new JButton("AddProduct");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddProduct().setVisible(true);
				dispose();
			}
		});
		btnAddProduct.setBackground(Color.BLACK);
		btnAddProduct.setForeground(new Color(255, 102, 51));
		btnAddProduct.setBounds(45, 533, 106, 25);
		contentPane.add(btnAddProduct);
		
		JButton btnNewButton = new JButton("Delete Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteProduct().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(new Color(255, 153, 51));
		btnNewButton.setBounds(253, 533, 138, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify Products");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(new Color(255, 153, 0));
		btnNewButton_1.setBounds(488, 533, 131, 25);
		contentPane.add(btnNewButton_1);
	}
}
