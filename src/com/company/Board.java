package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }

    public boolean check() {
        if (    board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
                board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
                board[2][0] == board[2][1] && board[2][1] == board[2][2] ||

                board[0][0] == board[1][0] && board[1][0] == board[2][0] ||
                board[0][1] == board[1][1] && board[1][1] == board[2][1] ||
                board[0][2] == board[1][2] && board[1][2] == board[2][2] ||

                board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[0][2] == board[1][1] && board[1][1] == board[2][0]
        )  return true;
        return false;
    }

    public void printBoard() {
        System.out.println("---------------");
        System.out.println(" " + board[0][0] + "  |  " + board[0][1]+ "  |  " + board[0][2]);
        System.out.println(" " + board[1][0] + "  |  " + board[1][1]+ "  |  " + board[1][2]);
        System.out.println(" " + board[2][0] + "  |  " + board[2][1]+ "  |  " + board[2][2]);
        System.out.println("---------------");
    }

    public void move(char letter) {
        String move = null;
        int iMove = 0;
        boolean bln = false;

        Scanner scanner = new Scanner(System.in);

        while (!bln) {
            try {
                move = scanner.nextLine();
                iMove = Integer.parseInt(move);
                if (iMove < 1 || iMove > 9) {
                    throw new iMoveIncorrect();
                }

                switch (iMove) {
                    case 1: board[0][0] = letter;
                        break;

                    case 2: board[0][1] = letter;
                        break;

                    case 3: board[0][2] = letter;
                        break;

                    case 4: board[1][0] = letter;
                        break;

                    case 5: board[1][1] = letter;
                        break;

                    case 6: board[1][2] = letter;
                        break;

                    case 7: board[2][0] = letter;
                        break;

                    case 8: board[2][1] = letter;
                        break;

                    case 9: board[2][2] = letter;
                        break;
                }
                bln = true;

            } catch (Exception InputMismatchException) {
                System.out.println("Ошибка! Введите заново.");
                bln = false;
            } catch (Board.iMoveIncorrect iMoveIncorrect) {
                System.out.println("Ошибка! Введите заново." + "\nЧисло должно быть от 1 до 9");
                bln = false;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    private class iMoveIncorrect extends Throwable {
    }
}
