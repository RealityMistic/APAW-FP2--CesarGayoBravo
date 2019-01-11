package es.drachodran.apaw.http.entities;

public class Agente extends Profesional{
    String telefonoAgente;

    public Agente(int id, String nombreAgente, String telefonoAgente) {
        this.id = id;
        this.nombre = nombreAgente;
        this.telefonoAgente = telefonoAgente;
    }

    public String getTelefonoAgente() {
        return telefonoAgente;
    }

    public void setTelefonoAgente(String telefonoAgente) {
        this.telefonoAgente = telefonoAgente;
    }


}
