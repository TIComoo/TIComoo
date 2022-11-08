<<<<<<< HEAD:app/src/main/java/g5/app/model/Restaurante.java
package g5.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
=======


package ticomo.app.model;



>>>>>>> main:server/src/main/java/ticomo/app/model/Restaurante.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Restaurante")
public class Restaurante {
<<<<<<< HEAD:app/src/main/java/g5/app/model/Restaurante.java

    @Id
    @NotBlank(message = "Campo requerido")
    String nombre;

    @NotBlank(message = "Campo requerido")
    String razon; 

    @NotBlank(message = "Campo requerido")
    String cif;

    @NotBlank(message = "Campo requerido")
    String direccion;

    @NotBlank(message = "Campo requerido")
    String tlf;

    @NotBlank(message = "Campo requerido")
    String categoria;
    
    @NotBlank(message = "Campo requerido")
    @Email
    String email;

    public Restaurante() {
    }


=======
    @Id
    String nombre;
    String razon;
    String cif;
    String direccion;
    String tlf;
    String categoria;
    String email;

>>>>>>> main:server/src/main/java/ticomo/app/model/Restaurante.java
    public Restaurante(String nombre, String razon, String cif, String direccion,String tlf, String categoria, String email) {
        this.nombre = nombre;
        this.razon = razon;
        this.cif = cif;
        this.direccion = direccion;
        this.tlf = tlf;
        this.categoria = categoria;
        this.email = email;
    }

<<<<<<< HEAD:app/src/main/java/g5/app/model/Restaurante.java
=======
    public Restaurante() {
    }


>>>>>>> main:server/src/main/java/ticomo/app/model/Restaurante.java
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }
<<<<<<< HEAD:app/src/main/java/g5/app/model/Restaurante.java
    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
=======
    public String getCIF() {
        return cif;
    }
    public void setCIF(String cif) {
>>>>>>> main:server/src/main/java/ticomo/app/model/Restaurante.java
        this.cif = cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTlf() {
        return tlf;
    }
    
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


@Override
public String toString() {
    return nombre + razon + cif + direccion + tlf + categoria + email;
}
    

<<<<<<< HEAD:app/src/main/java/g5/app/model/Restaurante.java
}
=======
}
>>>>>>> main:server/src/main/java/ticomo/app/model/Restaurante.java
