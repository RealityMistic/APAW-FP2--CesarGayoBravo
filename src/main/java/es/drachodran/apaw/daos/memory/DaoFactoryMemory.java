package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.AgenteDao;
import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;

public class DaoFactoryMemory extends DaoFactory {

    private ArtistaDao artistaDao;

    private AgenteDao agenteDao;

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

}