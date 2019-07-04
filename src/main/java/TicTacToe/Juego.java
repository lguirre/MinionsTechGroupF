package TicTacToe;

public class Juego {

    public void iniciarJuego() {
        Ficha fichaX = new Ficha("X");
        Ficha fichaO = new Ficha("O");

        Jugador jugador1 = new Jugador(fichaX);
        Jugador jugador2 = new Jugador(fichaO);

        Tablero tablero = new Tablero();
        tablero.imprimir();
        boolean ganador = false;
        int veces = 1;
        while (veces <= 9) {
            if (veces % 2 == 0) {
                jugador2.ponerFicha(tablero);
                ganador = tablero.verificarGanador(jugador2);
            } else {
                jugador1.ponerFicha(tablero);
                ganador = tablero.verificarGanador(jugador1);
            }
            tablero.imprimir();
            if (ganador) {
                break;
            }
            veces++;
        }
        if (ganador) {
            System.out.println("HAZ GANADO!!!");
        } else {
            System.out.println("VUELVE A INTENTARLO!!!");
        }
    }
}
