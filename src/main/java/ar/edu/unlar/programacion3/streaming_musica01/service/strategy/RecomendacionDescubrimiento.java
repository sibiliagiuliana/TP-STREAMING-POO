package ar.edu.unlar.programacion3.streaming_musica01.service.strategy;
import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;

import java.time.LocalDate;
import java.util.List;

public class RecomendacionDescubrimiento implements EstrategiaRecomendacion {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {

        int anioActual = LocalDate.now().getYear();

        return catalogo.stream()
                .filter(c -> c.getReproducciones().get() < 1000)
                .filter(c -> c.getFechaLanzamiento().getYear() >= anioActual - 2)
                .filter(c -> c.getGenero() != base.getGenero())
                .limit(10)
                .toList();
    }
}