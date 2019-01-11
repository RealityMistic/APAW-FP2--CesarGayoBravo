package es.drachodran.apaw.businesscontrollers;

import es.drachodran.apaw.daos.AgenteDao;
import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.dtos.AgenteDto;
import es.drachodran.apaw.entities.Agente;
import es.drachodran.apaw.entities.Artista;
import es.drachodran.apaw.exceptions.NotFoundException;

public class AgenteBusinessController {

    public Agente convertDtoToAgente(AgenteDao agenteDao, AgenteDto agenteDto) {
        Agente agente = new Agente(2,"Pepe", "Camarao");
        agente.setId(agenteDto.getIdAgente());
        agente.setNombre(agenteDto.getNombre());
        agente.setPseudonimo(agenteDto.getPseudonimo());
        agente.setTelefonoAgente(agenteDto.getTelefonoAgente());
        return agente;
    }


    public void addAgente(int idArtista, AgenteDto agenteDto) {

        AgenteDao agenteDao = DaoFactory.getFactory().getAgenteDao();
        Agente agente = this.convertDtoToAgente(agenteDao, agenteDto);

        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();


        Artista nuevoArtista = artistaDao.findArtista(idArtista);
       agenteDao.addAgente(agente);

        if (nuevoArtista != null){
            nuevoArtista.setSuAgente(agente);
            artistaDao.setArtista(idArtista, nuevoArtista);
        } else throw new NotFoundException("Artista es nulo");


    }


}


