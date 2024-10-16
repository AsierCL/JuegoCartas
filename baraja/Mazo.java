package baraja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    // Constructor: Inicializa el mazo con las 40 cartas (Tute o Belisca)
    public Mazo() {
        cartas = new ArrayList<>();
        String[] palos = {"oros", "copas", "espadas", "bastos"};

        // Rellenar el mazo con las cartas de cada palo (As, 2-7, Sota, Caballo, Rey)
        for (String palo : palos) {
            for (int valor = 1; valor <= 12; valor++) {
                // En algunos juegos puedes omitir ciertas cartas, ajusta según necesidad.
                cartas.add(new Carta(palo, valor));
            }
        }
    }

    // Método para barajar el mazo
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Método para sacar una carta del mazo (robar)
    public Carta sacarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0); // Sacamos la primera carta del mazo
        } else {
            System.out.println("El mazo está vacío.");
            return null; // O puedes lanzar una excepción según prefieras
        }
    }

    // Método para ver cuántas cartas quedan en el mazo
    public int cartasRestantes() {
        return cartas.size();
    }
}
