package ar.edu.unlar.programacion3.streaming_musica01.controller;


import ar.edu.unlar.programacion3.streaming_musica01.model.Artista;
import ar.edu.unlar.programacion3.streaming_musica01.service.ArtistaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private final ArtistaService artistaService;

    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    // GET /api/artistas
    @GetMapping
    public ResponseEntity<List<Artista>> listarArtistas() {

        return ResponseEntity.ok(
                artistaService.listarArtistas()
        );
    }

    // GET /api/artistas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Artista> buscarPorId(
            @PathVariable String id
    ) {

        return artistaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/artistas/buscar?nombre=xxx
    @GetMapping("/buscar")
    public ResponseEntity<List<Artista>> buscarPorNombre(
            @RequestParam String nombre
    ) {

        return ResponseEntity.ok(
                artistaService.buscarPorNombre(nombre)
        );
    }
}