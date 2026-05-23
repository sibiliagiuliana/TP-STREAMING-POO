package ar.edu.unlar.programacion3.streaming_musica01.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
public class Productora {

    private String id;
    private String nombre;
    @JsonIgnore
    private List<Album> albumes;
    @JsonIgnore
    private List<Artista> artistas;

    public Productora(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.albumes = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

}
