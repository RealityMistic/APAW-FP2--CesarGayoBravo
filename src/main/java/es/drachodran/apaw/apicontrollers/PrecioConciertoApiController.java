package es.drachodran.apaw.apicontrollers;

import es.drachodran.apaw.businesscontrollers.ConciertosBusinessController;

public class PrecioConciertoApiController {

    public static final String PRECIOCONCIERTO = "/precioconcierto";

    private ConciertosBusinessController conciertoBusinessController = new ConciertosBusinessController();

    public void patchPrecio(int idConcierto, int precio) {
        this.conciertoBusinessController.patchPrecio(idConcierto, precio);
    }
}
