package model;

public class Alquiler {
    private int codigo;
    private String dni;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Alquiler() {

    }

    public Alquiler(int codigo, String dni, String fechaprestamo, String fechaDevolucion) {
        this.codigo = codigo;
        this.dni = dni;
        this.fechaPrestamo = fechaprestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
