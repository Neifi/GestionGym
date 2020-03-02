package es.neifi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import es.neifi.model.Cliente;
import es.neifi.model.ClientesDao;

public class AdminController extends ClientesDao {

	public static DefaultTableModel findAllClientes() {

		return ClientesDao.findAllClientes();

	}

	public static DefaultTableModel findClientesByCondition(String condition, String value) {
		return ClientesDao.findByCondition(condition, value);

	}

	public static boolean createCliente(String dni, String password, String nombre, String apellidos,
			String fechaNacimiento) {
		
		Cliente cliente = new Cliente(dni,password,nombre,apellidos,fechaNacimiento);
		
		return false;
	}

	public static boolean createAdmin(String dni, String password, String nombre, String apellidos,
			char fechaNacimiento) {

		return false;
	}

	private static String setFechaInscipcion(Cliente cliente) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormat.format(new Date());
		return dateString;
	}

	private static boolean checkFormatoFecha(String fecha) {
		if (fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
			return true;
		}
		return false;
	}

}
