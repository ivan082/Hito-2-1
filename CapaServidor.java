package servidor;

import java.io.*;
import java.net.*;
import java.util.*;
import capaDatos.CapaAccesoDatos;
import capaDatos.BaseDeDatos;

public class CapaServidor extends Thread {
    private Socket socket;
    private boolean usandoBaseDeDatos;

    public CapaServidor(Socket socket, boolean usandoBaseDeDatos) {
        this.socket = socket;
        this.usandoBaseDeDatos = usandoBaseDeDatos;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String claveBusqueda = reader.readLine();
            System.out.println("Búsqueda recibida: " + claveBusqueda);

            List<String> libros;

            if (usandoBaseDeDatos) {
                BaseDeDatos baseDeDatos = new BaseDeDatos();
                libros = baseDeDatos.obtenerLibros(claveBusqueda);
            } else {
                CapaAccesoDatos capaAccesoDatos = new CapaAccesoDatos();
                libros = capaAccesoDatos.obtenerLibros(claveBusqueda);
            }

            if (libros.isEmpty()) {
                writer.println("No se encontraron libros para la búsqueda: " + claveBusqueda);
            } else {
                for (String libro : libros) {
                    writer.println(libro);
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
