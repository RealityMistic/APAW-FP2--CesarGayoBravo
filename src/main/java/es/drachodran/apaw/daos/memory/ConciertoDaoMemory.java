package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.ConciertoDao;
import es.drachodran.apaw.entities.Concierto;
import es.drachodran.apaw.exceptions.NotFoundException;

import java.time.LocalDateTime;

public class ConciertoDaoMemory extends GenericDaoMemory<Concierto> implements ConciertoDao {

    public ConciertoDaoMemory() {
        Concierto conciertoPrimero = new Concierto(
                1,
                LocalDateTime.now(),
                60 ,
                "SuomiPop1",
                150);
        Concierto conciertoSegundo = new Concierto(
                1,
                LocalDateTime.now(),
                40 ,
                "Koktebel",
                200);
        map.put(1, conciertoPrimero);
        map.put(2, conciertoSegundo);
    }

    @Override
    public void addConcierto(Concierto concierto) {
        map.put(concierto.getId(), concierto);
    }
    @Override
    public Concierto findConcierto(int idConcierto){
        return map.get(idConcierto);
    }
    @Override
    public void setConcierto(int idConcierto, Concierto concierto) {
        map.put(idConcierto, concierto);
    }



    @Override
    public int getId(Concierto concierto) {
        return concierto.getId();
    }

    @Override
    public void setId(Concierto concierto, int id) {
        concierto.setId(id);
        map.put(id,concierto);
    }
    @Override
    public int getPrecio(int idConcierto) {
        if (map.get(idConcierto) != null)
                    return map.get(idConcierto).getPrecio();
        else throw new NotFoundException("No existe ese id de Concierto.");
    }

    @Override
    public void setPrecio(int idConcierto, int precio) {
        Concierto modifiedConcierto = map.get(idConcierto);
        modifiedConcierto.setPrecio(precio);
        map.put(idConcierto, modifiedConcierto);
    }
}