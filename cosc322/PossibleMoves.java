package cosc322;

import java.io.PrintStream;
import java.util.ArrayList;

public class PossibleMoves
  extends BoardGameModel
{
  public ArrayList<move> movelist;
  private String[][] board = new String[10][10];
  private boolean white = false;
  Queen[] wQueens;
  Queen[] bQueens;
  
  public PossibleMoves(BoardGameModel curBoard)
  {
    board = curBoard.getBoard();
    white = curBoard.getWhiteTurn();
    wQueens = curBoard.getWhiteQueens();
    bQueens = curBoard.getBlackQueens();
  }
  
  public ArrayList<move> moveGeneration()
  {
    if (white == true) {
      movelist = getMoves(wQueens);
    }
    else {
      movelist = getMoves(bQueens);
    }
    return movelist;
  }
  

  private ArrayList<move> getMoves(Queen[] Queens)
  {
    ArrayList<move> list = new ArrayList();
    int x = 1;
    int a = 1;
    
    move current = new move(0, 0, 0, 0);
    

    for (int i = 0; i < 4; i++) {
      int[] start = Queens[i].getPosition();
      //Left
      while (start[(0)] - x >= 0 && board[start[(0)] - x][start[1]].toString().equalsIgnoreCase("available"))
      {

        while ( (start[(0)] - x - a >= 0) && (board[start[(0)] - x - a][start[1]].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ( (start[(1)] + a <= 9) && (board[start[(0)] - x][start[(1)] + a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a <= 9 && ((board[start[(0)] - x + a][start[1]] == board[start[0]][start[1]]) || (board[start[(0)] - x + a][start[1]].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] - a >= 0 && board[start[(0)] - x][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a >= 0 && start[(1)] + a <= 9 && board[start[(0)] - x - a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a <= 9 && start[(1)] + a <= 9 && board[start[(0)] - x + a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a <= 9 && start[(1)] - a >= 0 && board[start[(0)] - x + a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a >= 0 && start[(1)] - a >= 0 && board[start[(0)] - x - a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of left
      x = 1;
      //UP
      while ((start[(1)] + x <= 9) && board[start[0]][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] - a >= 0 && board[start[(0)] - a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x + a <= 9 && board[start[0]][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[0], start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a <= 9 && board[start[(0)] + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((start[(1)] + x - a >= 0) && ((board[start[0]][start[(1)] + x - a] == board[start[0]][start[1]]) || (board[start[0]][start[(1)] + x - a].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[0], start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - a >= 0 && start[(1)] + x + a <= 9 && board[start[(0)] - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a <= 9 && start[(1)] + x + a <= 9 && board[start[(0)] + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a <= 9 && start[(1)] + x - a >= 0 && board[start[(0)] + a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - a >= 0 && start[(1)] + x - a >= 0 && board[start[(0)] - a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of up
      x = 1;
      //Right
      while (start[(0)] + x <= 9 && board[start[(0)] + x][start[1]].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] + x - a >= 0 && (board[start[(0)] + x - a][start[1]] == board[start[0]][start[1]] || (board[start[(0)] + x - a][start[1]].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((start[(1)] + a <= 9) && board[start[(0)] + x][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a <= 9 && board[start[(0)] + x + a][start[1]].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] - a >= 0 && board[start[(0)] + x][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
  
        while (start[(0)] + x - a  >= 0 && start[(1)] + a  <= 9 && board[start[(0)] + x - a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && start[(1)] + a  <= 9 && board[start[(0)] + x + a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a <= 9 && start[(1)] - a  >= 0 && board[start[(0)] + x + a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x - a  >= 0 && start[(1)] - a  >= 0 && board[start[(0)] + x - a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//end of right
      x = 1;
      //Down
      while (start[(1)] - x >= 0 && board[start[0]][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] - a >= 0 && board[start[(0)] - a] [start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((start[(1)] - x + a  <= 9) && ((board[start[0]][start[(1)] - x + a] == board[start[0]][start[1]]) || (board[start[0]][start[(1)] + x + a].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[0], start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a  <= 9 && board[start[(0)] + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((start[(1)] - x - a >= 0) && board[start[0]][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[0], start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - a  >= 0 && start[(1)] - x + a  <= 9 && board[start[(0)] - a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a  <= 9 && start[(1)] - x + a  <= 9 && board[start[(0)] + a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + a  <= 9 && start[(1)] - x - a  >= 0 && board[start[(0)] + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - a  >= 0 && start[(1)] - x - a  >= 0 && board[start[(0)] - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of down
      x = 1;
      //UPLEFT
      while (start[(0)] - x >= 0 && start[(1)] + x <= 9 && board[start[(0)] - x][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] - x - a  >= 0 && board[start[(0)] - x - a ][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x + a <= 9 && board[start[(0)] - x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a  <= 9 && board[start[(0)] - x + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x - a  >= 0 && board[start[(0)] - x][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a  >= 0 && start[(1)] + x + a  <= 9 && board[start[(0)] - x - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a  <= 9 && start[(1)] + x + a  <= 9 && board[start[(0)] - x + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((start[(0)] - x + a  <= 9 && start[(1)] + x - a  >= 0 && (board[start[(0)] - x + a][start[(1)] + x - a] == board[start[0]][start[1]] || board[start[(0)] - x + a][start[(1)] + x - a].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a  >= 0 && start[(1)] + x - a  >= 0 && board[start[(0)] - x - a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of up left
      x = 1;
      //UPRIGHT
      while (start[(0)] + x <= 9 && start[(1)] + x <= 9 && board[start[(0)] + x][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] + x - a >= 0 && board[start[(0)] + x - a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x + a  <= 9 && board[start[(0)] + x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && board[start[(0)] + x + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x - a  >= 0 && board[start[(0)] + x][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x - a  >= 0 && start[(1)] + x + a  <= 9 && board[start[(0)] + x - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && start[(1)] + x + a  <= 9 && board[start[(0)] + x + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && start[(1)] + x - a  >= 0 && board[start[(0)] + x + a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x - a  >= 0 && start[(1)] + x - a  >= 0 && (board[start[(0)] + x - a][start[(1)] + x - a] == board[start[0]][start[1]] || board[start[(0)] + x - a][start[(1)] + x - a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of upright
      x = 1;
      //Downright
      while (start[(0)] + x <= 9 && start[(1)] - x >= 0 && board[start[(0)] + x][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] + x - a  >= 0 && board[start[(0)] + x - a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x + a <= 9 && board[start[(0)] + x][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && board[start[(0)] + x + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] - x - a  >= 0 && board[start[(0)] + x][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x - a  >= 0 && start[(1)] - x + a  <= 9 && (board[start[(0)] + x - a][start[(1)] - x + a] == board[start[0]][start[1]] || (board[start[(0)] + x - a][start[(1)] - x + a].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <=9 && start[(1)] - x + a <= 9 && board[start[(0)] + x + a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x + a  <= 9 && start[(1)] - x - a  >= 0 && board[start[(0)] + x + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] + x - a  >= 0 && start[(1)] - x - a  >= 0 && board[start[(0)] + x - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of downright
      x = 1;
      //DOWNLEFT
      while (start[(0)] - x >= 0 && start[(1)] - x >= 0 && board[start[(0)] - x][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (start[(0)] - x - a  >= 0 && board[start[(0)] - x - a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] + x + a  <= 9 && board[start[(0)] - x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a  <= 9 && board[start[(0)] - x + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(1)] - x - a  >= 0 && board[start[(0)] - x][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a  >= 0 && start[(1)] - x + a  <= 9 && board[start[(0)] - x - a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a  <= 9 && start[(1)] - x + a  <= 9 && (board[start[(0)] - x + a][start[(1)] - x + a] == board[start[0]][start[1]] || (board[start[(0)] - x + a][start[(1)] - x + a].toString().equalsIgnoreCase("available")))) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x + a  <= 9 && start[(1)] - x - a  >= 0 && board[start[(0)] - x + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (start[(0)] - x - a  >= 0 && start[(1)] - x - a  >= 0 && board[start[(0)] - x - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x - a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of downright
    }//End of check
    

    return list;
  }
}