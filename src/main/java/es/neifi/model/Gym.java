package es.neifi.model;

public class Gym {

	private int id;
	private String username;
	private String password;
	private String nombre;
	private String direccion;
	private String pais;
	private String ciudad;
	private int codigoPostal;

	public Gym() {

	}

	public Gym(int id) {
		this.id = id;
	}

	public Gym(int id, String username, String password, String nombre, String direccion, String pais, String ciudad,
			int codigoPostal) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", direccion="
				+ direccion + ", pais=" + pais + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + "]";
	}
	
	
}
