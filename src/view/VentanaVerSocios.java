package view;

import controller.Controlador;
import model.Socio;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaVerSocios extends JFrame {
    private Controlador controlador;

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;
    private ArrayList listaSocios;

    public VentanaVerSocios(Controlador controlador, ArrayList<Socio> listaSocios) {
        this.controlador = controlador;
        this.listaSocios = listaSocios;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setVisible(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSocios = new JLabel("LISTA SOCIOS");
        lblSocios.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSocios.setBounds(158, 22, 135, 27);
        contentPane.add(lblSocios);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 392, 174);
        contentPane.add(scrollPane);

        table = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"DNI", "Nombre", "Apellidos"});
        scrollPane.setViewportView(table);
        for (Socio socio : listaSocios) {
            tableModel.addRow(new Object[]{socio.getDni(), socio.getNombre(), socio.getApellidos()});
        }
        table.setModel(tableModel);

    }
}
