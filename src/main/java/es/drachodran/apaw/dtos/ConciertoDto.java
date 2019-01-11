package es.drachodran.apaw.dtos;

import java.time.LocalDateTime;

public class ConciertoDto {
        private int id;

        private LocalDateTime fecha;

        private String nombre;

        private int precio;

        int duracion;

        public ConciertoDto(int id, LocalDateTime fecha, String nombre, int precio, int duracion) {
            this.id = id;
            this.fecha = fecha;
            this.nombre = nombre;
            this.precio=precio;
            this.duracion = duracion;
        }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }



        @Override
        public String toString() {
            return "ConciertoDto{" +
                    "momento=" + fecha.toString() +
                    ", nombre='" + nombre + '\'' +
                    ", precio='" + Integer.toString(precio) +'}';
        }


}
