package baraja;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Runnable {
    private String nombre;
    private int puntos;
    private List<Carta> mano;
    private Socket socket;                 // Agregado para manejar la conexión del jugador
    private ObjectOutputStream salida;      // Para enviar datos al cliente
    private ObjectInputStream entrada;      // Para recibir datos del cliente

    // Constructor que acepta un nombre y un Socket
    public Jugador(String nombre, Socket socket) {
        this.nombre = nombre;
        this.socket = socket;
        this.puntos = 0;  // Inicialmente el jugador tiene 0 puntos
        this.mano = new ArrayList<>();
        
        // Inicializar flujos de salida y entrada
        try {
            if (socket != null) {
                salida = new ObjectOutputStream(socket.getOutputStream());
                entrada = new ObjectInputStream(socket.getInputStream());
            } else {
                System.out.println("El socket es nulo. No se pueden establecer los flujos.");
            }
        } catch (IOException e) {
            System.out.println("Error al inicializar flujos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Constructor adicional para crear un jugador sin socket (para usar en el servidor)
    public Jugador(String nombre) {
        this(nombre, null); // Llama al otro constructor con socket null
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Método para obtener los puntos del jugador
    public int getPuntos() {
        return puntos;
    }

    // Método para añadir puntos
    public void añadirPuntos(int puntos) {
        this.puntos += puntos;
    }

    // Método para coger una carta
    public void cogerCarta(Carta carta) {
        mano.add(carta);
        carta.setJugador(this);
        System.out.println(nombre + " ha cogido: " + carta);
    }

    // Método para echar una carta (sacarla de la mano)
    public Carta echarCarta(int indice) {
        if (indice >= 0 && indice < mano.size()) {
            return mano.remove(indice); // Se elimina y retorna la carta que ha echado
        } else {
            System.out.println("Índice inválido");
            return null;
        }
    }

    // Método para ver todas las cartas en la mano
    public void verMano() {
        System.out.println("Cartas en la mano de " + nombre + ":");
        if (mano.isEmpty()) {
            System.out.println("No tiene cartas.");
        } else {
            for (int i = 0; i < mano.size(); i++) {
                System.out.println((i + 1) + ":");
                System.out.println(mano.get(i).mostrarCarta());  // Muestra la carta en formato ASCII
            }
        }
    }

    // Método para la lógica del hilo
    @Override
    public void run() {
        // Aquí puedes implementar la lógica para manejar la comunicación del jugador con el servidor.
        try {
            // Ejemplo de recibir un mensaje del cliente
            while (entrada != null) {
                String mensaje = (String) entrada.readObject();
                System.out.println("Mensaje recibido de " + nombre + ": " + mensaje);
                // Lógica para procesar el mensaje aquí
            }
        } catch (EOFException e) {
            System.out.println("El cliente ha cerrado la conexión.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexiones
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}