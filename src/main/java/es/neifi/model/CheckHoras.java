package es.neifi.model;

public class CheckHoras {
	
	private int id;
	private String dniCliente;
	private int idGym;
	private int horas;
	
	public CheckHoras() {
		
	}

	public CheckHoras(int id, String dniCliente, int idGym, int horas) {
		super();
		this.id = id;
		this.dniCliente = dniCliente;
		this.idGym = idGym;
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", dniCliente=" + dniCliente + ", idGym=" + idGym + ", horas=" + horas + "]";
	}
	
	
}
