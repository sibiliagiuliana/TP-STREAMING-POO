package ar.edu.unlar.programacion3.streaming_musica01.service;
import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


@Service
public class CancionService {

    private List<Cancion> canciones;

    public CancionService() {
        canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public List<Cancion> listarCanciones() {
        return canciones;
    }

    public Optional<Cancion> buscarPorId (String id){
        return canciones.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();
    }

    public void reproducirCancion (String id){
          
        canciones.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(c -> c.getReproducciones().incrementAndGet());
    }
}

    

   


