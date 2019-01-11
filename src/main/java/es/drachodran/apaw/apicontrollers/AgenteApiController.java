package es.drachodran.apaw.apicontrollers;

import es.drachodran.apaw.businesscontrollers.AgenteBusinessController;
import es.drachodran.apaw.dtos.AgenteDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;

public class AgenteApiController {
    public static final String AGENTE = "/agente";
    private AgenteBusinessController agenteBusinessController = new AgenteBusinessController();


    public void addAgente(int idArtista, AgenteDto agenteDto){
         this.validate(agenteDto, " Objeto Agente ");
         this.agenteBusinessController.addAgente(idArtista, agenteDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " no está presente");
        }
    }
}
