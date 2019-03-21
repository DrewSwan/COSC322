
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
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import cosc322.Amazons.BoardGameModel;
//import cosc322.Amazons.GameBoard;
//import cosc322.Amazons.GameBoard.GameEventHandler;
import ygraphs.ai.smart_fox.GameMessage;
import ygraphs.ai.smart_fox.games.AmazonsGameMessage;
import ygraphs.ai.smart_fox.games.GameClient;
import ygraphs.ai.smart_fox.games.GameModel;
import ygraphs.ai.smart_fox.games.GamePlayer;


public class COSC322Test extends GamePlayer{

    private GameClient gameClient;
    private JFrame guiFrame = null;    
    private GameBoard board = null; 
    private boolean gameStarted = false;
    private String userName = null;
   static private boolean white = false;
    
 
	
    /**
     * The main method
     * @param args for name and passwd (current, any string would work)
     */
   public static void main(String[] args) {				 
	COSC322Test player_01 = new COSC322Test("Everton1", "1234");  		 
    }
	
    public COSC322Test(String userName, String passwd) {
	this.userName = userName;
    setupGUI();       
	gameClient = new GameClient(userName, passwd, this);	 
    }
 
    @Override
    public boolean handleGameMessage(String messageType, Map<String, Object> msgDetails) {
	//This method will be called by the GameClient when it receives a game-related message
	//from the server.
    	if(messageType.equals(GameMessage.GAME_ACTION_START)){
    		//BoardGameModel gboard = new BoardGameModel();
    		//BoardGameModel();
    	    if(((String) msgDetails.get("player-black")).equals(this.userName())){
    		System.out.println("Game State: " +  msgDetails.get("player-black"));
    		white = false; System.out.println("We go first.");
    		//randomMove();
    	    } else {
    			System.out.println("Other player goes first.");
    			white = true;
    		}
    	    
    	}
    	else if(messageType.equals(GameMessage.GAME_ACTION_MOVE)){
    	    handleOpponentMove(msgDetails);
    	}
    	
	//For a detailed description of the message types and format, 
	//see the method GamePlayer.handleGameMessage() in the game-client-api document. 
	return true;
    }
    
    
    /**private void randomMove() {
		// TODO Auto-generated method stub
    	PossibleMoves(board,white,wQueens,bQueens);

	}**/

