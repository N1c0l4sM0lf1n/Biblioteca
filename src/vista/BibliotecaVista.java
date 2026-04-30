package vista;

import controlador.BibliotecaController;

import java.util.Scanner;

public class BibliotecaVista {
    private BibliotecaController controller;
    private Scanner scanner = new Scanner(System.in);

    public BibliotecaVista(BibliotecaController controller) {
        this.controller = controller;
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar libros");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Ver préstamos activos");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1 -> registrarLibro();
                    case 2 -> registrarUsuario();
                    case 3 -> prestarLibro();
                    case 4 -> devolverLibro();
                    case 5 -> controller.obtenerLibros().forEach(System.out::println);
                    case 6 -> controller.obtenerUsuarios().forEach(System.out::println);
                    case 7 -> controller.obtenerPrestamosActivos().forEach(System.out::println);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }

    private void registrarLibro() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        controller.registrarLibro(codigo, titulo, autor);
    }

    private void registrarUsuario() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        controller.registrarUsuario(id, nombre, correo);
    }

    private void prestarLibro() {
        System.out.print("ID Usuario: ");
        String id = scanner.nextLine();
        System.out.print("Código Libro: ");
        String codigo = scanner.nextLine();

        controller.prestarLibro(id, codigo);
    }

    private void devolverLibro() {
        System.out.print("Código Libro: ");
        String codigo = scanner.nextLine();

        controller.devolverLibro(codigo);
    }
}