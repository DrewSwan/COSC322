/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import ygraphs.ai.smart_fox.games.GameModel;

/**
 *
 * @author drews
 */
public class BoardGameModel extends GameModel{
    
    public static final String POS_MARKED_BLACK = "black";
    public static final String POS_MARKED_WHITE = "white";
    public static final String POS_MARKED_ARROW = "arrow";
    public static final String POS_AVAILABLE = "available";
    
    int[] pos;
    
    int movedQueenPreviousX;
    int movedQueenPreviousY;
    int movedQueenNowX;
    int movedQueenNowY;
    int firedArrowX;
    int firedArrowY;
    
    //wQueens contains the objects for each of the white queens, bQueens does the same for black queens.
    Queen[] wQueens = new Queen[4];
    Queen[] bQueens = new Queen[4];
    
    //Is it white's turn?
    private boolean whiteTurn;
    
    //How favourable is the boardstate?
    int evaluation = 0;
    
    private String[][] board = new String[10][10];
    
    //Cr`eates Initial Board State
    public BoardGameModel(){
        
        whiteTurn = true;
        
        wQueens[0] = new Queen(new int[]{0,3});
        wQueens[1] = new Queen(new int[]{0,6});
        wQueens[2] = new Queen(new int[]{2,0});
        wQueens[3] = new Queen(new int[]{2,9});
        
        bQueens[0] = new Queen(new int[]{7,0});
        bQueens[1] = new Queen(new int[]{7,9});
        bQueens[2] = new Queen(new int[]{9,3});
        bQueens[3] = new Queen(new int[]{9,6});
        
        for(int i = 0; i < 4; i++){
            pos = wQueens[i].getPosition();
            board[pos[0]][pos[1]] = POS_MARKED_WHITE;
            
            pos = bQueens[i].getPosition();
            board[pos[0]][pos[1]] = POS_MARKED_BLACK;
        }
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(board[i][j] == null){
                    board[i][j] = POS_AVAILABLE;
                }
            }
        }
        
    }
    
    //Creates board state given the previous board state, the coordiantes of the queen just moved, the new coordinates of the queen just moved and the coordinates of the just-fired arrow.
    public BoardGameModel(BoardGameModel prev, int qPrevX, int qPrevY, int qNowX,  int qNowY, int arrowX, int arrowY){
        board = prev.getBoard();
        whiteTurn = !prev.getWhiteTurn();
        wQueens = prev.getWhiteQueens();
        bQueens = prev.getBlackQueens();
        
        int[] activeQueen;
        
        if(whiteTurn == true){
            for(int i = 0; i < 4; i++){
                activeQueen = wQueens[i].getPosition();
                if(activeQueen[0] == qPrevX && activeQueen[1] == qPrevY){
                    wQueens[i] = new Queen(new int[]{qNowX, qNowY});
                    break;
                }
            }
        }else{
             for(int i = 0; i < 4; i++){
                activeQueen = bQueens[i].getPosition();
                if(activeQueen[0] == qPrevX && activeQueen[1] == qPrevY){
                    bQueens[i] = new Queen(new int[]{qNowX, qNowY});
                    break;
                }
            }
        }
        
        board[qPrevX][qPrevY] = POS_AVAILABLE;
        board[arrowX][arrowY] = POS_MARKED_ARROW;
        
        movedQueenPreviousX = qPrevX;
        movedQueenPreviousY = qPrevY;
        movedQueenNowX = qNowX;
        movedQueenNowY = qNowY;
        firedArrowX = arrowX;
        firedArrowY = arrowY;
    }
    
    public boolean positionMarked(int row, int column, int arow, int acol, int qfr, int qfc, boolean opponentMove){
    		boolean valid = true;
    		
     
    		
    		if(row >= board.length | column >= board.length 
    				 || row <= 0 || column <= 0){
    			valid = false;
    		}
    		else if (!board[row][column].equalsIgnoreCase(POS_AVAILABLE)){
    			valid = false;
    		}
            
    		if(valid){
    			board[row][column] = board[qfr][qfc];		
    			board[qfr][qfc] = POS_AVAILABLE;		
    			board[arow][acol] = POS_MARKED_ARROW;
    		}
    		
    		//System.out.println(this.toString());
    		
    		return valid;
    	}	
    
    public String toString(String[][] gameBoard){
          String b = null;

          for(int i = 1; i < 11; i++){
    	      for(int j = 1; j< 11; j++){
    		b = b + gameBoard[i][j] + " ";
    	      }
    	      b = b + "\n";
          }  	  
          return b;
        }
    
    public String[][] getBoard(){
        return this.board;
    }
    
    public boolean getWhiteTurn(){
        return whiteTurn;
    }
    
    public Queen[] getWhiteQueens(){
        return wQueens;
    }
    
    public Queen[] getBlackQueens(){
        return bQueens;
    }
    
    public int getEvaluation(){
        return evaluation;
    }
    
}