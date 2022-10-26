package g5.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administrador")
public class Administrador extends Usuario {

    @Id
    private String email;
    private String zona;
    private String rol;

    public Administrador(String nombre, String apellido, String email, String pwd, String zona) {
        super(email, nombre, apellido, pwd);
        this.email = email;
        this.zona = zona;
        this.rol = "ADMINISTRADOR";
    }

    public Administrador() {
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getRol() {
        return rol;
    }

}
