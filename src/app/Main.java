package app;

import modelo.Biblioteca;
import controlador.BibliotecaController;
import vista.BibliotecaVista;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController controller = new BibliotecaController(biblioteca);
        BibliotecaVista vista = new BibliotecaVista(controller);

        vista.iniciar();
    }
}