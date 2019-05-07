import java.util.Scanner;

public class Board {

    String gameB[][];
    //metodo constructor que recibe la matriz de parte del juego
    public Board(String [][]mBoard){
        gameB = mBoard;

    }



    public void drawBoard(){
        //aqui dibujamos la matriz en la consola de salida
        //antes de trabajar la matriz procedemos a dibujar una plantilla de guia del eje X
        System.out.println(" a b c");
        for (int x=0; x<5; x++){
            if(x==0){
                //antes de dibujar una linea de la matriz nos aseguramos de que si requiere una nueva linea y guia en caso de requerir guia imprimimos el numero de su linea caso contrario imprimimos un " "
                System.out.print("1");
            }
            if(x==1){
                System.out.print(" ");
            }
            if(x==2){
                System.out.print("2");
            }
            if(x==3){
                System.out.print(" ");
            }
            if(x==4){
                System.out.print("3");
            }
            for (int y=0; y<5 ;y++){
                //una vez impresa la guia del eje y pasamos a imprimir la linea correspondiente sin cambiar de linea usando solo print
                System.out.print(gameB[x][y]);
            }
            //antes de salir del ciclo for imprimimos una ultima linea para dar un espacio vertical
            System.out.println(" ");

        }

    }
    //Declaro la matriz de trabajo y lo hago afuera de los metodos para que cualquier cambio en la matriz sea guardado para su uso por multiples metodos
    String [][] corD={{" ", " ", " "},
                      {" ", " ", " "},
                      {" ", " ", " "}};

    public Boolean Gano(String [][]matC){
        //Si alguien tiene una mejor idea para implementar este metodo pero aqui verifico todas las posibles combinaciones de casillas llenas que llevarian a una victoria
        if (matC[0][0].equals("X") && matC[0][1].equals("X") && matC[0][2].equals("X")){
            System.out.println("Gano X Linea horizontal superior");
            return true;
        }else if(matC[1][0].equals("X") && matC[1][1].equals("X") && matC[1][2].equals("X")){
            System.out.println("Gano X Linea horizontal media");
            return true;
        }else if(matC[2][0].equals("X") && matC[2][1].equals("X") && matC[2][2].equals("X")){
            System.out.println("Gano X Linea horizontal baja");
            return true;
        }else if (matC[0][0].equals("X") && matC[1][0].equals("X") && matC[2][0].equals("X")){
            System.out.println("Gano X Linea Vertical izquierda");
            return true;
        }else if(matC[0][1].equals("X") && matC[1][1].equals("X") && matC[2][1].equals("X")){
            System.out.println("Gano X Linea Vertical media");
            return true;
        }else if(matC[0][2].equals("X") && matC[1][2].equals("X") && matC[2][2].equals("X")){
            System.out.println("Gano X Linea Vertical derecha");
            return true;
        }else if(matC[0][0].equals("X") && matC[1][1].equals("X") && matC[2][2].equals("X")){
            System.out.println("Gano X Linea Diagonal derecha");
            return true;
        }else if(matC[2][0].equals("X") && matC[1][1].equals("X") && matC[0][2].equals("X")){
            System.out.println("Gano X Linea Diagonal izquierda");
            return true;
        }else if (matC[0][0].equals("O") && matC[0][1].equals("O") && matC[0][2].equals("O")){
            System.out.println("Gano O Linea horizontal superior");
            return true;
        }else if(matC[1][0].equals("O") && matC[1][1].equals("O") && matC[1][2].equals("O")){
            System.out.println("Gano O Linea horizontal media");
            return true;
        }else if(matC[2][0].equals("O") && matC[2][1].equals("O") && matC[2][2].equals("O")){
            System.out.println("Gano O Linea horizontal baja");
            return true;
        }else if (matC[0][0].equals("O") && matC[1][0].equals("O") && matC[2][0].equals("O")){
            System.out.println("Gano O Linea Vertical izquierda");
            return true;
        }else if(matC[0][1].equals("O") && matC[1][1].equals("O") && matC[2][1].equals("O")){
            System.out.println("Gano O Linea Vertical media");
            return true;
        }else if(matC[0][2].equals("O") && matC[1][2].equals("O") && matC[2][2].equals("O")){
            System.out.println("Gano O Linea Vertical derecha");
            return true;
        }else if(matC[0][0].equals("O") && matC[1][1].equals("O") && matC[2][2].equals("O")){
            System.out.println("Gano O Linea Diagonal derecha");
            return true;
        }else if(matC[2][0].equals("O") && matC[1][1].equals("O") && matC[0][2].equals("O")){
            System.out.println("Gano O Linea Diagonal izquierda");
            return true;
        }else{
            return false;
        }
    }

