package es.neifi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

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
		

	}
}
