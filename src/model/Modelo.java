package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo {
    private Connection connection;
    // Cambiar los siguientes datos por los de tu conexión
    private final String usuario = "root";
    private final String clave = "12345678";
    private final String url = "jdbc:mysql://localhost:3306/biblioteca";

    private LocalDate fechaHoy = LocalDate.now();

    public Modelo() {
        openConnection();
    }

    /**
     * Abre la conexión
     */
    public void openConnection() {
        try {
            this.connection = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException sqle) {
            System.out.println("Error al abrir la conexión");
        }
    }

    /**
     * Cierra la conexión
     */
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException sqle) {
            System.out.println("Error al cerrar la conexión");
        }
    }

    /**
     * Obtiene una lista de todos los socios
     */
    public ArrayList<Socio> getSociosList() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM socio");
            ResultSet rs = ps.executeQuery();

            ArrayList<Socio> listaSocios = new ArrayList<Socio>();
            while (rs.next()) {
                listaSocios.add(new Socio(rs.getString("dni"), rs.getString("nombre"),
                        rs.getString("apellidos")));
            }

            return listaSocios;

        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return new ArrayList<Socio>();
        }
    }

    /**
     * Obtiene una lista de todos los libros disponibles
     */
    public ArrayList<Libro> getLibroList() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM libro WHERE codigo NOT IN (SELECT codigolibro FROM alquiler WHERE fechadevolucion IS NULL)");
            ResultSet rs = ps.executeQuery();

            ArrayList<Libro> listaLibros = new ArrayList<Libro>();
            while (rs.next()) {
                listaLibros.add(new Libro(Integer.parseInt(rs.getString("codigo")), rs.getString("titulo"),
                        rs.getString("autor")));
            }

            return listaLibros;

        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return new ArrayList<Libro>();
        }
    }

    /**
     * Obtiene una lista de los alquileres
     */
    public ArrayList<Alquiler> getAlquilerList() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM alquiler ORDER BY fechaprestamo");
            ResultSet rs = ps.executeQuery();

            ArrayList<Alquiler> listaAlquiler = new ArrayList<Alquiler>();
            while (rs.next()) {
                listaAlquiler.add(new Alquiler(Integer.parseInt(rs.getString("codigoLibro")), rs.getString("dni"), rs.getString("fechaprestamo"),
                        rs.getString("fechadevolucion")));
            }

            return listaAlquiler;

        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return new ArrayList<Alquiler>();
        }
    }

    /**
     * Obtiene una lista de los libros alquilados
     */
    public ArrayList<Libro> getlistaAlquilados() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("" +
                    "WITH LibrosAlquilados AS (\n" +
                    "    SELECT\n" +
                    "        libro.*,\n" +
                    "        alquiler.fechaPrestamo,\n" +
                    "        ROW_NUMBER() OVER (PARTITION BY libro.codigo ORDER BY alquiler.fechaPrestamo DESC) AS RowNum\n" +
                    "    FROM\n" +
                    "        libro\n" +
                    "    JOIN\n" +
                    "        alquiler ON libro.codigo = alquiler.codigoLibro\n" +
                    "    WHERE\n" +
                    "        alquiler.fechaDevolucion IS NULL)\n" +
                    "SELECT\n" +
                    "    codigo,\n" +
                    "    titulo,\n" +
                    "    autor,\n" +
                    "    fechaPrestamo\n" +
                    "FROM\n" +
                    "    LibrosAlquilados\n" +
                    "WHERE\n" +
                    "    RowNum = 1;");
            ResultSet rs = ps.executeQuery();

            ArrayList<Libro> listaAlquilados = new ArrayList<Libro>();
            while (rs.next()) {
                listaAlquilados.add(new Libro(Integer.parseInt(rs.getString("codigo")), rs.getString("titulo"),
                        rs.getString("autor"), rs.getDate("fechaPrestamo")));
            }

            return listaAlquilados;

        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
            return new ArrayList<Libro>();
        }
    }

    /**
     *
     * @param codigoLibro
     * @return true si el libro está disponible para alquilar o false si no lo está
     * @throws SQLException
     */
    public boolean verificarDisponibilidad(int codigoLibro) throws SQLException {
        // Consulta para verificar la disponibilidad del libro
        String consulta = "SELECT fechadevolucion FROM alquiler WHERE codigolibro = ? AND fechadevolucion IS NULL ORDER BY fechaprestamo DESC LIMIT 1";

        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setInt(1, codigoLibro);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return !resultSet.next();
            }
        }
    }

    /**
     * Actualiza la table de libros alquilados
     * @param codigoLibro
     * @param dniSocio
     */
    public void actualizarTablaAlquiler(int codigoLibro, String dniSocio) {

        String consulta = "INSERT INTO alquiler (codigolibro, DNI, fechaprestamo) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setInt(1, codigoLibro);
            preparedStatement.setString(2, dniSocio);
            preparedStatement.setDate(3, java.sql.Date.valueOf(fechaHoy));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    /**
     * Devuelve un libro, por lo que vuelve a estar disponible
     * @param codigoLibro
     */
    public void devolverLibro(int codigoLibro) {


        // Consulta para actualizar la fecha de devolución en la tabla alquiler
        String consulta = "UPDATE alquiler SET fechadevolucion = ? WHERE codigolibro = ? AND fechadevolucion IS NULL";

        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(fechaHoy));
            preparedStatement.setInt(2, codigoLibro);

            // Ejecutar la actualización
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Libro devuelto con éxito.");
            } else {

                System.out.println("No se pudo devolver el libro. Puede que el libro no esté actualmente alquilado o ya haya sido devuelto.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}


