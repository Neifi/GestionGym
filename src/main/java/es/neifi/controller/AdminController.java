package es.neifi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import es.neifi.model.Cliente;
import es.neifi.model.GestionGymDao;

public class AdminController extends GestionGymDao {

	public static DefaultTableModel findAllClientes() {

		return GestionGymDao.findAllClientes();

	}

	public static DefaultTableModel findClientesByCondition(String condition, String value) {
		return GestionGymDao.findByCondition(condition, value);

	}

	public static boolean createCliente(String dni, String password, String nombre, String apellidos,
			String fechaNacimiento) {
		Cliente cliente = new Cliente(dni,password,nombre,apellidos);
		String fechaInscripcion = setFechaInscipcion(cliente);
		String fechaNa = " ";
		cliente.setFechaInscripcion(fechaInscripcion);
		if(checkFormatoFecha(fechaNacimiento)) {
			fechaNa = fechaNacimiento;
			cliente.setFechaNacimiento(fechaNa);
			cliente.setEs_admin("f");
			GestionGymDao.createCliente(cliente);
			return true;
		}else {
			throw new RuntimeException("Formato de fecha incorrecta");
		}
		
	}

	public static boolean createAdmin(String dni, String password, String nombre, String apellidos,
			String fechaNacimiento) {
		Cliente cliente = new Cliente(dni,password,nombre,apellidos);
		String fechaInscripcion = setFechaInscipcion(cliente);
		String fechaNa = " ";
		cliente.setFechaInscripcion(fechaInscripcion);
		if(checkFormatoFecha(fechaNacimiento)) {
			fechaNa = fechaNacimiento;
			cliente.setFechaNacimiento(fechaNa);
			cliente.setEs_admin("t");
			GestionGymDao.createCliente(cliente);
			return true;
		}else {
			throw new RuntimeException("Formato de fecha incorrecta");
		}
		
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
