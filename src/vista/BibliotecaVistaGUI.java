package vista;

import controlador.BibliotecaController;

import javax.swing.*;
import java.awt.*;

public class BibliotecaVistaGUI extends JFrame {

    private BibliotecaController controller;

    public BibliotecaVistaGUI(BibliotecaController controller) {
        this.controller = controller;

        setTitle("Sistema Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1));

        JButton btnLibro = new JButton("Registrar Libro");
        JButton btnUsuario = new JButton("Registrar Usuario");
        JButton btnPrestamo = new JButton("Prestar Libro");
        JButton btnDevolver = new JButton("Devolver Libro");
        JButton btnListar = new JButton("Ver Libros");

        add(btnLibro);
        add(btnUsuario);
        add(btnPrestamo);
        add(btnDevolver);
        add(btnListar);

        btnLibro.addActionListener(e -> registrarLibro());
        btnUsuario.addActionListener(e -> registrarUsuario());
        btnPrestamo.addActionListener(e -> prestarLibro());
        btnDevolver.addActionListener(e -> devolverLibro());
        btnListar.addActionListener(e -> listarLibros());
    }

    private void registrarLibro() {
        String codigo = JOptionPane.showInputDialog("Código:");
        String titulo = JOptionPane.showInputDialog("Título:");
        String autor = JOptionPane.showInputDialog("Autor:");

        controller.registrarLibro(codigo, titulo, autor);
    }

    private void registrarUsuario() {
        String id = JOptionPane.showInputDialog("ID:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String correo = JOptionPane.showInputDialog("Correo:");

        controller.registrarUsuario(id, nombre, correo);
    }

    private void prestarLibro() {
        String id = JOptionPane.showInputDialog("ID Usuario:");
        String codigo = JOptionPane.showInputDialog("Código Libro:");

        controller.prestarLibro(id, codigo);
    }

    private void devolverLibro() {
        String codigo = JOptionPane.showInputDialog("Código Libro:");

        controller.devolverLibro(codigo);
    }

    private void listarLibros() {
        StringBuilder sb = new StringBuilder();
        controller.obtenerLibros().forEach(l -> sb.append(l).append("\n"));

        JOptionPane.showMessageDialog(this, sb.toString());
    }
}