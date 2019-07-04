package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jugador {
    private Ficha ficha;

    public Jugador(Ficha ficha) {
        this.ficha = ficha;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero){
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
            System.out.println("Turno jugador: " + this.getFicha().getFicha());
            System.out.print("Numero Fila   : ");
            int fila = Integer.parseInt(br.readLine());
            System.out.print("Numero Columna: ");
            int columna = Integer.parseInt(br.readLine());
            tablero.getTablero()[fila][columna] = "  "+this.ficha.getFicha()+" 0 ";
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
