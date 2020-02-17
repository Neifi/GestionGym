package es.neifi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import es.neifi.model.PostgreSQLConnection;
import es.neifi.view.CheckListView;
import es.neifi.view.CrudClientView;

public class LoginController {

	public LoginController() {

	}

	public JPanel validateLogin(String username, String password) {
		ResultSet rs = readDataBase(username, password);
		CrudClientView crudClientView = new CrudClientView();
		CheckListView checkListView = new CheckListView();
		try {
			if (rs.getString("kind_of_user").equals("admin")) {
				return crudClientView;
			}
		} catch (SQLException e) {
			//TODO error in login
			e.printStackTrace();
		}
		return checkListView;
	}

	

	private ResultSet readDataBase(String username, String password) {
		String select = "SELECT user WHERE username = ? AND password = ?";

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

		}

		catch (Exception e) {
			// TODO invalid login msg
		}
		return rs;
	}

}
