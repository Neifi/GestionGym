package es.neifi.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import es.neifi.Gestiongym.MainForm;
import es.neifi.model.CheckHoras;
import es.neifi.model.Cliente;
import es.neifi.model.PostgresLocalDao;
import es.neifi.model.PostgreSQLConnection;
import es.neifi.view.CheckListView;
import es.neifi.view.CrudClientView;

public class LoginController {
	private static String logedClientDni;
	private static int logedClientGymId;
	private static String startTime;
	private static String endTime;
	
	private static DateFormat tiempo;
	private static DateFormat fechaDia;
	private static DateFormat fechaMes;
	private static DateFormat fechaAnio;
	private static Date date;
	
	private static int dia;
	private static int mes;
	private static int anio;
	private static int horas;
	
	private static final String ENTRADA = "E";
	private static final String SALIDA = "S";
	
	public enum User {
		ADMIN, CLIENT, NOPE
	}

	public LoginController() {
		tiempo = new SimpleDateFormat("HH");
		fechaDia = new SimpleDateFormat("dd");
		fechaMes = new SimpleDateFormat("MM");
		fechaAnio = new SimpleDateFormat("yyyy");
	}

	/**
	 * Comprueba las credenciales introducidas por el usuario en la base de datos.
	 * Las consultas se hacen en las tablas clientes , para comprobar que el usuario
	 * es admin o un simple cliente. Dependiendo del usuario retorna un valor
	 * definido en el enum.
	 *
	 * @param username
	 * @param password
	 * @return CLIENT si es un cliente ADMIN si es un gimnasio NOPE si no existen
	 *         las credenciales.
	 */
	public User validateLogin(String username, String password) {
		ResultSet rs = PostgresLocalDao.readClientesLogin(username, password);

		try {
			if (rs.next()) {
				logedClientDni = rs.getString(3);
				logedClientGymId = rs .getInt(2);
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

	public static void entrar() {
		date = new Date();
		startTime = tiempo.format(date);
		dia = Integer.parseInt(fechaDia.format(date));
		mes = Integer.parseInt(fechaMes.format(date));
		anio = Integer.parseInt(fechaAnio.format(date));
		
		PostgresLocalDao.registrarEntrada(new CheckHoras(logedClientDni,logedClientGymId,dia,mes,anio,ENTRADA));
	}

	public static void salir() {
		date = new Date();
		endTime = tiempo.format(date);
		dia = Integer.parseInt(fechaDia.format(date));
		mes = Integer.parseInt(fechaMes.format(date));
		anio = Integer.parseInt(fechaAnio.format(date));
		horas = calcularHoras();
		
		PostgresLocalDao.registrarSalida(new CheckHoras(logedClientDni,logedClientGymId,horas,dia,mes,anio,SALIDA));
	}
	
	public static void selectAllRegistros() {
		
	}

	public static void selectRegistroByDate() {

	}
	
	private static int calcularHoras() {
		int diferencia = Integer.parseInt(endTime) - Integer.parseInt(startTime);
		return diferencia;
	}
}
