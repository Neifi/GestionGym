package es.neifi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import es.neifi.controller.AdminController;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;

public class CrudClientView extends JFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Create the panel.
	 */
	public CrudClientView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.ORANGE);
		setBackground(Color.BLACK);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		getContentPane().setLayout(null);
		//TODO get maxscreen size
		setBounds(0,0,1920,1080);
		
		JPanel windowTab = new JPanel();
		windowTab.setBounds(0, 0, 1920, 30);
		windowTab.setBackground(Color.DARK_GRAY);
		getContentPane().add(windowTab);
		windowTab.setLayout(null);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.setBounds(1851, 0, 52, 30);
		windowTab.add(btnX);
		btnX.setForeground(Color.ORANGE);
		btnX.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnX.setFocusPainted(true);
		btnX.setBorderPainted(false);
		btnX.setBackground(Color.DARK_GRAY);
		
		JPanel leftColumnBrand = new JPanel();
		leftColumnBrand.setBackground(new Color(30, 144, 255));
		leftColumnBrand.setBounds(0, 100, 246, 980);
		getContentPane().add(leftColumnBrand);
		leftColumnBrand.setLayout(null);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBackground(Color.DARK_GRAY);
		btnClientes.setForeground(Color.ORANGE);
		btnClientes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnClientes.setBounds(0, 2, 246, 70);
		leftColumnBrand.add(btnClientes);
		btnClientes.setBorderPainted(false);
		btnClientes.setFocusPainted(true);
		
		JButton btnAltas = new JButton("Altas");
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltas.setBackground(Color.DARK_GRAY);
		btnAltas.setForeground(Color.ORANGE);
		btnAltas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnAltas.setBounds(0, 74, 246, 70);
		leftColumnBrand.add(btnAltas);
		btnAltas.setBorderPainted(false);
		btnAltas.setFocusPainted(true);
		
		JButton btnRegistros = new JButton("Registros");
		btnRegistros.setForeground(Color.ORANGE);
		btnRegistros.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnRegistros.setFocusPainted(true);
		btnRegistros.setBorderPainted(false);
		btnRegistros.setBackground(Color.DARK_GRAY);
		btnRegistros.setBounds(0, 146, 246, 70);
		leftColumnBrand.add(btnRegistros);
		JPanel leftColumnMenu = new JPanel();
		leftColumnMenu.setBackground(new Color(30, 144, 255));
		leftColumnMenu.setBounds(0, 30, 246, 70);
		getContentPane().add(leftColumnMenu);
		leftColumnMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTIÓN GYM PRO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblNewLabel.setBounds(33, 11, 180, 44);
		leftColumnMenu.add(lblNewLabel);
		
		JPanel vewDataEdit = new JPanel();
		vewDataEdit.setBackground(Color.ORANGE);
		vewDataEdit.setBounds(245, 30, 1675, 1050);
		getContentPane().add(vewDataEdit);
		vewDataEdit.setLayout(null);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setBounds(1289, 70, 279, 920);
		vewDataEdit.add(dataPanel);
		dataPanel.setBackground(new Color(30, 144, 255));
		dataPanel.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDni.setBounds(39, 50, 60, 20);
		dataPanel.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNombre.setBounds(39, 100, 84, 23);
		dataPanel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblApellidos.setBounds(39, 150, 84, 23);
		dataPanel.add(lblApellidos);
		
		JLabel lblFechaDeInscripcin = new JLabel("Fecha de inscripción");
		lblFechaDeInscripcin.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFechaDeInscripcin.setBounds(39, 200, 184, 23);
		dataPanel.add(lblFechaDeInscripcin);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblFechaDeNacimiento.setBounds(39, 250, 184, 23);
		dataPanel.add(lblFechaDeNacimiento);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField.setBounds(39, 75, 184, 20);
		dataPanel.add(textField);
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createEmptyBorder());
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(39, 125, 184, 20);
		textField_1.setBorder(BorderFactory.createEmptyBorder());
		
		dataPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(39, 175, 184, 20);
		textField_2.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(39, 225, 184, 20);
		textField_3.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(39, 275, 184, 20);
		textField_4.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(textField_4);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnGuardar.setBounds(39, 306, 184, 52);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setFocusPainted(true);
		dataPanel.add(btnGuardar);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		
		table.setModel(AdminController.tableModelBuilder());
		table.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		table.setBorder(BorderFactory.createEmptyBorder());
		table.setRowMargin(10);
		table.setRowHeight(25);
		table.setAlignmentX(Component.CENTER_ALIGNMENT);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		table.getTableHeader().setBackground(Color.DARK_GRAY);
		table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
		table.getTableHeader().setForeground(Color.WHITE);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i=0;i<table.getColumnCount();i++){
	         table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer);
	        }
		DefaultTableCellRenderer insideIconRenderer = new DefaultTableCellRenderer();
		ImageIcon icon = new ImageIcon("C:\\Users\\Neifi\\eclipse-workspace\\Gestiongym\\comprobar.png");
		for (int i = 0; i < table.getRowCount(); i++) {
			
		}
		insideIconRenderer.setIcon(icon);
		insideIconRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(5).setCellRenderer(insideIconRenderer);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(new Rectangle(83, 70, 1201, 920));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		vewDataEdit.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JPanel card = new JPanel();
		card.setBackground(Color.ORANGE);
		card.setBounds(245, 30, 1675, 1050);
		getContentPane().add(card);
		card.setLayout(new CardLayout());
		//panel.add("leftColumnMenu", leftColumnMenu);
		//panel.add("dataPanel", dataPanel);
		
		
	}
}
