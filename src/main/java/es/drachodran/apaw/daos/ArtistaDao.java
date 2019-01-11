package es.drachodran.apaw.daos;

import es.drachodran.apaw.entities.Artista;

import java.util.List;

public interface ArtistaDao extends GenericDao<Artista> {
    List<Artista> getArtistaLista();
    Artista findArtista(int idArtista);
    void setArtista(int idArtista, Artista artista);
}

