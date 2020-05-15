import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MakeOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setBounds(100, 100, 458, 498);
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
		
		textField = new JTextField();
		textField.setBounds(131, 79, 221, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(22, 136, 84, 16);
		contentPane.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 134, 221, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PHONE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 190, 85, 16);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 188, 221, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPayMethod = new JLabel("PAY METHOD:");
		lblPayMethod.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPayMethod.setBounds(22, 237, 106, 22);
		contentPane.add(lblPayMethod);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 238, 222, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(32, 287, 96, 16);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 285, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnOrder = new JButton("ORDER");
		btnOrder.setBounds(83, 369, 97, 25);
		contentPane.add(btnOrder);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(240, 369, 97, 25);
		contentPane.add(btnCancel);
	}
}
