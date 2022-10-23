package g5.app;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrador")
public class Administrador extends Usuario{
    /*
     * Administrador: encargado de fijar los restaurantes, platos de cada uno de ellos, 
gestionar usuarios y riders, etc.

Debe permitir a los administradores gestionar la lista de restaurantes y la carta de cada 
uno de ellos, así como consultar los pedidos realizados y la facturación por restaurante, 
día y mes. También se podrá acceder a las valoraciones de restaurantes y riders

 Los administradores deben tener nombre, apellidos, zona 
 (String, ejemplo: ciudad real norte, almagro...), email (userlogin) y password.
     */

     //Esta clase hereda de la clase Usuario

     private String zona;

    public Administrador(String nombre, String apellido, String nif,  String email,String pwd, String zona ) {
        super(nombre, apellido, nif, email, pwd);
        this.zona =zona;
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
