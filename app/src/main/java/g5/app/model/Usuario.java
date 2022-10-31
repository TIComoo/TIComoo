package g5.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {

	@Id
	protected String email;
	protected String nombre;
	protected String apellido;
	protected String pwd;
	protected String confirmarPwd;
	private String rol;

	// sin rol
	public Usuario(String email, String nombre, String apellido, String pwd, String confirmarPwd) {
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pwd = pwd;
		this.confirmarPwd= confirmarPwd;
	}

	// Vacio
	public Usuario() {
		
	}

	// Con rol
	public Usuario(String email, String nombre, String apellido, String pwd, String confirmarPwd, String rol) {
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pwd = pwd;
		this.rol = rol;
		this.confirmarPwd= confirmarPwd;

	}

	// Constructor con email y pwd
	public Usuario(String email, String pwd, String confirmarPwd) {
		this.email = email;
		this.pwd = pwd;
		this.confirmarPwd= confirmarPwd;

	}

	
	public String getConfirmarPwd() {
		return confirmarPwd;
	}

	public void setConfirmarPwd(String confirmarPwd) {
		this.confirmarPwd = confirmarPwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;

	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", pwd=" + pwd + "]";
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}