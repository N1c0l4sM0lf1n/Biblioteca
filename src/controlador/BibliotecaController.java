package controlador;

import modelo.*;

import java.util.List;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void registrarLibro(String codigo, String titulo, String autor) {
        biblioteca.agregarLibro(new Libro(codigo, titulo, autor));
    }

    public void registrarUsuario(String id, String nombre, String correo) {
        biblioteca.agregarUsuario(new Usuario(id, nombre, correo));
    }

    public void prestarLibro(String idUsuario, String codigoLibro) {
        biblioteca.registrarPrestamo(idUsuario, codigoLibro);
    }

    public void devolverLibro(String codigoLibro) {
        biblioteca.devolverLibro(codigoLibro);
    }

    public List<Libro> obtenerLibros() {
        return biblioteca.getLibros();
    }

    public List<Usuario> obtenerUsuarios() {
        return biblioteca.getUsuarios();
    }

    public List<Prestamo> obtenerPrestamosActivos() {
        return biblioteca.getPrestamosActivos();
    }
}