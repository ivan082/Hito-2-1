package capaDatos;

import java.io.*;
import java.util.*;

public class CapaAccesoDatos {

    public List<String> obtenerLibros(String claveBusqueda) {
        List<String> libros = new ArrayList<>();
        String archivo = "libros.txt"; 
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(claveBusqueda.toLowerCase())) {
                    libros.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }

        return libros; 
    }
}
