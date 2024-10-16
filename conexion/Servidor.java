package conexion;

import baraja.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    private static final int PUERTO = 12345;
    private static List<Jugador> jugadores = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);
            while (true) {
                Socket socket = serverSocket.accept();
                Jugador jugador = new Jugador("Asier",socket);
                jugadores.add(jugador);
                new Thread(jugador).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
