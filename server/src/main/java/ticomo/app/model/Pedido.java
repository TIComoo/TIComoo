package ticomo.app.model;

import java.util.ArrayList;
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

    private ArrayList <Plato> platos = new ArrayList<Plato>() ;
    private double precio;
    private String fecha;
    private String estado;

    
    public Pedido(long id, ArrayList <Plato> platos, double precio, String fecha, String estado) {
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
    public ArrayList <Plato> getPlatos() {
        return platos;
    }
    public void setPlatos(ArrayList <Plato> platos) {
        this.platos = platos;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void sumarPrecios(){
        double suma=0;
        for(int i=0;i<this.platos.size();i++){
            suma+=this.platos.get(i).getPrecio();
        }
        this.setPrecio(suma);
    }


   
    
}
