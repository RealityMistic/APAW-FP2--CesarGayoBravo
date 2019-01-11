package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.AlbumsDao;
import es.drachodran.apaw.entities.Album;
import es.drachodran.apaw.entities.GeneroMusical;

import java.time.LocalDateTime;
import java.util.*;

public class AlbumsDaoMemory extends GenericDaoMemory<Album> implements AlbumsDao {
    private List<Album> listaAlbums;


    public AlbumsDaoMemory(){

        Album albumPrimero = new Album(
                1,LocalDateTime.now(),
                GeneroMusical.CANCION_LIGERA
        );
        Album albumSegundo = new Album(2, LocalDateTime.now(),
                GeneroMusical.FUNK
        );
        map.put(1, albumPrimero);
        map.put(2, albumSegundo);
        listaAlbums = new ArrayList<Album>(map.values());
    }
    @Override
    public void setId(Album album, int id) {
        album.setId(id);
    }
    @Override
    public int getId(Album album){
        return album.getId();
    }


    @Override
    public void addAlbums(List<Album> albumsToAdd) {
        HashMap<Integer, Album> tempMap;
        tempMap = new HashMap<Integer, Album>();
        HashMap<Integer, Album> mapFusion;
        mapFusion = new HashMap<Integer, Album>(map);

        for(int i=0;i<albumsToAdd.size();i++){
            Integer keyInteger = new Integer(albumsToAdd.get(i).getId());
            tempMap.put(keyInteger, albumsToAdd.get(i) );
        }
       mapFusion.putAll(tempMap);
        map = mapFusion;
    }

    @Override
    public Album findLastAlbum(){
        Album lastAlbum = null;
        listaAlbums = new ArrayList<Album>();
        Iterator<Map.Entry<Integer, Album>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            listaAlbums.add((Album) it.next().getValue());
            if (lastAlbum == null
                    || ((Album) it.next()).getFechaLanzamiento().isAfter(lastAlbum.getFechaLanzamiento()))
            {
                lastAlbum= ((Album) it.next().getValue());
            }
        }
        return lastAlbum;
    }
}

