package app;

import modelo.Biblioteca;
import controlador.BibliotecaController;
import vista.BibliotecaVistaGUI;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController controller = new BibliotecaController(biblioteca);

        new BibliotecaVistaGUI(controller).setVisible(true);
    }
}