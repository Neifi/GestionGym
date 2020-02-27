package es.neifi.controller;

import javax.swing.table.DefaultTableModel;

import es.neifi.model.Cliente;
import es.neifi.model.ClientesDao;

public class AdminController extends ClientesDao{

	public static DefaultTableModel findAllClientes() {
		
		return ClientesDao.findAllClientes();
		
	}
	
	public static DefaultTableModel findClientesByCondition(String condition, String value) {
		return ClientesDao.findByCondition(condition, value);
		
	}
	
	public static boolean createCliente(Cliente cliente) {
		
		return false;
	}
	

}
