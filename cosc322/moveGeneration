package cosc322;

public class moveGeneration {
	moveGeneration(BoardGameModel gameBoard){
	
		Queen[]  wQueens =  gameBoard.getWhiteQueens();
		Queen[]  bQueens=  gameBoard.getBlackQueens();
		
		//generate the possible movement for 4 queens and arrows
		// I stuck here. My idea is every after the queen has moved by my function "MoveDetection" then update the board state, then pass 
		// the new board state to the function in order generate the possible movement for arrow.
		for(int i = 0; i < wQueens.length; i ++) {
			new MoveDetection(gameBoard,wQueens[i].getPosition());
			
		}	
		
		
		
	}
}
