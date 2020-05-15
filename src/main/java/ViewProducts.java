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

public class ViewProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProducts frame = new ViewProducts();
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

	public ViewProducts() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				showProducts();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 569);
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
				String name = model.getValueAt(index, 1).toString();
				
				new MakeOrder().setVisible(true);
				dispose();
				
			}
		});
		table.setBackground(SystemColor.activeCaption);
		
		table.setBounds(33, 125, 536, 436);
		contentPane.add(table);
	}
}
