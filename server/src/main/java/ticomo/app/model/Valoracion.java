package ticomo.app.model;

public class Valoracion {

    private String ide;
    private String nombreUsuario;
    private int puntuacion;
    private String descripcion;
    public Valoracion(String ide, String nombreUsuario, int puntuacion, String descripcion) {
        this.ide = ide;
        this.nombreUsuario = nombreUsuario;
        this.puntuacion = puntuacion;
        this.descripcion = descripcion;
    }
    public String getIde() {
        return ide;
    }
    public void setIde(String ide) {
        this.ide = ide;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String stringValoraciones() {
        return "Puntuacion:"  + puntuacion  +".\n "+ nombreUsuario + " dijo " + descripcion + ". ";
    }
}
