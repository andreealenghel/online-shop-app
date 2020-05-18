import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME!");
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setFont(new Font("Engravers MT", Font.BOLD, 27));
		lblWelcome.setBounds(307, 120, 218, 94);
		contentPane.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(99, 303, 132, 44);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(new Color(255, 165, 0));
		btnRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(328, 303, 124, 44);
		contentPane.add(btnRegister);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/online-shop-logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(12, 13, 272, 257);
		contentPane.add(label);
	}
}
