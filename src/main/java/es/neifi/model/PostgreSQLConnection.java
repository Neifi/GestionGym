package es.neifi.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgreSQLConnection {
	
	private final static String URL ="jdbc:postgresql://localhost:5433/?";
	private final static String USER ="postgres";
	private final static String PASSWORD ="admin";
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Exito al conectar");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se pudo conectar");
			e.printStackTrace();
		}
		return connection;
		
	}
	
	/**
	 * Cierra una conexión especifica
	 * @param conn conexion a cerrar
	 */
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Conexion cerrada correctamente");
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar la conexión");
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Conexion cerrada correctamente");
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar la conexión");
			e.printStackTrace();
		}
	}
	

	public static void closeStmt(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
