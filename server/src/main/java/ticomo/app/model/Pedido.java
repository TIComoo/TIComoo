package ticomo.app.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Pedido")
public class Pedido {
    
    @Transient
    public static final String SEQUENCE_NAME = "pedidos_sequence";
    
    @Id
    private long id;

    private Plato [] platos ;
    private double precio;
    private Date fecha;
    private String estado;

    
    public Pedido(long id, Plato[] platos, double precio, Date fecha, String estado) {
        this.id = id;
        this.platos = platos;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Pedido(){}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Plato[] getPlatos() {
        return platos;
    }
    public void setPlatos(Plato[] platos) {
        this.platos = platos;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", platos=" + Arrays.toString(platos) + ", precio=" + precio + ", fecha=" + fecha
                + ", estado=" + estado + "]";
    }

    
}
