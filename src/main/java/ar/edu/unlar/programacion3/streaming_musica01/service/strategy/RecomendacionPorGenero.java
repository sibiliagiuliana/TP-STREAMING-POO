package ar.edu.unlar.programacion3.streaming_musica01.service.strategy;

import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;

import java.util.Comparator;
import java.util.List;

public class RecomendacionPorGenero implements EstrategiaRecomendacion {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {

        return catalogo.stream()
                .filter(c -> c.getGenero() == base.getGenero())
                .filter(c -> !c.getId().equals(base.getId()))
                .sorted(Comparator.comparing(Cancion::getRating).reversed())
                .toList();
    }
}
