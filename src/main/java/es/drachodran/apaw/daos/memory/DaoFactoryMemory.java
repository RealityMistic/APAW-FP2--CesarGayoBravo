package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.AgenteDao;
import es.drachodran.apaw.daos.AlbumsDao;
import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;

public class DaoFactoryMemory extends DaoFactory {

    private ArtistaDao artistaDao;

    private AgenteDao agenteDao;

    private AlbumsDao albumsDao;

    @Override
    public ArtistaDao getArtistaDao() {
        if (this.artistaDao == null) {
            this.artistaDao = new ArtistaDaoMemory();
        }
        return this.artistaDao;
    }
    @Override
    public AgenteDao getAgenteDao() {
        if (this.agenteDao == null) {
            this.agenteDao = new AgenteDaoMemory();
        }
        return this.agenteDao;
    }

    @Override
    public AlbumsDao getAlbumsDao(){
        if (this.albumsDao == null) {
            this.albumsDao = new AlbumsDaoMemory();
        }
        return this.albumsDao;
    }

}