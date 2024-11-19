package cliente;

import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) {
        try (
		Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Conectado al servidor en localhost:12345");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
