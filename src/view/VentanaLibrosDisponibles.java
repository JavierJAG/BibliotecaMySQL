package view;

import controller.Controlador;
import model.Libro;
import model.Socio;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaLibrosDisponibles extends JFrame {
    private Controlador controlador;

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;

    public VentanaLibrosDisponibles(Controlador controlador, ArrayList<Libro> listaLibros) {
        this.controlador = controlador;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setVisible(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDisponibles = new JLabel("LIBROS DISPONIBLES");
        lblDisponibles.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDisponibles.setBounds(128, 24, 192, 27);
        contentPane.add(lblDisponibles);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 392, 174);
        contentPane.add(scrollPane);

        table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Código", "Título", "Autor"});
        scrollPane.setViewportView(table);
        for (Libro libro : listaLibros) {
            tableModel.addRow(new Object[]{libro.getCodigo(), libro.getTitulo(), libro.getAutor(),});
        }
        table.setModel(tableModel);
    }

}
