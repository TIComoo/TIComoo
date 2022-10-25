package g5.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Carta")
public class Carta {

    @Id
    private int id;
    private String nombreRestaurante;
    private List<Plato>listaPlatos=new ArrayList<>();

    public Carta(int id, String nombreRestaurante, List<Plato> listaPlatos) {
        this.id = id;
        this.nombreRestaurante = nombreRestaurante;
        this.listaPlatos = listaPlatos;
    }

    public int getId() {
        return id;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setId(int id) {
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

