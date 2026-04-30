package modelo;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El libro no está disponible");
        }
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " - " + autor +
                " (" + (disponible ? "Disponible" : "Prestado") + ")";
    }
}