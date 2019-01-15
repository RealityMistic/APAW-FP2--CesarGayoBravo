package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.*;

public class DaoFactoryMemory extends DaoFactory {

    private ArtistaDao artistaDao;

    private AgenteDao agenteDao;

    private AlbumsDao albumsDao;

    private ConciertoDao conciertoDao;

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

    @Override
    public ConciertoDao getConciertoDao() {
        if (this.conciertoDao == null) {
            this.conciertoDao = new ConciertoDaoMemory();
        }
        return this.conciertoDao;
    }



}