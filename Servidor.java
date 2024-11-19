package servidor;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor escuchando en el puerto 12345...");
            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress());
              
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
