package cosc322;

/**
 * 
 * 
 * @author Evertons
 *
 */
public class tileBWValue {
	private String[][] board = new String[10][10];
	private String[][] tempB = new String[10][10];
	public int wh;
	public int bl;
	public int eval(BoardGameModel BGM) {
		int value = 0;
		this.board = BGM.getBoard();
		
		tileBWValue(board);
		if (BGM.getWhiteTurn() == true) {
			value = wh-bl;
		}else if(BGM.getWhiteTurn() == false) {
			value = bl-wh;
		}
		return value;
	}

/**
 * 
 * tempB will become a board showing who owns each space
 * "white" = white owns the space, "black" black owns the space
 * "tie" each player is one move away from space
 * "unknown" no player is one move away
 * Ownership is based on ownership after ONLY 1 MOVE
 * "wh" will return how many spaces white owns, "bl" is for black
 * 
 * 
 * @param b
 */
	private void tileBWValue(String[][] b) {
		this.board = b;
		tempB = b;
		// wh = spaces white "own"
		// bl = spaces black "own"
		wh = 0;
		bl = 0;

		int r = 1;
		int c = 1;

		boolean wOwn = false;
		boolean bOwn = false;
		// Search each tile and seek closest queen
		// DREW - USING 0-9 HERE
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				wOwn = false;
				bOwn = false;
				// Find empty spaces
				if (tempB[i][j].equalsIgnoreCase("available")) {
					// Check each move direction for queen or arrow
					// if only one colour queen found, they own space
					// if both then contested, neither player owns
					while (j + c < 10) {
						if (tempB[i][j + c].equalsIgnoreCase("available")) {
							c++;
						} else if (tempB[i][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					while (j - c >= 0) {
						if (tempB[i][j - c].equalsIgnoreCase("available")) {
							c++;
						} else if (tempB[i][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					while (i + r < 10) {
						if (tempB[i + r][j].equalsIgnoreCase("available")) {
							r++;
						} else if (tempB[i + r][j].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i + r][j].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					r = 1;
					while (i - r >= 0) {
						if (tempB[i - r][j].equalsIgnoreCase("available")) {
							r++;
						} else if (tempB[i - r][j].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i - r][j].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					r = 1;
					while (j + c < 10 && i + r < 10) {
						if (tempB[i + r][j + c].equalsIgnoreCase("available")) {
							c++;r++;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					r = 1;
					while (j + c < 10 && i - r >= 0) {
						if (tempB[i - r][j + c].equalsIgnoreCase("available")) {
							c++;r++;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					r = 1;
					while (j - c >= 0 && i + r < 10) {
						if (tempB[i + r][j - c].equalsIgnoreCase("available")) {
							c++;r++;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					r = 1;
					while (j - c >= 0 && i - r >= 0) {
						if (tempB[i - r][j - c].equalsIgnoreCase("available")) {
							c++;r++;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
						}
					}
					c = 1;
					r = 1;
				}else {
					//do nothing, go to next tile
				}
				//Label tiles with ownership or unknown
				if(wOwn == true && bOwn == true) {
					tempB[i][j] = "tie";
				}else if(wOwn == true && bOwn == false) {
					wh = wh + 1;
					tempB[i][j] = "white";
				}else if(wOwn == false && bOwn == true) {
					bl = bl + 1;
					tempB[i][j] = "black";
				}else {
					tempB[i][j] = "unknown";
				}
			}
		}
	}
}
