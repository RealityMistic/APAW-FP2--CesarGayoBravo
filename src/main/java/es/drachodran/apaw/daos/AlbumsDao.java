package es.drachodran.apaw.daos;

import es.drachodran.apaw.entities.Album;

import java.util.List;

public interface AlbumsDao extends GenericDao<Album> {

    void addAlbums(List<Album> albumList);
    Album findLastAlbum();
}


