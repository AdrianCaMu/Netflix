package models;

public class User {
	//Propiedades
	protected String correo;
	protected String passwd;
	
	//Builders
	
	/**
	 * Constructor del usuario
	 * @param username Nombre del usuario
	 * @param passwd Contraseņa del usuario
	 */
	public User(String username, String passwd) {
		super();
		this.correo = username;
		this.passwd = passwd;
	}
	
	//Getters y Setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}