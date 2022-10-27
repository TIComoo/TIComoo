package g5.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrador")
public class Administrador extends Usuario {

	private String zona;

	public Administrador(String email, String nombre, String apellido, String pwd, String zona) {
		super(email, nombre, apellido, pwd);
		this.zona = zona;
	}

	// Constructor temporar para probar la aplicación

	public Administrador(String email, String pwd) {
		super(email, pwd);
	}

	public Administrador() {
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
