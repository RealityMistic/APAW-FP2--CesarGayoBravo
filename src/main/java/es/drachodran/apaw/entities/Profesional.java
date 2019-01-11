package es.drachodran.apaw.entities;

public class Profesional {
    int id;
    String nombre;
    String pseudonimo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
