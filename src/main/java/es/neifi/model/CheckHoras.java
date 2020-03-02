package es.neifi.model;

public class CheckHoras {

	private int id;
	private String dniCliente;
	private int idGym;
	private int horas;
	private int dia;
	private int mes;
	private int anio;
	private char tipo_registro;

	public CheckHoras() {

	}

	public CheckHoras(int id, String dniCliente, int idGym, int horas, int dia, int mes, int anio, char tipo_registro) {
		super();
		this.id = id;
		this.dniCliente = dniCliente;
		this.idGym = idGym;
		this.horas = horas;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.tipo_registro = tipo_registro;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", dniCliente=" + dniCliente + ", idGym=" + idGym + ", horas=" + horas + "]";
	}

}
