package es.drachodran.apaw.apicontrollers;

import es.drachodran.apaw.businesscontrollers.AlbumesArtistaBusinessController;
import es.drachodran.apaw.dtos.AlbumDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;

import java.util.List;

public class AlbumesArtistaApiController {
    public static final String ALBUMES = "/albumes";

    public AlbumesArtistaApiController(){

    }
    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " no está presente");
        }
    }
    public List<AlbumDto> addAlbumes(int idArtista, List<AlbumDto> listaAlbumDto){
        AlbumesArtistaBusinessController albumesArtistaBusinessController = new AlbumesArtistaBusinessController();
        validate(listaAlbumDto, " Objeto lista de Álbumes ");
        albumesArtistaBusinessController.addAlbumes(idArtista, listaAlbumDto);
        return listaAlbumDto;
    }



}
