package g5.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cliente")
public class Cliente extends Usuario {
    @Id
    private String email;

    private String nif;
    private String direccion;
    private String telefono;
    private String rol;

    public Cliente(String email, String nombre, String apellido, String pwd, String nif, String direccion,
            String telefono) {
        super(email, nombre, apellido, pwd);
        this.email = email;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = "Cliente";
    }
    public Cliente(){
        
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
