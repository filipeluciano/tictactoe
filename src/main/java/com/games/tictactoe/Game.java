package com.games.tictactoe;

public class Game {

	private int n;
	private int count;
	private int[] rows;
	private int[] cols;
	private int diag1;
	private int diag2;

	public Game(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
		diag1 = 0;
		diag2 = 0;
		count = 0;
	}

	/**
	 * Execute a move in the game and returns the player that wins, 3 for a draw or 0 for keeping the game.
	 * @param player
	 * @param row
	 * @param col
	 * @return
	 */
	public int move(int player, int row, int col) {
		
		count++;
		
		int position = 0;
		
		if (player == 1)
			position = 1;
		else
			position = -1;

		rows[row] += position;
		cols[col] += position;

		if (row == col)
			diag1 += position;

		if (col == n - row - 1)
			diag2 += position;

		if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n)
			return player;
		
		if (count >= Math.pow(n, 2)) return 3;

		return 0;
	}

}
