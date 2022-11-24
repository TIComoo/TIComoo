package ticomo.app.model;


import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Carta")
public class Carta {

    @Transient
    public static final String SEQUENCE_NAME = "carta_sequence";

    @Id
    private long id;

    @NotBlank(message = ("Nombre restaurante requerido"))
    private String nombreRestaurante;

    private boolean cartaElegida;


    public Carta( String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }
    public Carta(){
        
    }
    public Carta( String nombreRestaurante, boolean cartaElegida) {
        this.nombreRestaurante = nombreRestaurante;
        this.cartaElegida = cartaElegida;

    }

    public long getId() {
        return id;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    

    @Override
    public String toString() {
        return "Carta [id=" + id + ", nombreRestaurante=" + nombreRestaurante  + "]";
    }
    public static String getSequenceName() {
        return SEQUENCE_NAME;
    }
    public boolean getCartaElegida() {
        return cartaElegida;
    }
    public void setCartaElegida(boolean cartaElegida) {
        this.cartaElegida = cartaElegida;
    }

    

    


    
}
