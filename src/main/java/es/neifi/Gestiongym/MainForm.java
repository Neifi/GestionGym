package es.neifi.Gestiongym;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import es.neifi.controller.LoginController;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passwordField;
	private LoginController loginController;
	private Color color1;
	private Color color2;
	private Color color3;
	private Color color4;
	private Color color5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void colorPalette() {
		color1 = new Color(11,62,113);
		color2 = new Color(0,190,141);
		color3 = new Color(0,209,155);
		color4 = new Color(0,247,181);
		color5 = new Color(248,249,239);
		
	}
	/**
	 * Create the frame.
	 */
	public MainForm() {
		colorPalette();
		
		loginController = new LoginController();
		
		Icon logo = new ImageIcon("C:\\Users\\Neifi\\eclipse-workspace\\Gestiongym\\neifiGymLogo.JPG");
		setOpacity(1);
		setResizable(false);
		setTitle("GestionGym");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBounds(getX(), getY(), getWidth(), getHeight());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 0, 1920, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnX = new JButton("x");
		btnX.setForeground(Color.WHITE);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setSelectedIcon(null);
		btnX.setIcon(null);
		btnX.setBackground(Color.ORANGE);
		btnX.setBounds(1858, 0, 45, 30);
		btnX.setBorderPainted(false);
		btnX.setFocusPainted(true);
		
		panel_1.add(btnX);
		
		JButton btnX_1 = new JButton("-");
		btnX_1.setFocusPainted(true);
		btnX_1.setBorderPainted(false);
		btnX_1.setBackground(Color.ORANGE);
		btnX_1.setBounds(1796, 0, 45, 30);
		panel_1.add(btnX_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(798, 424, 295, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblPassword.setBounds(57, 88, 121, 27);
		panel_2.add(lblPassword);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblUser.setBounds(57, 42, 78, 23);
		panel_2.add(lblUser);
		
		userText = new JTextField();
		userText.setBounds(47, 39, 214, 27);
		userText.setBorder(BorderFactory.createEmptyBorder());
		panel_2.add(userText);
		userText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(47, 88, 214, 27);
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		lblPassword.setLabelFor(passwordField);
		panel_2.add(passwordField);
		
		
		JButton btnLogin = new JButton("LOGIN");
		
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 19));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(47, 140, 214, 23);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(true);
		btnLogin.setBackground(Color.GRAY);
		panel_2.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel(logo);
		lblNewLabel.setBounds(745, 341, 411, 72);
		
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNeifiAlcantara = new JLabel("Neifi Alcantara 2020");
		lblNeifiAlcantara.setForeground(Color.WHITE);
		lblNeifiAlcantara.setBounds(1780, 1039, 130, 30);
		panel.add(lblNeifiAlcantara);
	}
	
}
