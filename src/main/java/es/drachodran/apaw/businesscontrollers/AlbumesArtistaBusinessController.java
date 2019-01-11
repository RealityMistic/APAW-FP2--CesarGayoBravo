package es.drachodran.apaw.businesscontrollers;

import es.drachodran.apaw.daos.AlbumsDao;
import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.dtos.AlbumDto;
import es.drachodran.apaw.entities.Album;
import es.drachodran.apaw.entities.Artista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumesArtistaBusinessController {

    public List<Album> convertListaDtoToAlbums(List<AlbumDto> listaAlbumDto){
        Iterator<AlbumDto> it = listaAlbumDto.iterator();
        Album album = new Album();
        AlbumDto currentAlbumDto;
        List<Album> albumesDevolver = new ArrayList<Album>();
        while(it.hasNext()){
            currentAlbumDto = it.next();
            album.setId( currentAlbumDto.getId());
            album.setFechaLanzamiento( currentAlbumDto.getFechaLanzamiento());
            album.setGeneroMusical (currentAlbumDto.getGeneroMusical());
           albumesDevolver.add(album);
        }
        return albumesDevolver;
    }
    public AlbumDto convertAlbumToDto (Album album){
        AlbumDto albumDto = new AlbumDto(album.getId(),
                        album.getFechaLanzamiento(),
                        album.getGeneroMusical() );
        return albumDto;
    }
    public void addAlbumes(int idArtista, List<AlbumDto> listaAlbumDto) {

        AlbumsDao albumsDao = DaoFactory.getFactory().getAlbumsDao();
        List<Album> listaAlbumesInsertar = convertListaDtoToAlbums(listaAlbumDto);
        albumsDao.addAlbums(listaAlbumesInsertar);
     //   System.out.println(listaAlbumesInsertar.get(0).getGeneroMusical());
        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();
        Artista artista = artistaDao.findArtista(idArtista);
     //   System.out.println(artista.getNombre());
        artista.setSusAlbumes(listaAlbumesInsertar);
        artistaDao.setArtista(idArtista, artista);
    }


}
