package es.neifi.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cliente {

	private int id;
	private String dni;
	private String password;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String fechaInscripcion;
	private boolean isDentro;
	private boolean isPagado;
	private char es_admin;
	private int idGym;

	public Cliente() {

	}

	public Cliente(int id) {
		super();
		this.id = id;
	}

	public Cliente(String dni) {
		super();
		this.dni = dni;
	}
	
	public Cliente(String dni,String password,String nombre,String apellidos,String fechaNacimiento) {
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Cliente(int id, String dni, String password, String nombre, String apellidos, String fechaNacimiento,
			String fechaInscripcion, boolean isDentro, boolean isPagado, int idGym) {
		super();
		this.id = id;
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
		this.isDentro = isDentro;
		this.isPagado = isPagado;
		this.idGym = idGym;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public boolean isDentro() {
		return isDentro;
	}

	public void setDentro(boolean isDentro) {
		this.isDentro = isDentro;
	}

	public boolean isPagado() {
		return isPagado;
	}

	public void setPagado(boolean isPagado) {
		this.isPagado = isPagado;
	}

	public int getIdGym() {
		return idGym;
	}

	public void setIdGym(int idGym) {
		this.idGym = idGym;
	}

	public String setCurrentDate() {
		DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateformat.format(cal);
		return currentDate;
		
	}
	
	public int startEntryTimer() {
		
		return 0;
	}
	
	public void stopEntryTimer() {
		
	}
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", dni=" + dni + ", password=" + password + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", fechaNacimiento=" + fechaNacimiento + ", fechaInscripcion=" + fechaInscripcion
				+ ", isDentro=" + isDentro + ", isPagado=" + isPagado + ", idGym=" + idGym + "]";
	}
	
	

}
