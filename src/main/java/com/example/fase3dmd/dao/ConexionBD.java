package com.example.fase3dmd.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {

    private static final String ARCHIVO_CONFIG = "/db.properties";

    public static Connection obtenerConexion() throws SQLException {
        Properties props = cargarPropiedades();
        String url = props.getProperty("db.url");
        String usuario = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, usuario, password);
    }

    private static Properties cargarPropiedades() {
        Properties props = new Properties();
        try (InputStream input = ConexionBD.class.getResourceAsStream(ARCHIVO_CONFIG)) {
            if (input == null) {
                throw new IllegalStateException(
                        "No se encontro src/main/resources/db.properties. "
                        + "Copia db.properties.example y completa tus credenciales locales.");
            }
            props.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Error leyendo db.properties", e);
        }
        return props;
    }

    public static void main(String[] args) {
        try (Connection conexion = obtenerConexion()) {
            System.out.println("Conexion exitosa a la base de datos: " + conexion.getCatalog());
        } catch (SQLException e) {
            System.err.println("Fallo la conexion: " + e.getMessage());
        }
    }
}
