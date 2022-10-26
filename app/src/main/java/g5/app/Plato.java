package g5.app;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Plato")
public class Plato {

    @Transient
    public static final String SEQUENCE_NAME = "platos_sequence";

    @Id
    private long id;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z]", message = "Este campo no debe contener valores numéricos")
    private String nombre;

    @NotBlank(message = "Campo requerido")
    private String imagen;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z]", message = "Este campo no debe contener valores numéricos")
    private String descripcion;

    @NotBlank(message = "Campo requerido")
    @Digits(integer = 4,fraction = 2,message = "Este campo debe de ser un numero")
    private double precio;

    @NotNull
    private boolean aptoVeganos;

    @NotBlank(message = "Campo requerido")
    @Pattern(regexp = "[a-zA-Z]", message = "Este campo no debe contener valores numéricos")
    private String categoria;

    public Plato(String nombre,String categoria, String imagen, String descripcion, double precio, boolean aptoVeganos) {
        this.categoria=categoria;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aptoVeganos = aptoVeganos;
    }

    public Plato(){
            
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean getAptoVeganos() {
        return aptoVeganos;
    }

    public void setId(long id) {
       this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAptoVeganos(boolean aptoVeganos) {
        this.aptoVeganos = aptoVeganos;
    }

    @Override
    public String toString() {
        return "Plato [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
                + ", precio=" + precio + ", aptoVeganos=" + aptoVeganos + ", categoria=" + categoria + "]";
    }

   

    

   
}
