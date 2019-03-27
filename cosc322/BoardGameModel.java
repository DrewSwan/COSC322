/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ygraphs.ai.smart_fox.games.GameModel;

/**
 *
 * @author drews
 */
public class BoardGameModel extends GameModel {

	public static final String POS_MARKED_BLACK = "black";
	public static final String POS_MARKED_WHITE = "white";
	public static final String POS_MARKED_ARROW = "arrow";
	public static final String POS_AVAILABLE = "available";
	int[] pos;
	ArrayList<move> childMoves;

	int movedQueenPreviousX;
	int movedQueenPreviousY;
	int movedQueenNowX;
	int movedQueenNowY;
	int firedArrowX;
	int firedArrowY;

	// wQueens contains the objects for each of the white queens, bQueens does the
	// same for black queens.
	Queen[] wQueens = new Queen[4];
	Queen[] bQueens = new Queen[4];

	// Is it white's turn?
    boolean whiteTurn;

	// How favourable is the boardstate?
	int evaluation = 0;

	private String[][] board = new String[10][10];

	// Cr`eates Initial Board State
	public BoardGameModel() {

		whiteTurn = true;

		wQueens[0] = new Queen(new int[] { 0, 3 });
		wQueens[1] = new Queen(new int[] { 0, 6 });
		wQueens[2] = new Queen(new int[] { 3, 0 });
		wQueens[3] = new Queen(new int[] { 3, 9 });

		bQueens[0] = new Queen(new int[] { 6, 0 });
		bQueens[1] = new Queen(new int[] { 6, 9 });
		bQueens[2] = new Queen(new int[] { 9, 3 });
		bQueens[3] = new Queen(new int[] { 9, 6 });

		for (int i = 0; i < 4; i++) {
			pos = wQueens[i].getPosition();
			board[pos[0]][pos[1]] = POS_MARKED_WHITE;

			pos = bQueens[i].getPosition();
			board[pos[0]][pos[1]] = POS_MARKED_BLACK;
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == null) {
					board[i][j] = POS_AVAILABLE;
				}
			}
		}

	}

	// Creates board state given the previous board state, the coordiantes of the
	// queen just moved, the new coordinates of the queen just moved and the
	// coordinates of the just-fired arrow.
	public BoardGameModel(BoardGameModel prev, int qPrevX, int qPrevY, int qNowX, int qNowY, int arrowX, int arrowY) {
		board = new String[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				board[i][j] = prev.getBoard()[i][j];
			}
		}
		whiteTurn = prev.getWhiteTurn();

		// System.out.println("PrevX " + qPrevX + ", PrevY " + qPrevY + ", NowX " +
		// qNowX + ", NowY " + qNowY);

		Queen[] prevWQueens = prev.getWhiteQueens();
		Queen[] prevBQueens = prev.getBlackQueens();

		for (int i = 0; i < 4; i++) {
			wQueens[i] = new Queen(prevWQueens[i].getPosition());
			bQueens[i] = new Queen(prevBQueens[i].getPosition());
		}

		int[] activeQueen;

		if (whiteTurn == true) {
			for (int i = 0; i < 4; i++) {
				activeQueen = wQueens[i].getPosition();
				// System.out.println(activeQueen[0]+":"+qPrevX+","+activeQueen[1]+":"+qPrevY);
				if (activeQueen[0] == qPrevX && activeQueen[1] == qPrevY) {
					wQueens[i] = new Queen(new int[] { qNowX, qNowY });
					//System.out.println("correct white, qNowX: " + wQueens[i].getPosition()[0] + ", qNowY: "
						//	+ wQueens[i].getPosition()[1]);
					break;
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				activeQueen = bQueens[i].getPosition();
				// System.out.println("black");
				if (activeQueen[0] == qPrevX && activeQueen[1] == qPrevY) {
					bQueens[i] = new Queen(new int[] { qNowX, qNowY });
					System.out.println("correct black , qNowX: " + bQueens[i].getPosition()[0] + ", qNowY: "
							+ bQueens[i].getPosition()[1]);
					break;
				}
			}
		}

		board[qPrevX][qPrevY] = POS_AVAILABLE;
		board[arrowX][arrowY] = POS_MARKED_ARROW;
		if (whiteTurn = true) {
			board[qNowX][qNowY] = POS_MARKED_WHITE;
		} else {
			board[qNowX][qNowY] = POS_MARKED_BLACK;
		}
		// System.out.println("WHITE Q:
		// "+wQueens[0].getPosition()[0]+","+wQueens[0].getPosition()[1]+","+wQueens[1].getPosition()[0]+","+wQueens[1].getPosition()[1]+","+wQueens[2].getPosition()[0]+","+wQueens[2].getPosition()[1]+","+wQueens[3].getPosition()[0]+","+wQueens[3].getPosition()[1]+",");
		movedQueenPreviousX = qPrevX;
		movedQueenPreviousY = qPrevY;
		movedQueenNowX = qNowX;
		movedQueenNowY = qNowY;
		firedArrowX = arrowX;
		firedArrowY = arrowY;
	}

	public boolean positionMarked(int row, int column, int arow, int acol, int qfr, int qfc, boolean opponentMove) {
		boolean valid = true;

		if (row >= board.length | column >= board.length || row <= 0 || column <= 0) {
			valid = false;
		} else if (!board[row][column].equalsIgnoreCase(POS_AVAILABLE)) {
			valid = false;
		}

		if (valid) {
			board[row][column] = board[qfr][qfc];
			board[qfr][qfc] = POS_AVAILABLE;
			board[arow][acol] = POS_MARKED_ARROW;
		}

		// System.out.println(this.toString());

		return valid;
	}

	public String toString(String[][] gameBoard) {
		String b = null;

		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				b = b + gameBoard[i][j] + " ";
			}
			b = b + "\n";
		}
		return b;
	}

	public String[][] getBoard() {
		return this.board;
	}

	public boolean getWhiteTurn() {
		return whiteTurn;
	}

	public Queen[] getWhiteQueens() {
		return wQueens;
	}

	public Queen[] getBlackQueens() {
		return bQueens;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public int evaluate() {
		tileBWValue tbwv = new tileBWValue();
		evaluation = tbwv.eval(this);
		return evaluation;
	}

}