package ar.edu.unlar.programacion3.streaming_musica01.controller;

import ar.edu.unlar.programacion3.streaming_musica01.model.Productora;
import ar.edu.unlar.programacion3.streaming_musica01.service.ProductoraService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productoras")
public class ProductoraController {

    private final ProductoraService productoraService;

    public ProductoraController(ProductoraService productoraService) {
        this.productoraService = productoraService;
    }

    // GET /api/productoras
    @GetMapping
    public ResponseEntity<List<Productora>> listarProductoras() {

        return ResponseEntity.ok(
                productoraService.listarProductoras()
        );
    }

    // GET /api/productoras/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Productora> buscarPorId(
            @PathVariable String id
    ) {

        return productoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/productoras/buscar?nombre=xxx
    @GetMapping("/buscar")
    public ResponseEntity<List<Productora>> buscarPorNombre(
            @RequestParam String nombre
    ) {

        return ResponseEntity.ok(
                productoraService.buscarPorNombre(nombre)
        );
    }
}
