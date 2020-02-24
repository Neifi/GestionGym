package es.neifi.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
	
	private static ResultSet selectByDni(String dni) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE dni = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, dni);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}
	
	private static ResultSet selectByNombre(String nombre) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE nombre = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, nombre);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}
	
	private static ResultSet selectByApellidos(String apellidos) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE apellidos = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, apellidos);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}
	
	private static ResultSet selectByFechaNa(String fechaNa) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE fecha_nacimiento = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, fechaNa);

			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}
	
	private static ResultSet selectByFechaIns(String fechaIns) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE fecha_inscripcion = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, fechaIns);

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultTableModel();
		
	}
	
	protected static DefaultTableModel findByDni(String dni) {
		try {
			ResultSet rs = selectByDni(dni);
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
	
	protected static DefaultTableModel findByNombre(String nombre) {
		try {
			ResultSet rs = selectByNombre(nombre);
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
	
	protected static DefaultTableModel findByApellidos(String apellidos) {
		try {
			ResultSet rs = selectByApellidos(apellidos);
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
	
	protected static DefaultTableModel findByFechaNa(String fechana) {
		try {
			ResultSet rs = selectByFechaNa(fechana);
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
	
	protected static DefaultTableModel findByFechaIns(String fechaIns) {
		try {
			ResultSet rs = selectByFechaIns(fechaIns);
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
	
	protected static boolean createCliente(Cliente cliente) {
		
		String create = "INSERT INTO clientes ";
		
		return false;
	}
}
