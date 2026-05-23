package ar.edu.unlar.programacion3.streaming_musica01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unlar.programacion3.streaming_musica01.model.Artista;
import org.springframework.stereotype.Service;


@Service
public class ArtistaService {

     private List<Artista> artistas;

    public ArtistaService() {
        artistas = new ArrayList<>();
    }

    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    public List<Artista> listarArtistas() {
        return artistas;
    }

    public Optional<Artista> buscarPorId(String id) {

        return artistas.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Artista> buscarPorNombre(String nombre) {

        return artistas.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }
}


