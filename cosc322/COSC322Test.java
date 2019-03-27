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
import java.util.Timer;
import java.util.TimerTask;

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

public class COSC322Test extends GamePlayer {

	private GameClient gameClient;
	private JFrame guiFrame = null;
	private GameBoard board = null;
	private boolean gameStarted = false;
	private String userName = null;
	static private boolean white = false;

	public static boolean ourTurn = false;

	ActionTree moveGenerator;

	/**
	 * The main method
	 * 
	 * @param args for name and passwd (current, any string would work)
	 */
	public static void main(String[] args) {
		COSC322Test player_01 = new COSC322Test("Everton2", "1234");
	}

	public COSC322Test(String userName, String passwd) {
		this.userName = userName;
		setupGUI();
		gameClient = new GameClient(userName, passwd, this);

	}

	@Override
	public boolean handleGameMessage(String messageType, Map<String, Object> msgDetails) {
		// This method will be called by the GameClient when it receives a game-related
		// message
		// from the server.
		if (messageType.equals(GameMessage.GAME_ACTION_START)) {
			// BoardGameModel gboard = new BoardGameModel();
			// BoardGameModel();
			if (((String) msgDetails.get("player-black")).equals(this.userName())) {
				System.out.println("Game State: " + msgDetails.get("player-black"));
				white = false;
				System.out.println("We go first.");
				ourMove();
			} else {
				System.out.println("Other player goes first.");
				white = true;
			}

		} else if (messageType.equals(GameMessage.GAME_ACTION_MOVE)) {
			System.out.println("AAA");
			handleOpponentMove(msgDetails);
		}

		// For a detailed description of the message types and format,
		// see the method GamePlayer.handleGameMessage() in the game-client-api
		// document.
		return true;
	}

	/**
	 * private void randomMove() { // TODO Auto-generated method stub
	 * PossibleMoves(board,white,wQueens,bQueens); }
	 **/

