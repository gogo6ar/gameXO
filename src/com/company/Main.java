package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(new char[][]{
            {'1' , '2' , '3'},
            {'4' , '5' , '6'},
            {'7' , '8' , '9'}
        });

        Player player1 = new Player();
        Player player2 = new Player();

        Scanner scanner = new Scanner(System.in);
        player1.setName(scanner.nextLine());
        player2.setName(scanner.nextLine());

        player1.setLetter('X');
        player2.setLetter('O');

        printInstruction();

        while(true) {
            System.out.println(player1.getName() + ", ваша очередь");
            board.move(player1.getLetter());
            board.printBoard();
            if (board.check()) {
                System.out.println(player1.getName() + " WIN");
                System.exit(0);
            }

            System.out.println(player2.getName() + ", ваша очередь");
            board.move(player2.getLetter());
            board.printBoard();
            if (board.check()) {
                System.out.println(player2.getName() + " WIN");
                System.exit(0);
            }
        }

    }

    public static void printInstruction() {
        System.out.println("---------------");
        System.out.println(" " + "1"+ "  |  " + "2" + "  |  " + "3");
        System.out.println(" " + "4"+ "  |  " + "5" + "  |  " + "6");
        System.out.println(" " + "7"+ "  |  " + "8" + "  |  " + "9");
        System.out.println("---------------");
    }
}
