package es.drachodran.apaw.daos;
import es.drachodran.apaw.entities.Concierto;

public interface ConciertoDao extends GenericDao<Concierto> {
    public void addConcierto(Concierto concierto);
    public Concierto findConcierto(int idConcierto);
    public void setConcierto(int idConcierto, Concierto concierto);
    public int getId(Concierto concierto);
    public void setId(Concierto concierto, int id);
    public int getPrecio(int idConcierto);
    public void setPrecio(int idConcierto, int precio);

}
