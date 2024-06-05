package view;

import controller.Controlador;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

    private JPanel contentPane;
    private Controlador controlador;

    public VentanaPrincipal(Controlador controlador) {
        this.controlador = controlador;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 392, 279);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAlquilarLibro = new JButton("Alquilar libro");
        btnAlquilarLibro.setBounds(220, 57, 131, 23);
        contentPane.add(btnAlquilarLibro);
        btnAlquilarLibro.addActionListener(controlador);
        btnAlquilarLibro.setActionCommand("Alquilar");

        JButton btnDevolverLibro = new JButton("Devolver libro");
        btnDevolverLibro.setBounds(220, 91, 131, 23);
        contentPane.add(btnDevolverLibro);
        btnDevolverLibro.addActionListener(controlador);
        btnDevolverLibro.setActionCommand("Devolver");

        JButton btnLibrosDisponibles = new JButton("Libros disponibles");
        btnLibrosDisponibles.setBounds(21, 91, 131, 23);
        contentPane.add(btnLibrosDisponibles);
        btnLibrosDisponibles.addActionListener(controlador);
        btnLibrosDisponibles.setActionCommand("VerLibros");

        JButton btnVerSocios = new JButton("Ver socios");
        btnVerSocios.setBounds(21, 57, 131, 23);
        contentPane.add(btnVerSocios);
        btnVerSocios.addActionListener(controlador);
        btnVerSocios.setActionCommand("VerSocios");

        JButton btnLibrosAlquilados = new JButton("Libros alquilados");
        btnLibrosAlquilados.setBounds(21, 130, 131, 23);
        contentPane.add(btnLibrosAlquilados);
        btnLibrosAlquilados.addActionListener(controlador);
        btnLibrosAlquilados.setActionCommand("LibrosAlquilados");

        JButton btnHistorico = new JButton("Ver histórico");
        btnHistorico.setBounds(220, 130, 131, 23);
        contentPane.add(btnHistorico);
        btnHistorico.addActionListener(controlador);
        btnHistorico.setActionCommand("VerHistorico");

        setVisible(true);
    }
}
