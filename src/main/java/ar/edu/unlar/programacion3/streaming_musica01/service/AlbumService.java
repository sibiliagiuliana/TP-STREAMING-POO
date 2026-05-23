package ar.edu.unlar.programacion3.streaming_musica01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unlar.programacion3.streaming_musica01.model.Album;
import org.springframework.stereotype.Service;


@Service
public class AlbumService {

        private List<Album> albumes;

    public AlbumService() {
        albumes = new ArrayList<>();
    }

    public void agregarAlbum(Album album) {
        albumes.add(album);
    }

    public List<Album> listarAlbumes() {
        return albumes;
    }

    public Optional<Album> buscarPorId(String id) {

        return albumes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Album> buscarPorTitulo(String titulo) {

        return albumes.stream()
                .filter(a -> a.getTitulo().equalsIgnoreCase(titulo))
                .toList();
    }
}


