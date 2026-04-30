package modelo;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.activo = true;
    }

    public void finalizar() {
        if (!activo) {
            throw new IllegalStateException("El préstamo ya fue finalizado");
        }
        activo = false;
        fechaDevolucion = LocalDate.now();
        libro.devolver();
    }

    public boolean estaActivo() {
        return activo;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return usuario + " -> " + libro + " | " +
                (activo ? "Activo" : "Finalizado");
    }
}