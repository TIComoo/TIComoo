package g5.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Plato")
public class Plato {

    @Id
    private int id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private double precio;
    private boolean aptoVeganos;
    private String categoria;

    public Plato(int id,String nombre,String categoria, String imagen, String descripcion, double precio, boolean aptoVeganos) {
        this.categoria=categoria;
        this.id=id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aptoVeganos = aptoVeganos;
    }

    public Plato(){
            
    }

    public int getId() {
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

    public void setId(int id) {
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
