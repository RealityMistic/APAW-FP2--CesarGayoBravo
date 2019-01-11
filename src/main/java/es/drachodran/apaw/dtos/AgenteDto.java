package es.drachodran.apaw.dtos;

public class AgenteDto {
    int idAgente;
    String nombre;
    String pseudonimo;
    String telefonoAgente;

    public AgenteDto(int idAgente, String nombre, String pseudonimo, String telefonoAgente) {
        this.idAgente = idAgente;
        this.nombre = nombre;
        this.pseudonimo = pseudonimo;
        this.telefonoAgente = telefonoAgente;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getTelefonoAgente() {
        return telefonoAgente;
    }

    public void setTelefonoAgente(String telefonoAgente) {
        this.telefonoAgente = telefonoAgente;
    }
}
