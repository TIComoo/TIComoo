package g5.app.model;


import java.util.HashSet;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Usuario")
public class Usuario {
	
	@Id
	private String email;

	
	private String nombre;
	private String apellidos;
	private String nif;
	private String direccion;
	private String telefono;
	private String pwd;
	@Transient
	private String confirmarPwd;

	
	
	private HashSet <Roles> roles = new HashSet<Roles>();
	
	public Usuario() {}

	public Usuario( String nombre, String apellidos, String nif, String direccion, String telefono, String email,
			String pwd,String confirmarPwd) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.pwd = pwd;
		this.confirmarPwd = confirmarPwd;

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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public HashSet<Roles> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<Roles> rol) {
		this.roles = rol;
	}

	public String getConfirmarPwd() {
		return confirmarPwd;
	}

	public void setConfirmarPwd(String confirmarPwd) {
		this.confirmarPwd = confirmarPwd;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", pwd=" + pwd + ", confirmarPwd="
				+ confirmarPwd + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, confirmarPwd, direccion, email, nif, nombre, pwd, roles, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(confirmarPwd, other.confirmarPwd)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pwd, other.pwd) && Objects.equals(roles, other.roles)
				&& Objects.equals(telefono, other.telefono);
	}

	
	
}