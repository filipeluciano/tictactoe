package com.games.tictactoe;

import java.util.Scanner;

public class Console {

	private static char[][] board = new char[3][3];
	private static int player;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		play(new Game(3));
	}

	/**
	 * Execute the game with simple steps.
	 */
	public static void play(Game game) {
		
		player = 1;
		
		boolean playing = true;
		int col, row;
		
		printInstructions();
		printBoard();

		while (playing) {

			System.out.println("Player " + player + " is your turn!");

			try {
				//If a input was already marked, ask again...
				do {
					
					System.out.println("Enter a valid row number: ");
					row = input.nextInt();
					System.out.println("Enter a valid column number: ");
					col = input.nextInt();
					
				} while ((board[row][col] == 'X') || (board[row][col] == 'O'));
				
				board[row][col] = (player == 1) ? 'X' : 'O';

				int result = game.move(player, row, col);

				if (result != 0) {
					playing = false;
					if (result == 3)
						System.err.println("It's a draw!");
					else
						System.out.println("Game over! Player " + player + " wins!");
				}

				printBoard();
				//change turn
				player = (player == 1) ? 2 : 1;

			
			 //Handle with a invalid inputs.
			} catch (Exception e) {
				playing = false;
				System.out.println("Sorry, no tic tac toe for you!");
			}
		}
	}

	/**
	 * Print the board changing available places to references
	 */
	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					System.out.print("| ");
				if ((board[i][j] != 'X') && (board[i][j] != 'O'))
					System.out.print(i + "," + j + " | ");
				else
					System.out.print(" " + board[i][j] + "  | ");
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Print simple instructions to the user
	 */
	public static void printInstructions() {
		System.out.println("Welcome to tic-tac-toe.\n"
				+ "Mark a cell by choosing the row and the column number.\n"
				+ "Have fun!");
	}

}