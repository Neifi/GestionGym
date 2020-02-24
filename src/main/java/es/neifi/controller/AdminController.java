package es.neifi.controller;

import javax.swing.table.DefaultTableModel;
import es.neifi.model.ClientesDao;

public class AdminController extends ClientesDao{

	public static DefaultTableModel findAllClientes() {
		
		return ClientesDao.findAllClientes();
		
	}
	
	public static DefaultTableModel findClientesById(String dni) {
		return ClientesDao.findByDni(dni);
		
	}
	
	public static DefaultTableModel findClientesByNombre(String nombre) {
		return ClientesDao.findByNombre(nombre);
		
	}
	
	public static DefaultTableModel findClientesByApellidos(String apellidos) {
		return ClientesDao.findByApellidos(apellidos);
		
	}
	
	public static DefaultTableModel findClientesByFechaIns(String fechaIns) {
		return ClientesDao.findByFechaIns(fechaIns);
		
	}
	
	public static DefaultTableModel findClientesByfFechaNa(String fechaNa) {
		return ClientesDao.findByFechaNa(fechaNa);
		
	}
	
	public static DefaultTableModel findClientesByIsDentro(String dentro) {
		return null;
		
	}
	

}
