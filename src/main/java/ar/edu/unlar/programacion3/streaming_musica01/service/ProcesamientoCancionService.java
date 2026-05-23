package ar.edu.unlar.programacion3.streaming_musica01.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;
import ar.edu.unlar.programacion3.streaming_musica01.model.Genero;
import org.springframework.stereotype.Service;

@Service
public class ProcesamientoCancionService {

    private CancionService cancionService;

    public ProcesamientoCancionService(CancionService cancionService) {
        this.cancionService = cancionService;
    }


     public List<Cancion> filtrarCanciones(
        Genero genero,
        String artista,
        int anioDesde,
        int anioHasta,
        double ratingMinimo
    ) {
        return cancionService.listarCanciones().stream()
            .filter(c -> (genero == null || c.getGenero() == genero) &&
                         (artista == null || c.getArtista().getNombre().equalsIgnoreCase(artista)) &&
                         (anioDesde <= 0 || c.getFechaLanzamiento().getYear() >= anioDesde) &&
                         (anioHasta <= 0 || c.getFechaLanzamiento().getYear() <= anioHasta) &&
                         (ratingMinimo <= 0 || c.getRating() >= ratingMinimo))
            .toList();
    }

    public List<Cancion> top10MasReproducidas() {
        return cancionService.listarCanciones().stream()
            .sorted((c1, c2) -> Integer.compare(
                c2.getReproducciones().get(), 
                c1.getReproducciones().get()))
            .limit(10)
            .toList();
    }

    public Map<Genero, Double> promedioDuracionPorGenero() {
        return cancionService.listarCanciones().stream()
            .collect(Collectors.groupingBy(
                Cancion::getGenero,
                Collectors.averagingInt(Cancion::getDuracion)
            ));
    }

    public Optional<Cancion> artistaMasPopular () {
        return cancionService.listarCanciones().stream()
            .max(Comparator.comparingInt(
                c -> c.getReproducciones().get()));
    }

    public Map<Integer, List<Cancion>> distribucionPorDecadas(){

        return cancionService.listarCanciones().stream()
            .collect(Collectors.groupingBy(
                c -> (c.getFechaLanzamiento().getYear() / 10) * 10
            ));
    }

    public List<Cancion> generarPlaylistAutomatica (int minutos){
        int objetivoSegundos = minutos * 60;
        List<Cancion> playlist = new ArrayList<>();
        buscarPlaylist (0, objetivoSegundos, playlist);
        return playlist;
    }

    private boolean buscarPlaylist (int indice, int segundosRestantes, List<Cancion> playlist){
        // caso exacto
        if (segundosRestantes == 0) {
            return true;
        }

        // caso invalido 
        if (segundosRestantes < 0 || indice >= cancionService.listarCanciones().size()) {
            return false;
        }

        Cancion actual = cancionService.listarCanciones().get(indice);

        // incluir la cancion actual
        playlist.add(actual);
        if (buscarPlaylist(indice + 1,
         segundosRestantes - actual.getDuracion(), 
         playlist)) {
            return true;
        }

        // backtracking 
        playlist.remove(playlist.size() - 1);
        return buscarPlaylist(
            indice + 1, 
            segundosRestantes, 
            playlist);
    }

    public Optional<Cancion> buscarPorTituloBinario (String titulo){
        List<Cancion> ordenadas = cancionService.listarCanciones().stream()
            .sorted(Comparator.comparing(Cancion::getTitulo))
            .toList();

        int izquierda = 0;
        int derecha = ordenadas.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Cancion actual = ordenadas.get(medio);
            int comparacion = actual.getTitulo().compareToIgnoreCase(titulo);

            if (comparacion == 0) {
                return Optional.of(actual);
            }
            if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return Optional.empty();
    }

    public List<Cancion> ordenarPorArtistaYFecha (){
        return cancionService.listarCanciones().stream()
            .sorted(Comparator.comparing((Cancion c) -> c.getArtista().getNombre())
            .thenComparing(Cancion::getFechaLanzamiento)
            .reversed()
       )   .toList();
        
    }

    public List<Cancion> busquedaLinealMultiple ( Genero genero, int anio, double ratingMinimo){
        return cancionService.listarCanciones().stream()
            .filter(c -> (c.getGenero() == genero) &&
                         (c.getFechaLanzamiento().getYear() > anio) &&
                         (c.getRating() > ratingMinimo))
            .toList();
    }



}
