package es.drachodran.apaw.http.entities;

import java.time.LocalDateTime;

public abstract class PromocionComponent {
    int idPromocion;
    LocalDateTime momentoPromocion;
    String local;
    String ciudad;


    public PromocionComponent(int idPromocion, LocalDateTime momentoPromocion, String local, String ciudad) {
        this.momentoPromocion = momentoPromocion;
        this.idPromocion = idPromocion;
        this.local = local;
        this.ciudad = ciudad;
    }


    public abstract void view();


    public abstract boolean isComposite();

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
