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
    if (!white) {
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
      
      while (board[start[(0 - x)]][start[1]].toString() == "available")
      {

        while (board[start[(0 - x - a)]][start[1]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x - a)], start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0 - x + a)]][start[1]] == board[start[0]][start[1]]) || (board[start[(0 - x + a)]][start[1]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x + a)], start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x - a)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x + a)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x + a)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[1], start[(0 - x - a)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[0]][start[(1 + x)]].toString() == "available")
      {
        while (board[start[(0 - a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 - a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[0]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[0], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 + a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[0]][start[(1 + x - a)]] == board[start[0]][start[1]]) || (board[start[0]][start[(1 + x - a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[0], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 - a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 + a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 + a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - a)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 + x)], start[(0 - a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[(0 + x)]][start[1]].toString() == "available")
      {
        while ((board[start[(0 + x - a)]][start[1]] == board[start[0]][start[1]]) || (board[start[(0 + x - a)]][start[1]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x - a)], start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[1]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x + a)], start[1]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x - a)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x - a)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x + a)], start[(1 + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x + a)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x - a)]][start[(1 - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[1], start[(0 + x - a)], start[(1 - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[0]][start[(1 - x)]].toString() == "available")
      {
        while (board[start[(0 - a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 - a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[0]][start[(1 - x + a)]] == board[start[0]][start[1]]) || (board[start[0]][start[(1 + x + a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[0], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 + a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[0]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[0], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - a)]][start[(1 - x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 - a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 - x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 + a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 + a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[0], start[(1 - x)], start[(0 - a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[(0 - x)]][start[(1 + x)]].toString() == "available")
      {
        while (board[start[(0 - x - a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x - a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x + a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x - a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x + a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0 - x + a)]][start[(1 + x - a)]] == board[start[0]][start[1]]) || (board[start[(0 - x + a)]][start[(1 + x - a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x + a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 + x)], start[(0 - x - a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[(0 + x)]][start[(1 + x)]].toString() == "available")
      {
        while (board[start[(0 + x - a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x - a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 + x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x + a)], start[(1 + x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x - a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x - a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x + a)], start[(1 + x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 + x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x + a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0 + x - a)]][start[(1 + x - a)]] == board[start[0]][start[1]]) || (board[start[(0 + x - a)]][start[(1 + x - a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 + x)], start[(0 + x - a)], start[(1 + x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[(0 + x)]][start[(1 - x)]].toString() == "available")
      {
        while (board[start[(0 + x - a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x - a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x + a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0 + x - a)]][start[(1 - x + a)]] == board[start[0]][start[1]]) || (board[start[(0 + x - a)]][start[(1 - x + a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x - a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 - x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x + a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x + a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x + a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 + x - a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 + x)], start[(1 - x)], start[(0 + x - a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
      x = 1;
      
      while (board[start[(0 - x)]][start[(1 - x)]].toString() == "available")
      {
        while (board[start[(0 - x - a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x - a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 + x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 - x)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x + a)], start[(1 - x)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 - x + a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x - a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while ((board[start[(0 - x + a)]][start[(1 - x + a)]] == board[start[0]][start[1]]) || (board[start[(0 - x + a)]][start[(1 - x + a)]].toString() == "available")) {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x + a)], start[(1 - x + a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x + a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x + a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        
        while (board[start[(0 - x - a)]][start[(1 - x - a)]].toString() == "available") {
          current = new move(start[0], start[1], start[(0 - x)], start[(1 - x)], start[(0 - x - a)], start[(1 - x - a)]);
          list.add(current);
          
          a++;
        }
        a = 1;
        x++;
      }
    }
    

    return list;
  }
}