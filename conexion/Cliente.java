package conexion;

import baraja.*;

import java.io.*;
import java.net.*;

public class Cliente {
    private static final String HOST = "127.0.0.1"; // Cambia esto a la IP del servidor si es necesario
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PUERTO)) {
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            // Enviar un mensaje de prueba al servidor
            salida.writeObject("Hola desde el cliente!");

            // Aquí puedes agregar más lógica del juego

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
