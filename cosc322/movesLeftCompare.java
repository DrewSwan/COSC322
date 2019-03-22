package cosc322;

import java.util.ArrayList;

import cosc322.COSC322Test.GameBoard;

public class movesLeftCompare {

	static Queen[] wQueens = new Queen[4];
	static Queen[] bQueens = new Queen[4];
	
	    public int evaluateBoard(BoardGameModel board,boolean white) {

			PossibleMoves wmoves = new PossibleMoves(true);
			PossibleMoves bmoves = new PossibleMoves(false);
			
			int wsize = wmoves.PossibleMoves(board, true, wQueens, bQueens).size();
			int bsize = bmoves.PossibleMoves(board, false, wQueens, bQueens).size();

	        if (white == true)
	            return wsize - bsize;
	        else
	            return bsize - wsize;
	    }
	
}
