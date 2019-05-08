package main.java.DenisCamacho.task_02;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Table table = new Table();
        boolean status = false;
        boolean endGame = false;
        do {
            System.out.println("############### Welcome to play three in a row ###############\n 1 --> Start play \n " +
                    "2 --> Exit\n##############################################################");
            Scanner options = new Scanner(System.in);
            String option = options.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Select names for players and their chip 'X' or 'O' \n Select the player 1 into the name");
                    String name = options.nextLine();
                    while (name.equals("")) {
                        System.out.println("The name not is valid into the name please");
                        name = options.nextLine();
                    }
                    System.out.println("Select the chip 'X' or 'O'");
                    String chip = options.nextLine();
                    while (!chip.equals("X") && !chip.equals("O")) {
                        System.out.println("Select the chip 'X' or 'O'");
                        chip = options.nextLine();
                    }
                    Player player1 = new Player(chip, name);
                    System.out.println("Select the player 2 into the name");
                    name = options.nextLine();
                    while (name.equals("")) {
                        System.out.println("The name not is valid into the name please");
                        name = options.nextLine();
                    }
                    chip = player1.getChip().equals("X") ? "O" : "X";
                    Player player2 = new Player(chip, name);
                    System.out.println(String.format("Starting play three in a row player %s with chip %s and player %s with chip %s",
                            player1.getName(), player1.getChip(), player2.getName(), player2.getChip()));

                    while (!endGame) {
                        while (!selectFieldFile(table, player1, options)) {
                        }
                        if (table.verifyWinner(player1)) {
                            player1.updateFlagWinner();
                            System.out.println(String.format("Player %s winner %s of 3", player1.getName(), player1.getFlagWinner()));
                            table.cleaning();
                        }
                        if (table.fullTable()) {
                            table.cleaning();
                        }
                        if (player1.getFlagWinner() != 2) {
                            while (!selectFieldFile(table, player2, options)) {
                            }
                            if (table.verifyWinner(player2)) {
                                player2.updateFlagWinner();
                                System.out.println(String.format("Player %s winner %s of 3", player1.getName(), player2.getFlagWinner()));
                                table.cleaning();
                            }
                        }
                        if (table.fullTable()) {
                            table.cleaning();
                        }
                        if (player1.getFlagWinner() == 2) {
                            System.out.println(String.format("####################################\nThe player %s is" +
                                    " winner congratulation\n####################################", player1.getName()));
                            endGame = true;
                        }
                        if (player2.getFlagWinner() == 2) {
                            System.out.println(String.format("####################################\nThe player %s is" +
                                    " winner congratulation\n####################################", player2.getName()));
                            endGame = true;
                        }
                    }
                    break;
                case "2":
                    status = true;
                    break;

            }

        }
        while (!status);

    }

    private static boolean selectFieldFile(Table table, Player player, Scanner options) {
        table.printer();
        System.out.println(String.format("Select the field %s into the file and row please", player.getName()));
        System.out.println("Into the file 0 to 2");
        int file = options.nextInt();
        while (true) {
            if (file > 2) {
                System.out.println("Into the file 0 to 2");
                file = options.nextInt();
            } else break;
        }
        System.out.println("Into the row 0 to 2");
        int row = options.nextInt();
        while (true) {
            if (row > 2) {
                System.out.println("Into the row 0 to 2");
                row = options.nextInt();
            } else break;
        }
        if (table.verifyField(file, row)) {
            System.out.println(String.format("Successfully insert %s", player.getName()));
            table.insert(player, file, row);
            return true;
        } else {
            System.out.println(String.format("The field not empty %s please choose another", player.getName()));
            return false;
        }
    }
}
