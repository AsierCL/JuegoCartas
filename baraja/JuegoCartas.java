package baraja;

public class JuegoCartas {
    public static void main(String[] args) {
        // Creamos un jugador
        Jugador jugador1 = new Jugador("Asier");

        // Creamos un mazo y lo barajamos
        Mazo mazo = new Mazo();
        mazo.barajar();

        // El jugador coge 3 cartas
        jugador1.cogerCarta(mazo.sacarCarta());
        jugador1.cogerCarta(mazo.sacarCarta());
        jugador1.cogerCarta(mazo.sacarCarta());

        // El jugador ve sus cartas
        jugador1.verMano();

        // El jugador echa una carta
        jugador1.echarCarta(1);  // Elimina la carta en el índice 1

        // El jugador vuelve a ver sus cartas
        jugador1.verMano();

        // Añadir puntos
        jugador1.añadirPuntos(10);
        System.out.println("Puntos actuales: " + jugador1.getPuntos());
    }
}
