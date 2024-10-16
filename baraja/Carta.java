package baraja;

import java.util.ArrayList;

public class Carta {
    private String palo;
    private int valor;
    private Jugador jugador;

    // Simbolos para los palos
    private static final String[] PALOS = {"♥", "♦", "♣", "♠"};

    public Carta(String palo, int valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    // Devuelve la representación del valor como texto
    private String valorComoTexto() {
        switch (valor) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(valor);
        }
    }

    // Método para representar la carta en formato ASCII
    public String mostrarCarta() {
        String valorTexto = valorComoTexto();
        String paloSimbolo = "";

        // Asigna el símbolo correcto para el palo
        switch (palo) {
            case "oros":
                paloSimbolo = "♦";
                break;
            case "copas":
                paloSimbolo = "♥";
                break;
            case "espadas":
                paloSimbolo = "♠";
                break;
            case "bastos":
                paloSimbolo = "♣";
                break;
        }

        return "+--------+\n" +
               "| " + valorTexto + "      |\n" +
               "|        |\n" +
               "|   " + paloSimbolo + "    |\n" +
               "|        |\n" +
               "|      " + valorTexto + " |\n" +
               "+--------+";
    }

    @Override
    public String toString(){
        switch (valor) {
            case 1:
                return "A de " + palo;
            case 11:
                return "J de " + palo;
            case 12:
                return "Q de "+ palo;
            case 13:
                return "K de" + palo;
            default:
                return valor + " de " + palo;
        }
    }
}
