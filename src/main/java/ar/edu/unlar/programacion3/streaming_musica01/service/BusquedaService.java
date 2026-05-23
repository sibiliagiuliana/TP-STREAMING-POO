package ar.edu.unlar.programacion3.streaming_musica01.service;

import java.util.List;

import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;
import org.springframework.stereotype.Service;

@Service
public class BusquedaService {

      private CancionService cancionService;

    public BusquedaService(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    public List<Cancion> buscarPorTitulo(String titulo) {

        return cancionService.listarCanciones().stream()
                .filter(c -> c.getTitulo().equalsIgnoreCase(titulo))
                .toList();
    }

    public List<Cancion> buscarPorArtista(String artista) {

        return cancionService.listarCanciones().stream()
                .filter(c -> c.getArtista().getNombre().equalsIgnoreCase(artista))
                .toList();
    }
}