	private void handleOpponentMove(Map<String, Object> msgDetails) {
		System.out.println("OpponentMove(): " + msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR));
		ArrayList<Integer> qcurr = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.QUEEN_POS_CURR);
		ArrayList<Integer> qnew = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.Queen_POS_NEXT);
		ArrayList<Integer> arrow = (ArrayList<Integer>) msgDetails.get(AmazonsGameMessage.ARROW_POS);
		System.out.println("QCurr: " + qcurr);
		System.out.println("QNew: " + qnew);
		System.out.println("Arrow: " + arrow);

		board.markPosition(qnew.get(0), qnew.get(1), arrow.get(0), arrow.get(1), qcurr.get(0), qcurr.get(1), true);
		ourMove();
	}

	/** Add random move generator **/

	public void ourMove() {
		System.out.println("Calculating Move");
		ourTurn = true;

		long startTime = System.currentTimeMillis();

		moveGenerator = new ActionTree(board.gameModel);
		PossibleMoves initialMove = new PossibleMoves(board.gameModel);
		board.gameModel.childMoves = initialMove.moveGeneration();

		String[][] test = moveGenerator.getRoot().getData().getBoard();

		ArrayList<ActionTree.Node<BoardGameModel>> previousDepth = new ArrayList<ActionTree.Node<BoardGameModel>>();
		ArrayList<ActionTree.Node<BoardGameModel>> currentDepth = new ArrayList<ActionTree.Node<BoardGameModel>>();

		for (move m : board.gameModel.childMoves) {
			currentDepth.add(moveGenerator.getRoot().createChild(
					new BoardGameModel(moveGenerator.getRoot().getData(), m.qx, m.qy, m.nx, m.ny, m.ax, m.ay)));
		}

		moveGenerator.depthNodes.add(currentDepth);

		test = moveGenerator.getRoot().getData().getBoard();
		BoardGameModel currentBoard;
		PossibleMoves moves;
		int i = 2;
		// System.out.println(moveGenerator.depthNodes.get(i-1).toString());
		int y = 0;

		while (ourTurn) {
			currentDepth = new ArrayList<ActionTree.Node<BoardGameModel>>();
			previousDepth = moveGenerator.depthNodes.get(i - 1);
			// System.out.println(previousDepth.toString());
			// System.out.println(previousDepth.toString());
			for (ActionTree.Node<BoardGameModel> a : previousDepth) {
				currentBoard = a.getData();
				moves = new PossibleMoves(currentBoard);
				currentBoard.childMoves = moves.moveGeneration();
				for (move m : currentBoard.childMoves) {
					if (m == null) {
						System.out.println("Issue Found");
					}
					currentDepth
							.add(a.createChild(new BoardGameModel(currentBoard, m.qx, m.qy, m.nx, m.ny, m.ax, m.ay)));
				}
				if (System.currentTimeMillis() - startTime > 20000) {
					break;
				}

				// System.out.println("i = " + i + ", y = " + y++);
			}
			if (System.currentTimeMillis() - startTime > 20000) {
				break;
			}
			moveGenerator.depthNodes.add(currentDepth);
			// System.out.println("i = " + i);
			i++;
		}

		determineMove(i);
		// ArrayList<move> nextLayer;

	}

	// Need to feed generated move into proper coordinates and will send to server.
	public void playerMove(int x, int y, int arow, int acol, int qfr, int qfc) {

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

	private void setupGUI() {
		guiFrame = new JFrame();

		guiFrame.setSize(800, 600);
		guiFrame.setTitle("Game of the Amazons (COSC 322, )" + this.userName());

		guiFrame.setLocation(200, 200);
		guiFrame.setVisible(true);
		guiFrame.repaint();
		guiFrame.setLayout(null);

		Container contentPane = guiFrame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(Box.createVerticalGlue());

		board = createGameBoard();
		contentPane.add(board, BorderLayout.CENTER);
	}

	public boolean handleMessage(String msg) {
		System.out.println("Time Out ------ " + msg);
		return true;
	}

	private GameBoard createGameBoard() {
		return new GameBoard(this);
	}

	public class GameBoard extends JPanel {

		private static final long serialVersionUID = 1L;
		private int rows = 10;
		private int cols = 10;

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

		public GameBoard(COSC322Test game) {
			this.game = game;
			gameModel = new BoardGameModel();

		}

		public boolean markPosition(int qrow, int qcol, int arow, int acol, int qfr, int qfc, boolean opponentMove) {

			System.out.println(qrow + ", " + qcol + ", " + arow + ", " + acol + ", " + qfr + ", " + qfc);

			boolean valid = gameModel.positionMarked(qrow - 1, qcol - 1, arow - 1, acol - 1, qfr - 1, qfc - 1,
					opponentMove);
			repaint();
			return valid;
		}

		// JCmoponent method
		protected void paintComponent(Graphics gg) {
			Graphics g = (Graphics2D) gg;
			String[][] board = gameModel.getBoard();

			for (int i = 0; i < rows + 1; i++) {
				g.drawLine(i * cellDim + offset, offset, i * cellDim + offset, rows * cellDim + offset);
				g.drawLine(offset, i * cellDim + offset, cols * cellDim + offset, i * cellDim + offset);
			}

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {

					posX = c * cellDim + offset;
					posY = r * cellDim + offset;

					posY = (9 - r) * cellDim + offset;
					// remove +1's
					if (board[r][c].equalsIgnoreCase(BoardGameModel.POS_AVAILABLE)) {
						g.clearRect(posX + 1, posY + 1, 49, 49);
					}

					if (board[r][c].equalsIgnoreCase(BoardGameModel.POS_MARKED_BLACK)) {
						g.fillOval(posX, posY, 50, 50);
					} else if (board[r][c].equalsIgnoreCase(BoardGameModel.POS_MARKED_ARROW)) {
						g.clearRect(posX + 1, posY + 1, 49, 49);
						g.drawLine(posX, posY, posX + 50, posY + 50);
						g.drawLine(posX, posY + 50, posX + 50, posY);
					} else if (board[r][c].equalsIgnoreCase(BoardGameModel.POS_MARKED_WHITE)) {
						g.drawOval(posX, posY, 50, 50);
					}
				}
			}

		}// method

		// JComponent method
		public Dimension getPreferredSize() {
			return new Dimension(500, 500);
		}

	}// end of GameBoard

	public void determineMove(int depth) {
		ourTurn = false;

		System.out.println("Move decided on");

		BoardGameModel bestMove = moveGenerator.minMax(depth);

		if (bestMove == null) {
			System.out.println("RIP");
		}
		System.out.println("Success");
		System.out
				.println("PrevX " + (bestMove.movedQueenPreviousX + 1) + ",PrevY " + (bestMove.movedQueenPreviousY + 1)
						+ ",NowX " + (bestMove.movedQueenNowX + 1) + ",NowY " + (bestMove.movedQueenNowY + 1));
		playerMove(bestMove.movedQueenNowX + 1, bestMove.movedQueenNowY + 1, bestMove.firedArrowX + 1,
				bestMove.firedArrowY + 1, bestMove.movedQueenPreviousX + 1, bestMove.movedQueenPreviousY + 1);

		/***
		 * 
		 * MARCH 27: This is where the only error lies Need to call boolean validMove in
		 * order to update our own GUI with our move.
		 * 
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * 
		 */
		// boolean validMove = GB.markPosition(bestMove.movedQueenNowX + 1,
		// bestMove.movedQueenNowY + 1,
		// bestMove.firedArrowX + 1, bestMove.firedArrowY + 1,
		// bestMove.movedQueenPreviousX + 1,
		// bestMove.movedQueenPreviousY + 1, false); // update itself
	}

	String[][] boardGame = null;

	@Override
	public void onLogin() {
		ArrayList<String> rooms = gameClient.getRoomList();
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println("ROOM NUMBER " + i + ": " + rooms.get(i));
		}

		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter a room number: ");
		int n = reader.nextInt();
		reader.close();
		System.out.println("Logging into: " + rooms.get(n) + "...");
		this.gameClient.joinRoom(rooms.get(n));
		System.out.println("Currently in room: " + rooms.get(n));

		// ourMove();
	}

	@Override
	public String userName() {
		return userName;
	}
}// end of class
