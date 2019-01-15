package es.drachodran.apaw.apicontrollers;

import es.drachodran.apaw.businesscontrollers.ArtistaBusinessController;
import es.drachodran.apaw.dtos.ArtistaDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;

import java.util.List;

public class ArtistaApiController {
    public static final String ARTISTAS = "/artistas";
    public static final String NOMBRE =  "/nombre";
    public static final String FINDID = "/findid";
    public static final String DELETEID = "/deleteid";

    private ArtistaBusinessController artistaBusinessController = new ArtistaBusinessController();

    public List<ArtistaDto> readAll(){
        return artistaBusinessController.readAll();
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " no está presente");
        }
    }

    public ArtistaDto findById(int artistaId){
    //    System.out.println("APi artista controller pidiendo DTO" + String.valueOf(artistaId));
        return this.artistaBusinessController.findById(artistaId);

    }

    public ArtistaDto findByName(String name){
        this.validate(name, "Nombre de artista");
        return this.artistaBusinessController.findByName(name);
    }

    public void deleteById(int artistaId){
        this.validate(artistaId, "El identificador del artista ");
        this.artistaBusinessController.deleteById(artistaId);
    }


}
