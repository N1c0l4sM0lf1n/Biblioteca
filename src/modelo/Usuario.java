package modelo;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;

    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + correo;
    }
}