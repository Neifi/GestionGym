package es.neifi.Gestiongym;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import es.neifi.controller.LoginController;
import es.neifi.controller.LoginController.User;
import es.neifi.view.CrudClientView;

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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		color1 = new Color(11, 62, 113);
		color2 = new Color(0, 190, 141);
		color3 = new Color(0, 209, 155);
		color4 = new Color(0, 247, 181);
		color5 = new Color(248, 249, 239);

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
		setBounds(100, 100, 720, 524);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);

		// contentPane.setBounds(getX(), getY(), getWidth(), getHeight());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 718, 495);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(215, 160, 295, 211);
		panel.add(panel_2);
		panel.setBorder(BorderFactory.createEmptyBorder());
		panel_2.setLayout(null);

		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setToolTipText("Contraseña ");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblPassword.setBounds(47, 77, 121, 27);
		panel_2.add(lblPassword);

		final JLabel lblUser = new JLabel("User");
		lblUser.setToolTipText("Nombre de usuario");
		lblUser.setForeground(Color.BLACK);
		lblUser.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblUser.setBounds(47, 21, 78, 23);
		panel_2.add(lblUser);

		userText = new JTextField();
		userText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		userText.setBounds(47, 49, 214, 27);
		userText.setBorder(BorderFactory.createEmptyBorder());
		panel_2.add(userText);
		userText.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				

					if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
						if (loginController.validateLogin(userText.getText(), passwordField.getText()) == User.ADMIN) {
							setVisible(false);
							CrudClientView crudClientView = new CrudClientView();
									crudClientView.setVisible(true);
						}else if(loginController.validateLogin(userText.getText(), passwordField.getText()) == User.CLIENT) {
							//TODO checkListview
						}else if(loginController.validateLogin(userText.getText(), passwordField.getText()) == User.NOPE) {
							JOptionPane.showMessageDialog(null, "Credenciales invalidas");
						}
					}
				
			}
		});
		passwordField.setColumns(10);
		passwordField.setBounds(47, 102, 214, 27);
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		lblPassword.setLabelFor(passwordField);
		panel_2.add(passwordField);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			// TODO passwordField.getPassword()
			public void actionPerformed(ActionEvent e) {
				if (loginController.validateLogin(userText.getText(), passwordField.getText()) == User.ADMIN) {
					setVisible(false);
					CrudClientView crudClientView = new CrudClientView();
					crudClientView.setVisible(true);
				}else if(loginController.validateLogin(userText.getText(), passwordField.getText()) == User.CLIENT) {
					//TODO checkListview
				}else if(loginController.validateLogin(userText.getText(), passwordField.getText()) == User.NOPE) {
					JOptionPane.showMessageDialog(null, "Credenciales invalidas");
				}
			}
		});

		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 19));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(47, 140, 214, 43);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(true);
		btnLogin.setBackground(Color.GRAY);
		panel_2.add(btnLogin);

		JLabel lblNeifiAlcantara = new JLabel("Neifi Alcantara 2020");
		lblNeifiAlcantara.setForeground(Color.WHITE);
		lblNeifiAlcantara.setBounds(1780, 1039, 130, 30);
		panel.add(lblNeifiAlcantara);

		JLabel lblGestinGymPro = new JLabel("GESTIÓN GYM PRO");
		lblGestinGymPro.setToolTipText("Neifi Alcantara 2020  \r\nwww.github.com/neifi");
		lblGestinGymPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinGymPro.setFont(new Font("Segoe UI", Font.BOLD, 31));
		lblGestinGymPro.setBounds(215, 97, 295, 52);
		panel.add(lblGestinGymPro);
	}

}
