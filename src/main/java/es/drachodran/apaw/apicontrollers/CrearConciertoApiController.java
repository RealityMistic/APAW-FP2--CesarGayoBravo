package es.drachodran.apaw.apicontrollers;

import es.drachodran.apaw.businesscontrollers.ConciertosBusinessController;
import es.drachodran.apaw.dtos.ConciertoDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;

public class CrearConciertoApiController {

    public static final String CONCIERTOS = "/conciertos";

    private ConciertosBusinessController conciertoBusinessController = new ConciertosBusinessController();

    public void create(ConciertoDto conciertoDto) {
        this.validate(conciertoDto, "conciertoDto");
        this.validate(conciertoDto.getNombre(), "ConciertoDto nombre");
        this.conciertoBusinessController.create(conciertoDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " no está presente");
        }
    }
}
