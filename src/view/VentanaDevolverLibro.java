package view;

import controller.Controlador;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaDevolverLibro extends JFrame {

    private JPanel contentPane;
    private Controlador controlador;
    private JTextField textCodigo;

    public VentanaDevolverLibro(Controlador controlador) {
        this.controlador = controlador;
        setTitle("APP BIBLIOTECA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 448, 258);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setVisible(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDevolver = new JLabel("DEVOLVER LIBRO");
        lblDevolver.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDevolver.setBounds(143, 45, 161, 20);
        contentPane.add(lblDevolver);

        textCodigo = new JTextField();
        textCodigo.setBounds(207, 104, 122, 20);
        contentPane.add(textCodigo);
        textCodigo.setColumns(10);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCodigo.setBounds(127, 104, 70, 17);
        contentPane.add(lblCodigo);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(294, 178, 89, 23);
        btnDevolver.addActionListener(controlador);
        btnDevolver.setActionCommand("confirmarDevolver");
        contentPane.add(btnDevolver);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(51, 178, 89, 23);
        btnCancelar.addActionListener(controlador);
        btnCancelar.setActionCommand("cancelarDevolver");
        contentPane.add(btnCancelar);
    }

    public String getcodigoLibro() {
        String codigoLibro = String.valueOf(textCodigo.getText());
        return codigoLibro;
    }

}
