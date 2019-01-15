package es.drachodran.apaw.entities;

import java.util.ArrayList;

public class ArtistaBuilder extends Profesional{

    int idArtista;
    boolean anonimo;
    Agente suAgente;
    ArrayList<Album> susAlbumes;

    public ArtistaBuilder(int idArtista, String nombre, String pseudonimo, boolean anonimo, Agente suAgente) {
        this.idArtista = idArtista;
        this.nombre=nombre;
        this.pseudonimo=pseudonimo;
        this.anonimo = anonimo;
        this.suAgente = suAgente;
    }


    public int getIdArtista() {
        return idArtista;
    }

    public boolean isAnonimo() {
        return anonimo;
    }


    public Agente getSuAgente() {
        return suAgente;
    }

    public ArrayList<Album> getSusAlbumes() {
        return susAlbumes;
    }

    public void susAlbumes(ArrayList<Album> susAlbumes) {
        this.susAlbumes = susAlbumes;
    }

    public Artista buildArtista(){
        return new Artista(this);
    }
    public void id(int idArtista){
            this.idArtista=idArtista;
    }
    public void agente(int idAgente, String nombre, String telefono){
            suAgente = new Agente(idAgente, nombre, telefono);
    }
    public void nombre(String nombre){
            this.nombre=nombre;
    }
    public void pseudonimo(String pseudonimo){
            this.pseudonimo = pseudonimo;
    }
    public void anonimo(boolean anonimo){
            this.anonimo=anonimo;
    }
}
