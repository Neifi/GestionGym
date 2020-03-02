package es.neifi.controller;

import es.neifi.model.ClientesDao;

public class ClientController {
	
	public static void entrar() {
		ClientesDao.registrarEntrada(cliente);
	}
	
	public static void salir() {
		ClientesDao.registrarSalida(cliente);
	}
	
}
