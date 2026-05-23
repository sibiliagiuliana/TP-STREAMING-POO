package ar.edu.unlar.programacion3.streaming_musica01.service.strategy;

import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;

import java.util.Comparator;
import java.util.List;

public class RecomendacionPorPopularidad implements EstrategiaRecomendacion {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {

        return catalogo.stream()
                .sorted(
                        Comparator.comparingInt(
                                (Cancion c) -> c.getReproducciones().get()
                        ).reversed()
                )
                .limit(5)
                .toList();
    }
}