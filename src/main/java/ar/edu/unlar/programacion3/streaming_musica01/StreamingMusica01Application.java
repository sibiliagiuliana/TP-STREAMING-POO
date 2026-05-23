package ar.edu.unlar.programacion3.streaming_musica01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import ar.edu.unlar.programacion3.streaming_musica01.model.*;
import ar.edu.unlar.programacion3.streaming_musica01.service.*;

@SpringBootApplication
public class StreamingMusica01Application {

	public static void main(String[] args) {
		SpringApplication.run(StreamingMusica01Application.class, args);
	}

	@Bean
CommandLineRunner init(
        CancionService cancionService,
        ArtistaService artistaService,
        AlbumService albumService,
        ProductoraService productoraService
) {

    return args -> {

        System.out.println("Cargando datos iniciales...");

		Productora Elektra = new Productora("1", "Elektra");
		Productora EpicRecords = new Productora("2","Epic Records");
		Productora warner = new Productora("3", "Warner Music");
        Productora sony = new Productora("4", "Sony Music");

productoraService.agregarProductora(Elektra);
productoraService.agregarProductora(EpicRecords);
productoraService.agregarProductora(warner);
productoraService.agregarProductora(sony);

Artista queen = new Artista("1","Queen");
Artista michael = new Artista("2","Michael Jackson");
Artista daftPunk = new Artista("3", "Daft Punk");
Artista milesDavis = new Artista("4", "Miles Davis");
Artista mozart = new Artista("5", "Mozart");

artistaService.agregarArtista(queen);
artistaService.agregarArtista(michael);
artistaService.agregarArtista(daftPunk);
artistaService.agregarArtista(milesDavis);
artistaService.agregarArtista(mozart);

Album album1 = new Album("1", "A Night at the Opera", LocalDate.of(1975, 11, 21), queen, Elektra);
Album album2 = new Album("2", "Thriller", LocalDate.of(1982, 11, 30), michael, EpicRecords);
Album album3 = new Album("3","Random Access Memories",LocalDate.of(2013, 5, 17),daftPunk,sony);
Album album4 = new Album("4","Kind of Blue",LocalDate.of(1959, 8, 17),milesDavis,warner);
Album album5 = new Album("5","Requiem",LocalDate.of(1791, 12, 5),mozart,sony);

albumService.agregarAlbum(album1);
albumService.agregarAlbum(album2);
albumService.agregarAlbum(album3);
albumService.agregarAlbum(album4);
albumService.agregarAlbum(album5);

Cancion c1 = new Cancion( "Bohemian Rhapsody", queen, album1, Genero.ROCK, 354, 4.9, LocalDate.of(1975, 10, 31));
Cancion c2 = new Cancion("Thriller", michael, album2, Genero.POP, 320, 4.8, LocalDate.of(1982, 11, 30));
Cancion c3 = new Cancion("Get Lucky", daftPunk,album3, Genero.ELECTRONICA, 369,4.7, LocalDate.of(2013, 4, 19));
Cancion c4 = new Cancion("One More Time", daftPunk, album3, Genero.ELECTRONICA, 320, 4.6, LocalDate.of(2000, 11, 30));
Cancion c5 = new Cancion("So What", milesDavis, album4, Genero.JAZZ, 545, 4.9, LocalDate.of(1959, 8, 17));
Cancion c6 = new Cancion("Freddie Freeloader", milesDavis, album4, Genero.JAZZ, 589, 4.8, LocalDate.of(1959, 8, 17));
Cancion c7 = new Cancion("Lacrimosa", mozart, album5, Genero.CLASICA, 180, 5.0, LocalDate.of(1791, 12, 5));
Cancion c8 = new Cancion("Symphony No. 40", mozart, album5, Genero.CLASICA, 480, 4.9, LocalDate.of(1788, 7, 25));
Cancion c9 = new Cancion("Billie Jean", michael, album2, Genero.POP, 294, 4.9, LocalDate.of(1983, 1, 2));
Cancion c10 = new Cancion("Love of My Life", queen, album1, Genero.ROCK, 220, 4.8, LocalDate.of(1975, 11, 21));

cancionService.agregarCancion(c1);
cancionService.agregarCancion(c2);
cancionService.agregarCancion(c3);
cancionService.agregarCancion(c4);
cancionService.agregarCancion(c5);
cancionService.agregarCancion(c6);
cancionService.agregarCancion(c7);
cancionService.agregarCancion(c8);
cancionService.agregarCancion(c9);
cancionService.agregarCancion(c10);

// RELACIONES ARTISTA -> ALBUM
queen.getAlbumes().add(album1);
michael.getAlbumes().add(album2);
daftPunk.getAlbumes().add(album3);
milesDavis.getAlbumes().add(album4);
mozart.getAlbumes().add(album5);

// RELACIONES PRODUCTORA -> ALBUM
Elektra.getAlbumes().add(album1);
EpicRecords.getAlbumes().add(album2);
sony.getAlbumes().add(album3);
warner.getAlbumes().add(album4);
sony.getAlbumes().add(album5);

// RELACIONES PRODUCTORA -> ARTISTA
Elektra.getArtistas().add(queen);
EpicRecords.getArtistas().add(michael);
sony.getArtistas().add(daftPunk);
warner.getArtistas().add(milesDavis);
sony.getArtistas().add(mozart);

// RELACIONES ALBUM -> CANCIONES
album1.getCanciones().add(c1);
album1.getCanciones().add(c10);

album2.getCanciones().add(c2);
album2.getCanciones().add(c9);

album3.getCanciones().add(c3);
album3.getCanciones().add(c4);

album4.getCanciones().add(c5);
album4.getCanciones().add(c6);

album5.getCanciones().add(c7);
album5.getCanciones().add(c8);


System.out.println("Datos cargados correctamente");

    };
}

}
