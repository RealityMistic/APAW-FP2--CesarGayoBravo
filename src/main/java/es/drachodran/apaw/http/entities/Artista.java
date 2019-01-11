package es.drachodran.apaw.http.entities;

import java.util.List;


public class Artista extends Profesional {
    int idArtista;
    boolean anonimo;
    Agente suAgente;
    List<Album> susAlbumes;
    ArtistaBuilder artistaBuilder;



    public Artista(ArtistaBuilder artistaBuilder) {
        this.idArtista = artistaBuilder.getIdArtista();
        this.nombre = artistaBuilder.getNombre();
        this.pseudonimo = artistaBuilder.getPseudonimo();
        this.anonimo = artistaBuilder.isAnonimo();
        this.suAgente = artistaBuilder.getSuAgente();
        this.susAlbumes = artistaBuilder.getSusAlbumes();
    }

    public int getIdArtista() {
        return idArtista;
    }

    public Agente getSuAgente(){
        return suAgente;
    }

    public void setSuAgente(Agente agente){ this.suAgente = agente; }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public List<Album> getSusAlbumes() {
        return susAlbumes;
    }

    public void setSusAlbumes(List<Album> susAlbumes) {
        this.susAlbumes = susAlbumes;
    }

    public Boolean getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(Boolean anonimo) {
        this.anonimo = anonimo;
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
}
