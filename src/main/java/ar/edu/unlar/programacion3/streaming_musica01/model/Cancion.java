package ar.edu.unlar.programacion3.streaming_musica01.model;
import java.util.UUID;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
public class Cancion {

    private String id;
    private String titulo;
    private Artista artista;
    private Album album;
    private Genero genero;
    private int duracionSegundos; // Duración en segundos
    private AtomicInteger reproducciones;
    private double rating; // Calificación promedio
    private LocalDate fechaLanzamiento;

    public Cancion(String titulo, Artista artista, Album album, Genero genero, int duracion, double rating, LocalDate fechaLanzamiento) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracionSegundos = duracion;
        this.reproducciones = new AtomicInteger(0);
        this.rating = rating;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public Artista getArtista() {
        return artista;
    }
    public Album getAlbum() {
        return album;
    }
    public Genero getGenero() {
        return genero;
    }
    public int getDuracion() {
        return duracionSegundos;
    }
    public AtomicInteger getReproducciones() {
        return reproducciones;
    }
    public double getRating() {
        return rating;
    }
    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setDuracion(int duracion) {
        this.duracionSegundos = duracion;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void reproducir() {
        reproducciones.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", artista=" + artista.getNombre() +
                ", album=" + album.getTitulo() +
                ", genero=" + genero +
                ", duracion=" + duracionSegundos +
                ", reproducciones=" + reproducciones +
                ", rating=" + rating +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }




}
