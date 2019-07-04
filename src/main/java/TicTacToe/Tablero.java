package TicTacToe;

public class Tablero {
    private String[][] tablero;

    public Tablero() {
        tablero = new String[3][3];
        limpiar();
    }

    public Tablero(String[][] tablero) {
        this.tablero = tablero;
    }


    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    private void limpiar() {
        for (int f = 0; f < tablero.length; f++) {
            for (int c = 0; c < tablero[0].length; c++) {
                tablero[f][c] = " ___ ";
            }
        }
    }

    public void imprimir() {
        for (String[] aTablero : tablero) {
            for (int c = 0; c < tablero[0].length; c++) {
                System.out.print(aTablero[c]);
            }
            System.out.println("");
        }
    }

    public boolean verificarGanador(Jugador jugador) {
        boolean valor = false;
        String ficha1 = "  " + jugador.getFicha().getFicha() + "  ";
        String ficha3 = ficha1 + ficha1 + ficha1;
        String fila = tablero[0][0] + tablero[0][1] + tablero[0][2];
        if (ficha3.equals(fila)) {
            valor = true;
        }
        fila = tablero[1][0] + tablero[1][1] + tablero[1][2];
        if (ficha3.equals(fila)) {
            valor = true;
        }
        fila = tablero[2][0] + tablero[2][1] + tablero[2][2];
        if (ficha3.equals(fila)) {
            valor = true;
        }
        String columna = tablero[0][0] + tablero[1][0] + tablero[2][0];
        if (ficha3.equals(columna)) {
            valor = true;
        }
        columna = tablero[0][1] + tablero[1][1] + tablero[2][1];
        if (ficha3.equals(columna)) {
            valor = true;
        }
        columna = tablero[0][2] + tablero[1][2] + tablero[2][2];
        if (ficha3.equals(columna)) {
            valor = true;
        }
        String diagonal = tablero[0][0] + tablero[1][1] + tablero[2][2];
        if (ficha3.equals(diagonal)) {
            valor = true;
        }
        diagonal = tablero[2][0] + tablero[1][1] + tablero[0][2];
        if (ficha3.equals(diagonal)) {
            valor = true;
        }
        return valor;
    }
}
