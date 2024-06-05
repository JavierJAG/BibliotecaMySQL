package view;

import controller.Controlador;
import model.Alquiler;
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

public class VentanaVerHistorico extends JFrame {
    private Controlador controlador;
    private ArrayList<Alquiler> listaAlquiler;

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;

    public VentanaVerHistorico(Controlador controlador, ArrayList<Alquiler> listaAlquiler) {
        this.controlador = controlador;
        this.listaAlquiler = listaAlquiler;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setVisible(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDisponibles = new JLabel("HISTÓRICO DE ALQUILERES");
        lblDisponibles.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDisponibles.setBounds(100, 23, 253, 27);
        contentPane.add(lblDisponibles);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 392, 174);
        contentPane.add(scrollPane);

        table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Código", "DNI", "Fecha préstamo", "Fecha devolución"});
        scrollPane.setViewportView(table);
        for (Alquiler alquiler : listaAlquiler) {
            tableModel.addRow(new Object[]{alquiler.getCodigo(), alquiler.getDni(), alquiler.getFechaPrestamo(), alquiler.getFechaDevolucion()});
        }
        table.setModel(tableModel);
    }

}
