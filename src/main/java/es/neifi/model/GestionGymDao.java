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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class GestionGymDao {
	
	private static ResultSet selectRegistroByFecha(int[] day, int[] month ,int[] year, String dni) {
		String select = "SELECT dia,mes,anio,horas from check_horas where day between ? AND ? AND month BETWEEN ? AND ?"
				+ "AND anio BETWEEN ? AND ? AND dni_cliente = ?";
		
		
		
		int firstDay = day[0];
		int secondDay = day[1];
		int firstMonth = month[0];
		int secondMonth = month[1];
		int firstYear = year[0];
		int secondYear = year[1];
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			
			stmt.setInt(1, firstDay);
			stmt.setInt(2, secondDay);
			stmt.setInt(3, firstMonth);
			stmt.setInt(4, secondMonth);
			stmt.setInt(5, firstYear);
			stmt.setInt(6, secondYear);
			stmt.setString(7, dni);
			
			rs = stmt.executeQuery();
			
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	
	}
	

	
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
	 * 
	 * @param condition
	 * @param value
	 * @return El ResultSet de la consulta.
	 */
	private static ResultSet selectByCondition(String condition, String value) {
		String select = "SELECT dni,nombre,apellidos,fecha_nacimiento,fecha_inscripcion,dentro,pagado FROM clientes"
				+ " WHERE " + condition + "= ?";

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
	 * 
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

	protected static DefaultTableModel findByCondition(String condition, String value) {
		try {
			ResultSet rs = selectByCondition(condition, value);
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

			return stmt.executeUpdate() > 0 ? true : false;

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

			return stmt.executeUpdate() > 0 ? true : false;

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	protected static boolean createCliente(Cliente cliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String insert = "INSERT INTO clientes "
				+ "(dni,password,nombre,apellidos,fecha_nacimiento,pagado,dentro,fecha_inscripcion,es_admin)" + "VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			String encryptPassword = "crypt('" + cliente.getNombre() + "',gen_salt('bf'))";

			stmt.setString(1, cliente.getDni());
			stmt.setString(2, encryptPassword);
			stmt.setString(3, cliente.getNombre());
			stmt.setString(4, cliente.getApellidos());
			stmt.setString(5, cliente.getFechaNacimiento());
			stmt.setString(6, "t");// pagado
			stmt.setString(7, "f");// dentro
			stmt.setString(8, cliente.getFechaInscripcion());
			stmt.setString(9, cliente.getEs_admin());// admin

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void registrarEntrada(Cliente cliente) {
		Connection conn;
		PreparedStatement stmt = null;
		String insert = "INSERT INTO check_horas " + "(dni_cliente,id_gym,dia,mes,anio,tipo_registro)"
				+ "VALUES (?,?,?,?,?,?)";

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);

			String fechaEntrada[] = cliente.getEntryDate();

			// TODO mover al controller*******
			cliente.startEntryTimer();
			cliente.setTipoRegistro("E");
			// *******************************

			stmt.setString(1, cliente.getDni());
			stmt.setInt(2, cliente.getIdGym());
			stmt.setString(3, fechaEntrada[0]);
			stmt.setString(4, fechaEntrada[1]);
			stmt.setString(5, fechaEntrada[2]);
			stmt.setString(6, cliente.getTipoRegistro());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void registrarSalida(Cliente cliente) {

		Connection conn;
		PreparedStatement stmt = null;
		String insert = "INSERT INTO check_horas " + "(dni_cliente,id_gym,dia,mes,anio,tipo_registro)"
				+ "VALUES (?,?,?,?,?,?)";

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);

			// TODO mover al controller
			int hours = cliente.stopEntryTimer();
			cliente.setTipoRegistro("S");
			String fechaEntrada[] = cliente.getEntryDate();

			stmt.setString(1, cliente.getDni());
			stmt.setInt(2, cliente.getIdGym());
			stmt.setString(3, fechaEntrada[0]);
			stmt.setString(4, fechaEntrada[1]);
			stmt.setString(5, fechaEntrada[2]);
			stmt.setString(6, cliente.getTipoRegistro());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	protected static DefaultTableModel findRegistroByDate(int[] day, int[] month ,int[] year, String dni) {
		try {
			ResultSet rs = selectRegistroByFecha(day, month, year, dni);
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
