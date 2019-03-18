package cosc322;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ygraphs.ai.smart_fox.GameMessage;
import ygraphs.ai.smart_fox.games.AmazonsGameMessage;
import ygraphs.ai.smart_fox.games.GameClient;
import ygraphs.ai.smart_fox.games.GameModel;
import ygraphs.ai.smart_fox.games.GamePlayer;

public class MoveDetection {
	
	// auto indent: Ctrl + Shift + F
	
	//detect the possible movement for a single queen or an single arrow 
	private ArrayList avaMove = null;

	public static void main(String[] args) {

		System.out.println();

	}

	public MoveDetection(BoardGameModel gameBoard, int target[]) {
		//String[][] board = new BoardGameModel().getBoard();
		String[][] boardState = gameBoard.getBoard();
		int targetRow = 0;
		int targetCol = 0;
		// int[] queenNewPos = null;


		// go left
		for (int i = targetCol; i >0; i--) {
			if (boardState[targetRow][targetCol - i].contentEquals("available")) {
				avaMove.add(new int[] { targetRow, i-1 });
			}else {
				break;
			}

		}

		// go right
		for (int i = targetCol; i < 9; i++) {
			if (boardState[targetRow][targetCol +i].contentEquals("available")) {
				avaMove.add(new int[] { targetRow, i+1 });
			}else {
				break;
			}


		}
		
		// go down
		for (int i = targetRow; i > 0; i--) {
			if (boardState[i-1][targetRow].contentEquals("available")) {
				avaMove.add(new int[] { i-1, targetCol });
			}
		}

		// go up
		for (int i = targetRow; i < 9; i++) {
			if (boardState[ i + 1][targetRow].contentEquals("available")) {
				avaMove.add(new int[] { i+1, targetCol });
			}else {
				break;
			}
		}
		
		//Diagonal right up
		
		for (int i = 1; targetRow + i <= 9 && targetCol + i <=9; i++) {
			if (boardState[targetRow + i ][targetCol + i].contentEquals("available")) {
				avaMove.add(new int[] { targetRow + i, targetCol + i });
			}else {
				break;
			}
		}
			
				//Diagonal left up	
				for (int i = 1; targetRow + i <= 9 && targetCol - i >=0; i++) {
					if (boardState[targetRow + i ][targetCol - i].contentEquals("available")) {
						avaMove.add(new int[] { targetRow + i , targetCol - i });
					}else {
						break;
					}
				}
				
				//Diagonal left down		
				for (int i = 1; targetRow - i >=0 && targetCol - i >=0; i++) {
					if (boardState[targetRow - i ][targetCol - i].contentEquals("available")) {
						avaMove.add(new int[] { targetRow - i , targetCol - i });
					}else {
						break;
					}
				}
				
				//Diagonal right down		
				for (int i = 1; targetRow - i >=0 && targetCol + i <=9; i++) {
					if (boardState[targetRow - i ][targetCol + i].contentEquals("available")) {
						avaMove.add(new int[] { targetRow - i , targetCol + i });
					}else {
						break;
					}
				}
				
				

	}
	public ArrayList getAvaMove() {
		return avaMove;
	}
	
	
}
