package es.neifi.controller;

import es.neifi.model.Cliente;
import es.neifi.model.GestionGymDao;

public class ClientController {
	
	public static void entrar() {
		GestionGymDao.registrarEntrada(new Cliente());
	}
	
	public static void salir() {
		GestionGymDao.registrarSalida(new Cliente());
	}
	
	public static void selectAllRegistros() {
		
	}
	
	public static void selectRegistroByDate() {
		
	}
	
}
