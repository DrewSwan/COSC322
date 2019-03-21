package cosc322;

import java.io.PrintStream;
import java.util.ArrayList;

public class PossibleMoves
  extends BoardGameModel
{
  public static ArrayList<move> movelist;
  private static String[][] board = new String[10][10];
  private static boolean white = false;
  static Queen[] wQueens = new Queen[4];
  static Queen[] bQueens = new Queen[4];
  
  public PossibleMoves(BoardGameModel curBoard, boolean white, Queen[] wQueens, Queen[] bQueens)
  {
    board = curBoard.getBoard();
    white = white;
    wQueens = wQueens;
    bQueens = bQueens;
    PossibleMoves();
    System.out.println(movelist);
  }
  
  public static void PossibleMoves()
  {
    if (white == true) {
      movelist = getMoves(wQueens);
    }
    else {
      movelist = getMoves(bQueens);
    }
  }
  

  private static ArrayList<move> getMoves(Queen[] Queens)
  {
    ArrayList<move> list = new ArrayList();
    int x = 1;
    int a = 1;
    
    move current = new move(0, 0, 0, 0);
    

    for (int i = 0; i < 4; i++) {
      int[] start = Queens[i].getPosition();
      //Left
      while ((board[start[(0)] - x] >= 0) && (board[start[(0)] - x][start[1]].toString().equalsIgnoreCase("available")))
      {

        while (board[start[(0)] - x - a] >= 0 && board[start[(0)] - x - a][start[1]].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(1)] + a] <= 9) && board[start[(0)] - x][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0)] - x + a][start[1]] == board[start[0]][start[1]]) || (board[start[(0)] - x + a][start[1]].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] + a].toString().equalsIgnoreCase("available") {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] + a].toString().equalsIgnoreCase("available") {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] - a].toString().equalsIgnoreCase("available") {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x + a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[1], start[(0)] - x - a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of left
      x = 1;
      //UP
      while (board[start[0]][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] - a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[0]][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[0], start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[0]][start[(1)] + x - a] == board[start[0]][start[1]]) || (board[start[0]][start[(1)] + x - a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[0], start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] + x, start[(0)] - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of up
      x = 1;
      //Right
      while (board[start[(0)] + x][start[1]].toString().equalsIgnoreCase("available"))
      {
        while ((board[start[(0)] + x - a][start[1]] == board[start[0]][start[1]]) || (board[start[(0)] + x - a][start[1]].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[1]].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x - a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[(1)] + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x + a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x - a][start[(1)] - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[1], start[(0)] + x - a, start[(1)] - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//end of right
      x = 1;
      //Down
      while (board[start[0]][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] - a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[0]][start[(1)] - x + a] == board[start[0]][start[1]]) || (board[start[0]][start[(1)] + x + a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[0], start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[0]][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[0], start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[0], start[(1)] - x, start[(0)] - a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of down
      x = 1;
      //UPLEFT
      while (board[start[(0)] - x][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] - x - a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0)] - x + a][start[(1)] + x - a] == board[start[0]][start[1]]) || (board[start[(0)] - x + a][start[(1)] + x - a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] + x, start[(0)] - x - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of up left
      x = 1;
      //UPRIGHT
      while (board[start[(0)] + x][start[(1)] + x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] + x - a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] + x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x - a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] + x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x + a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0)] + x - a][start[(1)] + x - a] == board[start[0]][start[1]]) || (board[start[(0)] + x - a][start[(1)] + x - a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] + x, start[(0)] + x - a, start[(1)] + x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of upright
      x = 1;
      //Downright
      while (board[start[(0)] + x][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] + x - a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0)] + x - a][start[(1)] - x + a] == board[start[0]][start[1]]) || (board[start[(0)] + x - a][start[(1)] - x + a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] + x - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] + x, start[(1)] - x, start[(0)] + x - a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }//End of downright
      x = 1;
      //DOWNLEFT
      while (board[start[(0)] - x][start[(1)] - x].toString().equalsIgnoreCase("available"))
      {
        while (board[start[(0)] - x - a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x - a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x][start[(1)] + x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] - x].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] - x + a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x - a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0)] - x + a][start[(1)] - x + a] == board[start[0]][start[1]]) || (board[start[(0)] - x + a][start[(1)] - x + a].toString().equalsIgnoreCase("available"))) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x + a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x + a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
          current = new move(start[0], start[1], start[(0)] - x, start[(1)] - x, start[(0)] - x + a, start[(1)] - x - a);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0)] - x - a][start[(1)] - x - a].toString().equalsIgnoreCase("available")) {
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