package es.drachodran.apaw.http.entities;

import java.time.LocalDateTime;
import java.time.Month;

public class Album {
    int id;
    LocalDateTime fechaLanzamiento;
    GeneroMusical generoMusical;

    public Album() {
        this.id=0;
        this.fechaLanzamiento=null;
        this.generoMusical=null;
    }

    public Album(int id, LocalDateTime fechaLanzamiento, GeneroMusical generoMusical) {
        this.id = id;
        this.fechaLanzamiento = fechaLanzamiento;
        this.generoMusical = generoMusical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int anio, Month mes, int diaDelMes, int hora, int minuto) {
        this.fechaLanzamiento = LocalDateTime.of(anio, mes, diaDelMes, hora, minuto);
    }
    public void setFechaLanzamiento(LocalDateTime localDateTime) {
        this.fechaLanzamiento = localDateTime;
    }
}
