package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;

public class DaoFactoryMemory extends DaoFactory {

    private ArtistaDao artistaDao;


    @Override
    public ArtistaDao getArtistaDao() {
        if (this.artistaDao == null) {
            this.artistaDao = new ArtistaDaoMemory();
        }
        return this.artistaDao;
    }

}