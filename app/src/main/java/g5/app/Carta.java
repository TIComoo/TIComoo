package g5.app;

import java.util.ArrayList;
import java.util.List;

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

    private List<Plato>listaPlatos;

    public Carta( String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
        this.listaPlatos =new ArrayList<>();
    }
    public Carta(){
        
    }

    public long getId() {
        return id;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    @Override
    public String toString() {
        return "Carta [id=" + id + ", nombreRestaurante=" + nombreRestaurante + ", listaPlatos=" + listaPlatos + "]";
    }

    

    


    
}

