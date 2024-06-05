package model;

import java.util.Date;

public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private Date fechaPrestamo;

    public Libro() {

    }

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro(int codigo, String titulo, String autor, Date fecha) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPrestamo = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
