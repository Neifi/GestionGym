package es.neifi.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class AltaClientes extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField txtDni;
	private JLabel lblDni;
	private JLabel lblFechaDeNacimiento;
	private JTextField textField;
	private JLabel lblAlta;

	/**
	 * Create the panel.
	 */
	public AltaClientes() {
		setBackground(Color.ORANGE);
		setBounds(263, 30, 461, 500);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblNombre.setBounds(112, 73, 130, 15);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 98, 215, 19);
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(112, 165, 215, 19);
		add(txtApellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 19));
		lblApellidos.setBounds(112, 140, 215, 15);
		add(lblApellidos);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(112, 221, 215, 19);
		add(txtEmail);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 19));
		lblEmail.setBounds(112, 196, 215, 15);
		add(lblEmail);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtDni.setColumns(10);
		txtDni.setBounds(112, 277, 215, 19);
		add(txtDni);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Dialog", Font.BOLD, 19));
		lblDni.setBounds(112, 252, 215, 15);
		add(lblDni);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.BOLD, 19));
		lblFechaDeNacimiento.setBounds(112, 308, 246, 15);
		add(lblFechaDeNacimiento);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(112, 333, 215, 19);
		add(textField);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(112, 391, 154, 55);
		btnRegistrar.setBackground(Color.DARK_GRAY);
		btnRegistrar.setForeground(Color.ORANGE);
		btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setFocusPainted(true);
		add(btnRegistrar);
		
		JCheckBox chckbxAdmin = new JCheckBox("Administrador");
		chckbxAdmin.setBackground(Color.ORANGE);
		chckbxAdmin.setBounds(112, 360, 129, 23);
		add(chckbxAdmin);
		
		lblAlta = new JLabel("Altas");
		lblAlta.setFont(new Font("Dialog", Font.BOLD, 26));
		lblAlta.setBounds(182, 24, 84, 28);
		add(lblAlta);
		
	}
}
