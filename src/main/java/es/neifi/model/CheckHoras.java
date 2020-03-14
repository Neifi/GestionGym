package es.neifi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckHoras {

	private int id;
	private String dniCliente;
	private int idGym;
	private int horas;
	private int dia;
	private int mes;
	private int anio;
	private String tipo_registro;

	public CheckHoras() {
		
	}

	public CheckHoras(String dniCliente, int idGym, int dia, int mes, int anio, String tipo_registro) {
		super();
		
		this.dniCliente = dniCliente;
		this.idGym = idGym;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.tipo_registro = tipo_registro;
	}
	
	
	//Salida
	public CheckHoras(String dniCliente, int idGym, int horas, int dia, int mes, int anio, String tipo_registro) {
		super();
		
		this.dniCliente = dniCliente;
		this.idGym = idGym;
		this.horas = horas;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.tipo_registro = tipo_registro;
	}
	
	
	
	public int getId() {
		return id;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public int getIdGym() {
		return idGym;
	}

	public int getHoras() {
		return horas;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}

	public String getTipo_registro() {
		return tipo_registro;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", dniCliente=" + dniCliente + ", idGym=" + idGym + ", horas=" + horas + "]";
	}
	
	
}
