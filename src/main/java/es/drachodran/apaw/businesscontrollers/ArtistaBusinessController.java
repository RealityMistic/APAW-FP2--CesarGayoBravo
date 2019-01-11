package es.drachodran.apaw.businesscontrollers;

import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.dtos.ArtistaDto;
import es.drachodran.apaw.entities.Artista;

import java.util.List;

public class ArtistaBusinessController {
    private ArtistaDto convertArtistaToDto(ArtistaDao artistaDao, int idArtista){

        ArtistaDto artistaDto = new ArtistaDto();
        int idDto = artistaDao.findArtista(idArtista).getIdArtista();
        artistaDto.setIdArtista(idDto);
        artistaDto.setNombre(artistaDao.findArtista(idArtista).getNombre());
        artistaDto.setAnonimo(artistaDao.findArtista(idArtista).getAnonimo());
        artistaDto.setPseudonimo(artistaDao.findArtista(idArtista).getPseudonimo());
        artistaDto.setSuAgente(artistaDao.findArtista(idArtista).getSuAgente());
        artistaDto.setSusAlbumes(artistaDao.findArtista(idArtista).getSusAlbumes());

        return artistaDto;
    }
    public List<ArtistaDto> readAll(){
        List<ArtistaDto> listaArtistas = null;
        ArtistaDto artistaDto = null;
        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();
        int max = artistaDao.getArtistaLista().size();
        for (int id=0; id<max; id++) {
            convertArtistaToDto(artistaDao, id);
        }
        listaArtistas.add(
            artistaDto
        ); // todos);
        return listaArtistas;
    }
    public ArtistaDto findById (int idArtista){

        ArtistaDto artistaDto = null;
        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();
        artistaDto = convertArtistaToDto(artistaDao, idArtista);

        return artistaDto;
    }

    public void deleteById (int idArtista){

        ArtistaDto artistaDto = null;
        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();
        artistaDao.deleteById(idArtista);

    }
    public ArtistaDto findByName(String name){
        ArtistaDao artistaDao = DaoFactory.getFactory().getArtistaDao();

        ArtistaDto artistaDto;
        int idBuscar = 0;
        for (Artista artista : artistaDao.getArtistaLista()) {
            if (artista.getNombre() == name);
            idBuscar = artista.getId();
        }
        artistaDto = convertArtistaToDto(artistaDao, idBuscar);
        return artistaDto;
    }

}
