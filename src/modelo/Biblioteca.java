package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(libro.getCodigo())) {
                throw new IllegalArgumentException("Libro duplicado");
            }
        }
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(usuario.getId())) {
                throw new IllegalArgumentException("Usuario duplicado");
            }
        }
        usuarios.add(usuario);
    }

    public Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void registrarPrestamo(String idUsuario, String codigoLibro) {
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibro(codigoLibro);

        if (usuario == null) throw new IllegalArgumentException("Usuario no existe");
        if (libro == null) throw new IllegalArgumentException("Libro no existe");
        if (!libro.estaDisponible()) throw new IllegalStateException("Libro no disponible");

        libro.prestar();
        prestamos.add(new Prestamo(usuario, libro));
    }

    public void devolverLibro(String codigoLibro) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getCodigo().equals(codigoLibro) && p.estaActivo()) {
                p.finalizar();
                return;
            }
        }
        throw new IllegalStateException("No hay préstamo activo para este libro");
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Prestamo> getPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.estaActivo()) activos.add(p);
        }
        return activos;
    }
}