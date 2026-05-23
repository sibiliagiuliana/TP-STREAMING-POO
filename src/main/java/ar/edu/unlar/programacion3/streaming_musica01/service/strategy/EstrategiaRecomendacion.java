package ar.edu.unlar.programacion3.streaming_musica01.service.strategy;


import ar.edu.unlar.programacion3.streaming_musica01.model.Cancion;

import java.util.List;

public interface EstrategiaRecomendacion {

    List<Cancion> recomendar(List<Cancion> catalogo, Cancion base);

}