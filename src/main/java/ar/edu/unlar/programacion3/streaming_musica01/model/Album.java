package ar.edu.unlar.programacion3.streaming_musica01.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.time.LocalDate;
public class Album {

    private String id;
    private String titulo;
    private LocalDate fechaLanzamiento;

    private Artista artista;
    private Productora productora;
    @JsonIgnore
    private List<Cancion> canciones;

    public Album(String id, String titulo, LocalDate fechaLanzamiento, Artista artista, Productora productora) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.artista = artista;
        this.productora = productora;
        this.canciones = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public Artista getArtista() {
        return artista;
    }

    public Productora getProductora() {
        return productora;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

}
