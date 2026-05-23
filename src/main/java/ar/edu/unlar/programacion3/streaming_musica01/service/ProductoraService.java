package ar.edu.unlar.programacion3.streaming_musica01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unlar.programacion3.streaming_musica01.model.Productora;
import org.springframework.stereotype.Service;


@Service
public class ProductoraService {

       private List<Productora> productoras;

    public ProductoraService() {
        productoras = new ArrayList<>();
    }

    public void agregarProductora(Productora productora) {
        productoras.add(productora);
    }

    public List<Productora> listarProductoras() {
        return productoras;
    }

    public Optional<Productora> buscarPorId(String id) {

        return productoras.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Productora> buscarPorNombre(String nombre) {

        return productoras.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .toList();
    }
}

