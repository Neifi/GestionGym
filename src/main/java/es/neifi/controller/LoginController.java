package es.neifi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import es.neifi.Gestiongym.MainForm;
import es.neifi.model.PostgreSQLConnection;
import es.neifi.view.CheckListView;
import es.neifi.view.CrudClientView;

public class LoginController {
	private MainForm mainForm;

	public enum User {
		ADMIN, CLIENT, NOPE
	}

	public LoginController() {

	}

	/**
	 * Comprueba las credenciales introducidas por el usuario en la base de datos.
	 * Las consultas se hacen en las tablas clientes , para comprobar que el
	 * usuario es admin o un simple cliente. Dependiendo del usuario
	 * retorna un valor definido en el enum.
	 *
	 * @param username
	 * @param password
	 * @return CLIENT si es un cliente ADMIN si es un gimnasio NOPE si no existen
	 *         las credenciales.
	 */
	public User validateLogin(String username, String password) {
		ResultSet rs = readClientes(username, password);

		try {
			if (rs.next()) {

				if (rs.getBoolean("es_admin")) {
					rs.close();
					return User.ADMIN;
				} else {
					rs.close();
					return User.CLIENT;
				}
			}
		} catch (Exception e) {
			// TODO error in login
			e.printStackTrace();
		}
		return User.NOPE;

	}

	private ResultSet readClientes(String username, String password) {
		String select = "SELECT * FROM clientes WHERE nombre = ? AND password = crypt(?,password)";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {
			e.printStackTrace();
		}finally {
			PostgreSQLConnection.closeConnection(conn);
		}
		return rs;
	}

	private ResultSet readGyms(String username, String password) {
		// TODO encrypt gyms password
		String select = "SELECT * FROM gyms WHERE username = ? AND password = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(select, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			return rs;
		}

		catch (Exception e) {

		}
		return rs;
	}

}
