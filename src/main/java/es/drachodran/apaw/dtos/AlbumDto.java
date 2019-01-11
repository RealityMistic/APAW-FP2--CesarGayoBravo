package es.drachodran.apaw.dtos;

import es.drachodran.apaw.entities.GeneroMusical;

import java.time.LocalDateTime;

public class AlbumDto {
    int id;
    LocalDateTime fechaLanzamiento;
    GeneroMusical generoMusical;

    public AlbumDto() {
    }

    public AlbumDto(int id, LocalDateTime fechaLanzamiento, GeneroMusical generoMusical) {
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

    public LocalDateTime getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDateTime fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return "Album{" +
                "fecha de lanzamiento=" + fechaLanzamiento.toString() +
                ", genero='" + generoMusical + '\'' +'}';
    }
}
