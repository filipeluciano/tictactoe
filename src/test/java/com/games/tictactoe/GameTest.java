package com.games.tictactoe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GameTest extends TestCase {

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(GameTest.class);
	}

	public void testifGameIsADraw() {

		Game ttt = new Game(3);
		ttt.move(1, 1, 1);
		ttt.move(2, 0, 0);
		ttt.move(1, 0, 2);
		ttt.move(2, 2, 0);
		ttt.move(1, 1, 0);
		ttt.move(2, 1, 2);
		ttt.move(1, 2, 1);
		ttt.move(2, 0, 1);
		assertTrue(ttt.move(1, 2, 2) == 3);
	}

	public void testifPlayerWinsHorinzontally() {

		Game ttt = new Game(3);
		ttt.move(1, 0, 0);
		ttt.move(2, 1, 0);
		ttt.move(1, 0, 1);
		ttt.move(2, 1, 1);
		assertTrue(ttt.move(1, 0, 2) == 1);
	}

	public void testifPlayerWinsVertically() {

		Game ttt = new Game(3);
		ttt.move(1, 0, 0);
		ttt.move(2, 0, 1);
		ttt.move(1, 1, 0);
		ttt.move(2, 1, 1);
		ttt.move(1, 2, 2);
		assertTrue(ttt.move(2, 2, 1) == 2);
	}

	public void testifPlayrOnWinsDiag1() {

		Game ttt = new Game(3);
		ttt.move(1, 1, 1);
		ttt.move(2, 0, 2);
		ttt.move(1, 0, 0);
		ttt.move(2, 2, 0);
		assertTrue(ttt.move(1, 2, 2) == 1);

	}

	public void testifPlayrOnWinsDiag2() {

		Game ttt = new Game(3);
		ttt.move(1, 1, 1);
		ttt.move(2, 0, 0);
		ttt.move(1, 0, 2);
		ttt.move(2, 1, 0);
		assertTrue(ttt.move(1, 2, 0) == 1);

	}
}
