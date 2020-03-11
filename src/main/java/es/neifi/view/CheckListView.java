package es.neifi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CheckListView extends JFrame {

	/**
	 * Create the panel.
	 */
	public CheckListView() {
		setBackground(Color.ORANGE);
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 150, 705, 337);
		getContentPane().add(scrollPane);
		
		JLabel lblHistorial = new JLabel("Historial");
		lblHistorial.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHistorial.setBounds(297, 123, 123, 15);
		getContentPane().add(lblHistorial);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(600, 12, 117, 25);
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.setForeground(Color.ORANGE);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setFocusPainted(true);
		getContentPane().add(btnEntrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(600, 49, 117, 25);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setForeground(Color.ORANGE);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusPainted(true);
		getContentPane().add(btnSalir);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setBounds(56, 51, 32, 24);
		comboDia.setBackground(Color.DARK_GRAY);
		comboDia.setForeground(Color.ORANGE);
		getContentPane().add(comboDia);
		
		
		JComboBox comboMes = new JComboBox();
		comboMes.setBounds(100, 51, 32, 24);
		comboMes.setBackground(Color.DARK_GRAY);
		comboMes.setForeground(Color.ORANGE);
		getContentPane().add(comboMes);
		
		JComboBox comboAnio = new JComboBox();
		comboAnio.setBounds(144, 51, 32, 24);
		comboAnio.setBackground(Color.DARK_GRAY);
		comboAnio.setForeground(Color.ORANGE);
		getContentPane().add(comboAnio);
		
		JComboBox comboDiaFin = new JComboBox();
		comboDiaFin.setBounds(56, 87, 32, 24);
		comboDiaFin.setBackground(Color.DARK_GRAY);
		comboDiaFin.setForeground(Color.ORANGE);
		getContentPane().add(comboDiaFin);
		
		JComboBox comboMesFin = new JComboBox();
		comboMesFin.setBounds(100, 87, 32, 24);
		comboMesFin.setBackground(Color.DARK_GRAY);
		comboMesFin.setForeground(Color.ORANGE);
		getContentPane().add(comboMesFin);
		
		JComboBox comboAnioFin = new JComboBox();
		comboAnioFin.setBounds(144, 87, 32, 24);
		comboAnioFin.setBackground(Color.DARK_GRAY);
		comboAnioFin.setForeground(Color.ORANGE);
		getContentPane().add(comboAnioFin);
		
		JLabel lblSeleccionarFecha = new JLabel("Seleccionar fecha");
		lblSeleccionarFecha.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSeleccionarFecha.setBounds(22, 16, 179, 15);
		getContentPane().add(lblSeleccionarFecha);
		

	}
}
