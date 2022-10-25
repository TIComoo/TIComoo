package g5.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Usuario")
public class Usuario {
    @Id
    private String email;
    private String nombre;
    private String apellido;
    private String nif;
    private String direccion;
    private int telefono;
    private String pwd;
    

    public Usuario(String nombre, String apellido, String nif, String direccion, int telefono,
            String email, String pwd) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pwd = pwd;
        

    }

    public Usuario(String nombre, String apellido, String nif, String email, String pwd) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.email = email;
        this.pwd = pwd;
    }


    /*
     * public Usuario() {
     * }
     */

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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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


}
