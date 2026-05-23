package ar.edu.unlar.programacion3.streaming_musica01.controller;

import ar.edu.unlar.programacion3.streaming_musica01.model.Album;
import ar.edu.unlar.programacion3.streaming_musica01.service.AlbumService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    // GET /api/albumes
    @GetMapping
    public ResponseEntity<List<Album>> listarAlbumes() {

        return ResponseEntity.ok(
                albumService.listarAlbumes()
        );
    }

    // GET /api/albumes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Album> buscarPorId(
            @PathVariable String id
    ) {

        return albumService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/albumes/buscar?titulo=xxx
    @GetMapping("/buscar")
    public ResponseEntity<List<Album>> buscarPorTitulo(
            @RequestParam String titulo
    ) {

        return ResponseEntity.ok(
                albumService.buscarPorTitulo(titulo)
        );
    }
}
