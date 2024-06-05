package controller;

import model.Alquiler;
import model.Libro;
import model.Modelo;
import model.Socio;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase gestiona las acciones que deben llevarse a cabo según el botón que se pulse en la aplicación
 */
public class Controlador implements ActionListener {
    private VentanaAlquilarLibro alquilar;
    private VentanaDevolverLibro devolver;


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Alquilar")) {
            //Este try es para que no se puedan abrir varias ventanas iguales y que la primera no funcione. Siempre da
            //error la primera vez, pero se recoge
            try {
                alquilar.dispose();
            } catch (Exception ex) {
            }
            VentanaAlquilarLibro alquilar = new VentanaAlquilarLibro(this);
            setAlquilar(alquilar);
        }
        if (e.getActionCommand().equals("cancelarAlquilar")) {
            alquilar.dispose();
        }
        if (e.getActionCommand().equals("confirmarAlquilar")) {
            Modelo modelo = new Modelo();
            modelo.openConnection();
            int codigoLibro = Integer.parseInt(alquilar.getcodigoLibro());
            String dniSocio = alquilar.getDNI();
            try {
                if (modelo.verificarDisponibilidad(codigoLibro)) {
                    modelo.actualizarTablaAlquiler(codigoLibro, dniSocio);
                } else {
                    System.out.println("El libro no está disponible para alquilar.");
                }
                modelo.closeConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getActionCommand().equals("Devolver")) {
            //Este try es para que no se puedan abrir varias ventanas iguales y que la primera no funcione. Siempre da
            //error la primera vez, pero se recoge
            try {
                devolver.dispose();
            } catch (Exception ex) {
            }
            VentanaDevolverLibro devolver = new VentanaDevolverLibro(this);
            setDevolver(devolver);

        }
        if (e.getActionCommand().equals("confirmarDevolver")) {
            Modelo modelo = new Modelo();
            int codigo = Integer.parseInt(devolver.getcodigoLibro());
            modelo.openConnection();
            modelo.devolverLibro(codigo);
            modelo.closeConnection();

        }
        if (e.getActionCommand().equals("cancelarDevolver")) {
            devolver.dispose();
        }
        if (e.getActionCommand().equals("VerLibros")) {
            Modelo modelo = new Modelo();
            modelo.openConnection();
            ArrayList<Libro> listaLibros = modelo.getLibroList();
            modelo.closeConnection();
            VentanaLibrosDisponibles libros = new VentanaLibrosDisponibles(this, listaLibros);

        }
        if (e.getActionCommand().equals("VerSocios")) {
            Modelo modelo = new Modelo();
            modelo.openConnection();
            ArrayList<Socio> listaSocios = modelo.getSociosList();
            modelo.closeConnection();
            VentanaVerSocios socios = new VentanaVerSocios(this, listaSocios);

        }
        if (e.getActionCommand().equals("LibrosAlquilados")) {
            Modelo modelo = new Modelo();
            modelo.openConnection();
            ArrayList<Libro> listaAlquilados = modelo.getlistaAlquilados();
            modelo.closeConnection();
            VentanaLibrosAlquilados librosAlquilados = new VentanaLibrosAlquilados(this, listaAlquilados);
        }
        if (e.getActionCommand().equals("VerHistorico")) {
            Modelo modelo = new Modelo();
            modelo.openConnection();
            ArrayList<Alquiler> listaAlquiler = modelo.getAlquilerList();
            modelo.closeConnection();
            VentanaVerHistorico historico = new VentanaVerHistorico(this, listaAlquiler);
        }
    }

    public VentanaAlquilarLibro getAlquilar() {
        return alquilar;
    }

    public void setAlquilar(VentanaAlquilarLibro alquilar) {
        this.alquilar = alquilar;
    }

    public VentanaDevolverLibro getDevolver() {
        return devolver;
    }

    public void setDevolver(VentanaDevolverLibro devolver) {
        this.devolver = devolver;
    }
}
