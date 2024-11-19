package capaDatos;

import java.sql.*;
import java.util.*;

public class BaseDeDatos {


    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USUARIO = "root"; 
    private static final String CONTRASENA = "campusfp"; 

    public List<String> obtenerLibros(String claveBusqueda) {
        List<String> libros = new ArrayList<>();
        
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            
            String consulta = "SELECT titulo FROM libros WHERE titulo LIKE ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
                preparedStatement.setString(1, "%" + claveBusqueda + "%"); 
                
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        libros.add(rs.getString("titulo"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
            e.printStackTrace(); 
        }
        
        return libros; 
    }

   
    public static void main(String[] args) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        List<String> libros = baseDeDatos.obtenerLibros("java");
        System.out.println("Libros encontrados:");
        for (String libro : libros) {
            System.out.println(libro);
        }
    }
}