	private void handleOpponentMove(Map<String, Object> msgDetails){
    	System.out.println("OpponentMove(): " + msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR));
    	ArrayList<Integer> qcurr = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR);
    	ArrayList<Integer> qnew = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.Queen_POS_NEXT);
    	ArrayList<Integer> arrow = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.ARROW_POS);
    	System.out.println("QCurr: " + qcurr);
    	System.out.println("QNew: " + qnew);
    	System.out.println("Arrow: " + arrow);

    	board.markPosition(qnew.get(0), qnew.get(1), arrow.get(0), arrow.get(1), 
    			  qcurr.get(0), qcurr.get(1), true);	
    	//randomMove();
    }
    	/**Add random move generator**/
    

	//Need to feed generated move into proper coordinates and will send to server.
    public void playerMove(int x, int y, int arow, int acol, int qfr, int qfc){		
		 
    	int[] qf = new int[2];
    	qf[0] = qfr;
    	qf[1] = qfc;

    	int[] qn = new int[2];
    	qn[0] = x;
    	qn[1] = y;

    	int[] ar = new int[2];
    	ar[0] = arow;
    	ar[1] = acol;
 
    	this.gameClient.sendMoveMessage(qf, qn, ar);
    	
        }
    
    
    private void setupGUI(){
	    guiFrame = new JFrame();
		   
		guiFrame.setSize(800, 600);
		guiFrame.setTitle("Game of the Amazons (COSC 322, )" + this.userName());	
		
		guiFrame.setLocation(200, 200);
		guiFrame.setVisible(true);
	    guiFrame.repaint();		
		guiFrame.setLayout(null);
		
		Container contentPane = guiFrame.getContentPane();
		contentPane.setLayout(new  BorderLayout());
		 
		contentPane.add(Box.createVerticalGlue()); 
		
		board = createGameBoard();		
		contentPane.add(board,  BorderLayout.CENTER);
    }
    
    private GameBoard createGameBoard(){
	return new GameBoard(this);
    }	
		
    
    public class GameBoard extends JPanel{

	    private static final long serialVersionUID = 1L;
	    private  int rows = 10;
	    private  int cols = 10; 

	    int width = 500;
	    int height = 500;
	    int cellDim = width / 10; 
	    int offset = width / 20;

	    int posX = -1;
	    int posY = -1;

	    int r = 0;
	    int c = 0;


	    COSC322Test game = null; 
	    
	private BoardGameModel gameModel = null;

	    boolean playerAMove;

	    public GameBoard(COSC322Test game){
	    this.game = game;	       
	    gameModel = new BoardGameModel(this.rows + 1, this.cols + 1);

	   
	    init(true);	
	    }


	    public void init(boolean isPlayerA){
	    String tagB = null;
	    String tagW = null;

	    tagB = BoardGameModel.POS_MARKED_BLACK;
	    tagW = BoardGameModel.POS_MARKED_WHITE;

	    gameModel.gameBoard[1][4] = tagW;
	    gameModel.gameBoard[1][7] = tagW;
	    gameModel.gameBoard[3][1] = tagW;
	    gameModel.gameBoard[3][10] = tagW;

	    gameModel.gameBoard[8][1] = tagB;
	    gameModel.gameBoard[8][10] = tagB;
	    gameModel.gameBoard[10][4] = tagB;
	    gameModel.gameBoard[10][7] = tagB;		
	    }

	    public boolean markPosition(int qrow, int qcol, int arow, int acol, 
			      int qfr, int qfc, boolean  opponentMove){						

		    System.out.println(qrow + ", " + qcol + ", " + arow + ", " + acol 
				    + ", " + qfr + ", " + qfc);

		    boolean valid = gameModel.positionMarked(qrow, qcol, arow, acol, qfr, qfc, opponentMove);
		    repaint();						
		    return valid;
	    }

	    // JCmoponent method
	    protected void paintComponent(Graphics gg){
		    Graphics g = (Graphics2D) gg;

		    for(int i = 0; i < rows + 1; i++){
			    g.drawLine(i * cellDim + offset, offset, i * cellDim + offset, rows * cellDim + offset);
			    g.drawLine(offset, i*cellDim + offset, cols * cellDim + offset, i*cellDim + offset);					 
		    }

		    for(int r = 0; r < rows; r++){
		      for(int c = 0; c < cols; c++){

				    posX = c * cellDim + offset;
				    posY = r * cellDim + offset;

				    posY = (9 - r) * cellDim + offset;

			    if(gameModel.gameBoard[r + 1][c + 1].equalsIgnoreCase(BoardGameModel.POS_AVAILABLE)){
				    g.clearRect(posX + 1, posY + 1, 49, 49);					
			    }

			    if(gameModel.gameBoard[r + 1][c + 1].equalsIgnoreCase(
					      BoardGameModel.POS_MARKED_BLACK)){
				    g.fillOval(posX, posY, 50, 50);
			    } 
			    else if(gameModel.gameBoard[r + 1][c + 1].equalsIgnoreCase(
				      BoardGameModel.POS_MARKED_ARROW)) {
				    g.clearRect(posX + 1, posY + 1, 49, 49);
				    g.drawLine(posX, posY, posX + 50, posY + 50);
				    g.drawLine(posX, posY + 50, posX + 50, posY);
			    }
			    else if(gameModel.gameBoard[r + 1][c + 1].equalsIgnoreCase(BoardGameModel.POS_MARKED_WHITE)){
				    g.drawOval(posX, posY, 50, 50);
			    }
		      }
	    }

	    }//method

	    //JComponent method
	    public Dimension getPreferredSize() {
		    return new Dimension(500,500);
	    }	

    }//end of GameBoard  
    class BoardGameModel extends GameModel {

    	public static final String POS_MARKED_BLACK = "black";
    	public static final String POS_MARKED_WHITE = "white";
    	public static final String POS_MARKED_ARROW = "arrow";
    	public static final String POS_AVAILABLE = "available";
    	
    	 String[][] gameBoard = null; 
    	
    	public BoardGameModel(int rows, int columns){
    		
    		gameBoard = new String[rows + 1][columns + 1];
    		for(int i = 1; i < rows + 1; i++){
    			for(int j = 1; j < columns + 1; j++){
    				gameBoard[i][j] = BoardGameModel.POS_AVAILABLE;
    			}
    		}
    	}
    	
    	
    	public boolean positionMarked(int row, int column, int arow, int acol,
    			 int qfr, int qfc, boolean opponentMove){
    		boolean valid = true;
    		
     
    		
    		if(row >= gameBoard.length | column >= gameBoard.length 
    				 || row <= 0 || column <= 0){
    			valid = false;
    		}
    		else if (!gameBoard[row][column].equalsIgnoreCase(BoardGameModel.POS_AVAILABLE)){
    			valid = false;
    		}
            
    		if(valid){
    			gameBoard[row][column] = gameBoard[qfr][qfc];		
    			gameBoard[qfr][qfc] = BoardGameModel.POS_AVAILABLE;		
    			gameBoard[arow][acol] = BoardGameModel.POS_MARKED_ARROW;
    		}
    		
    		//System.out.println(this.toString());
    		
    		return valid;
    	}	
    	
    	public String toString(){
          String b = null;

          for(int i = 1; i < 11; i++){
    	      for(int j = 1; j< 11; j++){
    		b = b + gameBoard[i][j] + " ";
    	      }
    	      b = b + "\n";
          }  	  
          return b;
        }	
        }//End of board game model
   
    
    

    @Override
    public void onLogin() {
    	ArrayList<String> rooms = gameClient.getRoomList();
    	for (int i=0;i<rooms.size();i++) {
    		System.out.println("ROOM NUMBER "+i+": "+ rooms.get(i));
    	}
    	
    	Scanner reader = new Scanner(System.in);  // Reading from System.in
    	System.out.println("Enter a room number: ");
    	int n = reader.nextInt();
    	reader.close();	 
    	System.out.println("Logging into: "+rooms.get(n)+"...");
    	this.gameClient.joinRoom(rooms.get(n));
    	System.out.println("Currently in room: "+rooms.get(n));
    	
    }
    
    @Override
    public String userName() {
	return userName;
    }
}//end of class
