package es.drachodran.apaw.businesscontrollers;


import es.drachodran.apaw.daos.ConciertoDao;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.dtos.ConciertoDto;
import es.drachodran.apaw.entities.Concierto;

public class ConciertosBusinessController {

    public void create(ConciertoDto conciertoDto) {
        Concierto concierto = new Concierto(conciertoDto.getId(),
                conciertoDto.getFecha(),
                conciertoDto.getDuracion(),
                conciertoDto.getNombre(),
                conciertoDto.getPrecio());
        DaoFactory.getFactory().getConciertoDao().save(concierto);
    }

    public void patchPrecio(int idConcierto, int nuevoPrecio) {
        ConciertoDao conciertoDao = DaoFactory.getFactory().getConciertoDao();
        if (nuevoPrecio > conciertoDao.getPrecio(idConcierto)) {
            conciertoDao.setPrecio(idConcierto, nuevoPrecio);
        }
    }

}
