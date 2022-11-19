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

    private String cartaElegida;

    public Carta( String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Carta( String nombreRestaurante, String cartaElegida) {
        this.nombreRestaurante = nombreRestaurante;
        this.cartaElegida = cartaElegida;

    }

    public Carta(){
        
    }

    public long getId() {
        return id;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getCartaElegida() {
        return cartaElegida;
    }

    public void setCartaElegida(String carta) {
        this.cartaElegida = carta;
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

    

    


    
}
