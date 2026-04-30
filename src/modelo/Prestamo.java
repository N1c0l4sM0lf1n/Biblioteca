package modelo;

import java.time.LocalDate;


public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;
    private static final int DIAS_MAX = 7;
    private static final double MULTA_POR_DIA = 1000;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.activo = true;
    }

    public void finalizar() {
        if (!activo) {
            throw new IllegalStateException("Ya finalizado");
        }

        activo = false;
        fechaDevolucion = LocalDate.now();
        libro.devolver();

        double multa = calcularMulta();
        if (multa > 0) {
            System.out.println("Multa por atraso: $" + multa);
        }
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
    public double calcularMulta() {
        if (activo) return 0;

        long dias = java.time.temporal.ChronoUnit.DAYS
                .between(fechaPrestamo, fechaDevolucion);

        if (dias <= DIAS_MAX) return 0;

        return (dias - DIAS_MAX) * MULTA_POR_DIA;
    }
}