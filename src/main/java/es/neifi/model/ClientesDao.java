package es.neifi.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ClientesDao {

	
	
	private static ResultSet select() {
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
	
	/**
	 * Busca un cliente por alguna condicion pasada por parametro;
	 * @param condition
	 * @param value
	 * @return El ResultSet de la consulta.
	 */
	private static ResultSet selectByCondition(String condition, String value) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE " +condition+ "= ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			
			stmt.setString(1, value);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}

	
	
	/**
	 * Construye un modelo para la JTable a partir del resultset del select
	 * @return El table model generado
	 */
	protected static DefaultTableModel findAllClientes() {
		try {
			ResultSet rs = select();
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
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultTableModel();
		
	}
	
	
	protected static DefaultTableModel findByCondition(String condition,String value) {
		try {
			ResultSet rs = selectByCondition(condition,value);
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
	
	
	
	protected static boolean deleteCliente(String dni) {
		String delete = "DELETE FROM clientes WHERE dni = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(delete, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, dni);

			return stmt.executeUpdate() >0 ? true:false;
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	protected static boolean updateCliente(Cliente cliente) {
		
		String dni = cliente.getDni();
		String nombre = cliente.getNombre();
		String apellidos = cliente.getApellidos();
		String fechaNacimiento = cliente.getFechaNacimiento();
		
		String update = "UPDATE clientes SET dni = ?, nombre = ?, apellidos = ?, fecha_nacimiento = ? WHERE dni = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(update, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			
			stmt.setString(1, dni);
			stmt.setString(2, nombre);
			stmt.setString(3, apellidos);
			stmt.setString(4, fechaNacimiento);
			stmt.setString(5, dni);
			
			return stmt.executeUpdate() >0 ? true:false;
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	

	protected static boolean createCliente(Cliente persona) {
		
		String create = "INSERT INTO clientes ";
		
		return false;
	}
}
