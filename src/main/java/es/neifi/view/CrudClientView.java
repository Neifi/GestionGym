package es.neifi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import es.neifi.controller.AdminController;
import es.neifi.model.ClientesDao;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.UIManager;
import java.awt.CardLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CrudClientView extends JFrame {
	private JTable table;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField fechaIns;
	private JTextField fechaNa;
	private Vector<JTextField> textsFields;
	private JTextField textField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public CrudClientView() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ESCAPE) {
					setExtendedState(JFrame.MAXIMIZED_HORIZ);
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.ORANGE);
		setBackground(Color.BLACK);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);
		getContentPane().setLayout(null);
		// TODO get maxscreen size
		setBounds(0, 0, 1920, 1080);

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
		vewDataEdit.setBounds(245, 30, 1659, 1050);
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

		dni = new JTextField();

		dni.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		dni.setBounds(39, 75, 184, 20);
		dataPanel.add(dni);
		dni.setColumns(10);
		dni.setBorder(BorderFactory.createEmptyBorder());

		nombre = new JTextField();
		nombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nombre.setColumns(10);
		nombre.setBounds(39, 125, 184, 20);
		nombre.setBorder(BorderFactory.createEmptyBorder());

		dataPanel.add(nombre);

		apellidos = new JTextField();
		apellidos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		apellidos.setColumns(10);
		apellidos.setBounds(39, 175, 184, 20);
		apellidos.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(apellidos);

		fechaIns = new JTextField();
		fechaIns.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		fechaIns.setColumns(10);
		fechaIns.setBounds(39, 225, 184, 20);
		fechaIns.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(fechaIns);

		fechaNa = new JTextField();
		fechaNa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		fechaNa.setColumns(10);
		fechaNa.setBounds(39, 275, 184, 20);
		fechaNa.setBorder(BorderFactory.createEmptyBorder());
		dataPanel.add(fechaNa);

		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JTextField jTextField : textsFields) {
					jTextField.setEditable(false);
					// table.setModel(AdminController.findAllClientes());
				}
			}
		});
		btnGuardar_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnGuardar_1.setFocusPainted(true);
		btnGuardar_1.setBorderPainted(false);
		btnGuardar_1.setBounds(39, 361, 184, 52);
		dataPanel.add(btnGuardar_1);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
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
		table.setModel(AdminController.findAllClientes());

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		DefaultTableCellRenderer insideIconRenderer = new DefaultTableCellRenderer();
		ImageIcon icon = new ImageIcon("C:\\Users\\Neifi\\eclipse-workspace\\Gestiongym\\comprobar.png");
		for (int i = 0; i < table.getRowCount(); i++) {

		}
		insideIconRenderer.setIcon(icon);
		insideIconRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(5).setCellRenderer(insideIconRenderer);

		dni.setEditable(false);
		nombre.setEditable(false);
		apellidos.setEditable(false);
		fechaIns.setEditable(false);
		fechaNa.setEditable(false);
		textsFields = new Vector<JTextField>();
		textsFields.add(dni);
		textsFields.add(nombre);
		textsFields.add(apellidos);
		textsFields.add(fechaIns);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				dni.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				nombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				apellidos.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				fechaIns.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				fechaNa.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			}
		});

		for (final JTextField texts : textsFields) {
			texts.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!texts.getText().isBlank()) {

					}
					texts.setEditable(true);

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
					texts.setCursor(cursor);
					super.mouseEntered(e);
				}
			});
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(new Rectangle(85, 119, 1202, 871));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		vewDataEdit.add(scrollPane);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textField.setBounds(284, 70, 860, 38);
		vewDataEdit.add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setForeground(Color.ORANGE);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "DNI", "NOMBRE", "APELLIDOS", "FECHA INSCRIPCION", "FECHA NACIMIENTO", "DENTRO" }));
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(85, 70, 189, 38);
		vewDataEdit.add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isBlank() || textField.getText().isEmpty()) {
					String options[] = new String[] {"dni","nombre","apellidos","fecha_inscripcion","fecha_nacimiento","dentro"};
					
					int filterIndex = comboBox.getSelectedIndex();
					String condition = options[filterIndex];
					String value = textField.getText();
					table.setModel(AdminController.findClientesByCondition(condition,value));
				}else {
					table.setModel(AdminController.findAllClientes());
				}
			}
		});
		btnBuscar.setForeground(Color.ORANGE);
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setBounds(1147, 70, 132, 38);
		vewDataEdit.add(btnBuscar);

		JPanel card = new JPanel();
		card.setBackground(Color.ORANGE);
		card.setBounds(245, 30, 1675, 1050);
		getContentPane().add(card);
		card.setLayout(new CardLayout());
		// panel.add("leftColumnMenu", leftColumnMenu);
		// panel.add("dataPanel", dataPanel);

	}
}
