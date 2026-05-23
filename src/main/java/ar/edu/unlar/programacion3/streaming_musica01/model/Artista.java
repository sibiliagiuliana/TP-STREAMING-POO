package ar.edu.unlar.programacion3.streaming_musica01.model;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Artista {

    private String id;
    private String nombre;
    @JsonIgnore
    private List<Album> albumes;
    

    public Artista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.albumes = new ArrayList<>();
      
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


}
