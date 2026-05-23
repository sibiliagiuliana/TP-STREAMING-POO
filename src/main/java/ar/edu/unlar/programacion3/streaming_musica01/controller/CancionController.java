package ar.edu.unlar.programacion3.streaming_musica01.controller;
import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;
import ar.edu.unlar.programacion3.streaming_musica01.service.BusquedaService;
import ar.edu.unlar.programacion3.streaming_musica01.service.CancionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionService cancionService;
    private final BusquedaService busquedaService;

    public CancionController(
            CancionService cancionService,
            BusquedaService busquedaService
    ) {
        this.cancionService = cancionService;
        this.busquedaService = busquedaService;
    }


@GetMapping
public ResponseEntity<List<Cancion>> listarCanciones() {

    return ResponseEntity.ok(
            cancionService.listarCanciones()
    );
}

@GetMapping("/{id}")
public ResponseEntity<Cancion> buscarPorId(
        @PathVariable String id
) {

    return cancionService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@GetMapping("/buscar")
public ResponseEntity<List<Cancion>> buscarCanciones(
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String artista
) {

    if (titulo != null) {
        return ResponseEntity.ok(
                busquedaService.buscarPorTitulo(titulo)
        );
    }

    if (artista != null) {
        return ResponseEntity.ok(
                busquedaService.buscarPorArtista(artista)
        );
    }

    return ResponseEntity.badRequest().build();
}

@PostMapping("/{id}/reproducir")
public ResponseEntity<String> reproducirCancion(
        @PathVariable String id
) {

    cancionService.reproducirCancion(id);

    return ResponseEntity.ok(
            "Reproducción incrementada"
    );
}



}
