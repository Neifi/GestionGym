package es.neifi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import es.neifi.model.PostgreSQLConnection;

public class AdminController {

	private static ResultSet findAllClientes() {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes;";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}
	

	public static DefaultTableModel tableModelBuilder() {
		try {
			ResultSet rs = findAllClientes();
			ResultSetMetaData metaData = rs.getMetaData();

			Vector<String> colNames = new Vector<String>(7, 1);
			int columnCount = metaData.getColumnCount();

			for (int i = 1; i < columnCount; i++) {
				colNames.add(metaData.getColumnName(i));
			}

			Vector<Vector<Object>> data = new Vector<Vector<Object>>(1, 2);
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>(20, 5);
				for (int i = 1; i <= columnCount; i++) {
					vector.add(rs.getObject(i));
				}
				data.add(vector);
			}
			return new DefaultTableModel(data, colNames);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultTableModel();
		
	}

}