    public boolean Full(String [][]matC){
        //usamos la matriz de trabajo y vemos si aun le quedan casillas vacias

        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                if(matC[x][y].equals(" ")){
                    System.out.println("Se lleno el tablero");
                    return false;

                }

            }
        }
        return true;
    }

    public void redraw(String [][]matC){
        //Este metodo esta a cargo de modificar la matriz de dibujo original con los datos de la matriz de trabajo

        //Asignar jugadas primera linea
        if(matC[0][0].equals("X")||matC[0][0].equals("O")){
            gameB[0][0] = matC[0][0];
        }
        if(matC[1][0].equals("X")||matC[1][0].equals("O")){
            gameB[2][0] = matC[1][0];
        }
        if(matC[2][0].equals("X")||matC[2][0].equals("O")){
            gameB[4][0] = matC[2][0];
        }
        //asignar jugadas segunda linea
        if(matC[0][1].equals("X")||matC[0][1].equals("O")){
            gameB[0][2] = matC[0][1];
        }
        if(matC[1][1].equals("X")||matC[1][1].equals("O")){
            gameB[2][2] = matC[1][1];
        }
        if(matC[2][1].equals("X")||matC[2][1].equals("O")){
            gameB[4][2] = matC[2][1];
        }
        //Asignar jugadas tercera linea
        if(matC[0][2].equals("X")||matC[0][2].equals("O")){
            gameB[0][4] = matC[0][2];
        }
        if(matC[1][2].equals("X")||matC[1][2].equals("O")){
            gameB[2][4] = matC[1][2];
        }
        if(matC[2][2].equals("X")||matC[2][2].equals("O")){
            gameB[4][4] = matC[2][2];
        }
        //terminado el paso de datos de las matrizes volvemos a dibujar el tablero con los nuevos valores
        drawBoard();
    }

    public void play(){
        //A partir de este punto el metodo play toma el mando y se encarga de controlar el juego
        //Re-utilizo la clase game para crear un nuevo juego y poder invocar el primer turno y el cambio de turno
        Game myGame = new Game();
        //recibimos el primer turno
        String t=myGame.assignFT();
        //variable booleanas de control
        boolean played = false;
        boolean finished = false;
        //control general mientras el juego este activo
        while (finished==false) {
            //reiniciamos el control booleano para ver si ya se a jugado
            played = false;
            while (played == false) {
                //mientras no se haya concretado la jugada esta rutina volvera a pedir coordenadas
                //iniciamos controles que nos serviran para saber si se puso una coordenada valida
                int x = 4;
                int y = 4;
                while (x == 4) {
                    //mientras el valor de la bandera siga siendo de un valor extraño se pedira la coordenada correspondiente al eje x
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Coloca la coordenada de tu jugada para eje X usa a, b o c");
                    String corx = keyboard.next();
                    //verificamos que la tecla presionada sea valida en caso de cumplirse asignamos el valor en el eje x correspondiente
                    if (corx.equals("a")) {
                        x = 0;
                    } else if (corx.equals("b")) {
                        x = 1;
                    } else if (corx.equals("c")) {
                        x = 2;
                    } else {
                        System.out.println("Posicion desconocida reintenta");
                    }

                }

                while (y == 4) {
                    //verificamos que la tecla presionada sea valida en caso de cumplirse asignamos el valor en el eje y correspondiente
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Coloca la coordenada de tu jugada para eje y usa 1, 2 o 3");
                    String cory = keyboard.next();

                    if (cory.equals("1")) {
                        y = 0;
                    } else if (cory.equals("2")) {
                        y = 1;
                    } else if (cory.equals("3")) {
                        y = 2;
                    } else {
                        System.out.println("Posicion desconocida reintenta");
                    }

                }
                //nota aqui mi codigo se a vuelto inestable y es necesario volcar los valores de la matriz para que estos queden en la posicion correcta
                //notese que ahora el eje x es el y,
                //Verificamos que la casilla este vacia
                if (corD[y][x].equals(" ")){
                    //verificamos el turno actual y marcamos con el valor X o el O en la casilla si esta esta libre y regresamos al ciclo de validacion de la jugada con un valor true
                    if (t == "X") {
                        corD[y][x] = "X";
                        played = true;

                    } else if (t == "O") {
                        corD[y][x] = "O";
                        played = true;

                    }
                }else{
                    //Si la casilla estuviera ocupada se imprimira este mensaje y volveremos al ciclo de validacion de jugada con un valor false
                    System.out.println("Casilla ocupada reintenta");
                }


            }
            //al salir del ciclo de validacion de la jugada lo primero que hacemos es si alguien alcanzo condiciones de victoria cambiando el estado finished a true pero aun no terminamos el ciclo
            finished = Gano(corD);
            //despues de validar si alguien gano o no redibujamos el tablero
            redraw(corD);
            //En caso de que alguien haya ganado pasaremos a ignorar esta condiciona y salimos del ciclo
            if(finished==false){
                //caso contrario nadie a ganado aun entonces invocamos al metodo que barrera con toda la matriz de trabajo para ver si aun hay lugares donde jugar
                finished = Full(corD);

                //si el tablero estuviera lleno el valor de finished cambiaria a true e ignorariamos esta condiciona caso contrario procederemos con la condicional para cambiar los turno
                if(finished==false) {
                    //Invocamos al game para que nos diga que turno es ahora
                    t = myGame.TurnControl(t);
                    System.out.println("Ahora es turno de " + t);
                }
            }

            //cambiar turno



        }

    }


}
