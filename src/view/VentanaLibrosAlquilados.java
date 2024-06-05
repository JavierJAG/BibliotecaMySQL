package view;

import controller.Controlador;
import model.Libro;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaLibrosAlquilados extends JFrame {
    private Controlador controlador;
    private ArrayList<Libro> listaAlquilados;

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;

    public VentanaLibrosAlquilados(Controlador controlador, ArrayList<Libro> listaAlquilados) {
        this.controlador = controlador;
        this.listaAlquilados = listaAlquilados;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setVisible(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAlquilados = new JLabel("LIBROS ALQUILADOS");
        lblAlquilados.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAlquilados.setBounds(128, 24, 192, 27);
        contentPane.add(lblAlquilados);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 392, 174);
        contentPane.add(scrollPane);

        table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Código", "Título", "Autor", "Fecha"});
        scrollPane.setViewportView(table);
        for (Libro libro : listaAlquilados) {
            tableModel.addRow(new Object[]{libro.getCodigo(), libro.getTitulo(), libro.getAutor(), libro.getFechaPrestamo()});
        }
        table.setModel(tableModel);
    }
}
