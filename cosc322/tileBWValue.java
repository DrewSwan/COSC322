package cosc322;

/**
 * 
 * 
 * @author Evertons
 *
 *         wh = number of tiles white owns based on up to 3 moves to be on
 *         space,bl = same for black value is returned based on what colour we
 *         are, ex if we are white value = wh-bl call eval(BoardGameModel BGM)
 *         to return value
 */

public class tileBWValue {
	private String[][] board = new String[10][10];
	private String[][] tempB = new String[10][10];
	public int wh;
	public int bl;
	public boolean more = false;
	
	tileBWValue(){
		
	}

	// If player is white, returns eval value based on wh ownership - black
	// ownership
	// Positive will be good, negative bad, tie = tie
	// Still only based on one move ownership
	public int eval(BoardGameModel BGM) {
		int value = 0;
		this.board = BGM.getBoard();

		tileBWValue(board);
		if (BGM.getWhiteTurn() == true) {
			value = wh - bl;
		} else if (BGM.getWhiteTurn() == false) {
			value = bl - wh;
		}
		return value;
	}

	//Used for testing
	public String[][] prt(String[][] b) {
		String[][] temp = b;
		tileBWValue(temp);
		temp = tempB;
		return temp;

	}

	/**
	 * 
	 * tempB will become a board showing who owns each space "white" = white owns
	 * the space, "black" black owns the space "tie" each player is one move away
	 * from space "unknown" no player is one move away Ownership is based on
	 * ownership after ONLY 1 MOVE "wh" will return how many spaces white owns, "bl"
	 * is for black
	 * 
	 * UPDATE MARCH 26:If any spaces are unknown (more than one move required by any
	 * team) it will test for ownership based on 2 moves.
	 * 
	 * UPDATE MARCH 26 part 2: Now up to 3 moves
	 * 
	 * @param b
	 */
	private void tileBWValue(String[][] b) {
		this.board = b;
		tempB = b;
		String[][] tempC = new String[10][10];
		String[][] tempD = new String[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tempC[i][j] = "available";
				tempD[i][j] = "available";

			}
		}

		//System.out.println("\n\n");
		// wh = spaces white "own"
		// bl = spaces black "own"
		wh = 0;
		bl = 0;

		int r = 1;
		int c = 1;
		more = false;

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

						if (tempB[i][j + c].equalsIgnoreCase("available")
								|| tempB[i][j + c].equalsIgnoreCase("unknown")) {
							c++;
						} else if (tempB[i][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
						}
					}

					c = 1;
					r = 1;
					while (j - c >= 0) {

						if (tempB[i][j - c].equalsIgnoreCase("available")
								|| tempB[i][j - c].equalsIgnoreCase("unknown")) {
							c++;

						} else if (tempB[i][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
						}
					}
					c = 1;
					r = 1;
					while (i + r < 10) {

						if (tempB[i + r][j].equalsIgnoreCase("available")
								|| tempB[i + r][j].equalsIgnoreCase("unknown")) {
							r++;
						} else if (tempB[i + r][j].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i + r][j].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							r++;
						}
					}
					r = 1;
					c = 1;
					while (i - r >= 0) {

						if (tempB[i - r][j].equalsIgnoreCase("available")
								|| tempB[i - r][j].equalsIgnoreCase("unknown")) {
							r++;
						} else if (tempB[i - r][j].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i - r][j].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							r++;
						}
					}
					c = 1;
					r = 1;
					while (j + c < 10 && i + r < 10) {

						if (tempB[i + r][j + c].equalsIgnoreCase("available")
								|| tempB[i + r][j + c].equalsIgnoreCase("unknown")) {
							c++;
							r++;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i + r][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
							r++;
						}
					}
					c = 1;
					r = 1;
					while (j + c < 10 && i - r >= 0) {

						if (tempB[i - r][j + c].equalsIgnoreCase("available")
								|| tempB[i - r][j + c].equalsIgnoreCase("unknown")) {
							c++;
							r++;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i - r][j + c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
							r++;
						}
					}
					c = 1;
					r = 1;
					while (j - c >= 0 && i + r < 10) {

						if (tempB[i + r][j - c].equalsIgnoreCase("available")
								|| tempB[i + r][j - c].equalsIgnoreCase("unknown")) {
							c++;
							r++;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i + r][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
							r++;
						}
					}
					c = 1;
					r = 1;
					while (j - c >= 0 && i - r >= 0) {

						if (tempB[i - r][j - c].equalsIgnoreCase("available")
								|| tempB[i - r][j - c].equalsIgnoreCase("unknown")) {
							c++;
							r++;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("arrow")) {
							break;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("white")) {
							wOwn = true;
							break;
						} else if (tempB[i - r][j - c].equalsIgnoreCase("black")) {
							bOwn = true;
							break;
						} else {
							c++;
							r++;
						}
					}
					c = 1;
					r = 1;

				} else if (tempB[i][j].equalsIgnoreCase("black")) {
					// tempC[i][j] = "black";
					bOwn = true;
					wOwn = false;
				} else if (tempB[i][j].equalsIgnoreCase("white")) {
					// tempC[i][j] = "white";
					wOwn = true;
					bOwn = false;
				} else {
					//System.out.println("ERROR1");
					wOwn = true;
					bOwn = true;
				}

				// Label tiles with ownership or unknown
				if (wOwn == true && bOwn == true) {
					tempC[i][j] = "tie1move";
				} else if (wOwn == true && bOwn == false) {
					wh = wh + 1;
					tempC[i][j] = "white";
				} else if (wOwn == false && bOwn == true) {
					bl = bl + 1;
					tempC[i][j] = "black";
				} else {

					tempC[i][j] = "unknown";
					more = true;
				}

			}
		} // End of board scan #1

		/***
		 * Checks if any spaces connected to unknown space have an owner, indicating
		 * that owner is 3 moves away "unknown" = needs 2 or more moves to own
		 */
		if (more == false) {
			tempB = tempC;

		}

		if (more == true) {
			more = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					// True if black or white 2 moves away from space
					boolean b2 = false;
					boolean w2 = false;
					// Find empty spaces
					if (tempC[i][j].equalsIgnoreCase("unknown")) {

						while (j + c < 10) {
							if (tempC[i][j + c].equalsIgnoreCase("unknown")) {
								c++;
							} else if (tempC[i][j + c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i][j + c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i][j + c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i][j + c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;

							}
						}
						c = 1;
						while (j - c >= 0) {
							if (tempC[i][j - c].equalsIgnoreCase("unknown")) {
								c++;
							} else if (tempC[i][j - c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i][j - c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i][j - c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i][j - c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;

							}
						}
						c = 1;
						while (i + r < 10) {
							if (tempC[i + r][j].equalsIgnoreCase("unknown")) {
								r++;
							} else if (tempC[i + r][j].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i + r][j].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i + r][j].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i + r][j].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {

								r++;
							}
						}
						r = 1;
						while (i - r >= 0) {
							if (tempC[i - r][j].equalsIgnoreCase("unknown")) {
								r++;
							} else if (tempC[i - r][j].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i - r][j].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i - r][j].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i - r][j].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {

								r++;
							}
						}
						r = 1;
						while (j + c < 10 && i + r < 10) {
							if (tempC[i + r][j + c].equalsIgnoreCase("unknown")) {
								c++;
								r++;
							} else if (tempC[i + r][j + c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i + r][j + c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i + r][j + c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i + r][j + c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;
								r++;
							}
						}
						c = 1;
						r = 1;
						while (j + c < 10 && i - r >= 0) {
							if (tempC[i - r][j + c].equalsIgnoreCase("unknown")) {
								c++;
								r++;
							} else if (tempC[i - r][j + c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i - r][j + c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i - r][j + c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i - r][j + c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;
								r++;
							}
						}
						c = 1;
						r = 1;
						while (j - c >= 0 && i + r < 10) {
							if (tempC[i + r][j - c].equalsIgnoreCase("unknown")) {
								c++;
								r++;
							} else if (tempC[i + r][j - c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i + r][j - c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i + r][j - c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i + r][j - c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;
								r++;
							}
						}
						c = 1;
						r = 1;
						while (j - c >= 0 && i - r >= 0) {
							if (tempC[i - r][j - c].equalsIgnoreCase("unknown")) {
								c++;
								r++;
							} else if (tempC[i - r][j - c].equalsIgnoreCase("arrow")) {
								break;
							} else if (tempC[i - r][j - c].equalsIgnoreCase("white")) {
								w2 = true;
								break;
							} else if (tempC[i - r][j - c].equalsIgnoreCase("black")) {
								b2 = true;
								break;
							} else if (tempC[i - r][j - c].equalsIgnoreCase("tie1move")) {
								b2 = true;
								w2 = true;
								break;
							} else {
								c++;
								r++;
							}
						}
						c = 1;
						r = 1;

					} else if (tempC[i][j].equalsIgnoreCase("black")) {
						w2 = false;
						b2 = true;
					} else if (tempC[i][j].equalsIgnoreCase("white")) {
						b2 = false;
						w2 = true;
					} else {
						w2 = true;
						b2 = true;
					}
					// Label tiles with ownership or unknown
					if (w2 == true && b2 == true) {
						tempD[i][j] = "tied";
					} else if (w2 == true && b2 == false) {
						wh = wh + 1;
						tempD[i][j] = "white";
					} else if (w2 == false && b2 == true) {
						bl = bl + 1;
						tempD[i][j] = "black";
					} else {
						tempD[i][j] = "3+ Moves Away";
						more = true;
					}
				}
			} // End of board scan #2
			/**
			 * 
			 * Board scan if still unknown tiles needing 3 moves to locate
			 */
			if (more == false)

			{
				tempB = tempD;

			}
			if (more == true) {
				more = false;
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						// True if black or white 2 moves away from space
						boolean b3 = false;
						boolean w3 = false;
						// Find empty spaces
						if (tempD[i][j].equalsIgnoreCase("3+ Moves Away")) {

							while (j + c < 10) {
								if (tempD[i][j + c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
								} else if (tempD[i][j + c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i][j + c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i][j + c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i][j + c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;

								}
							}
							c = 1;
							while (j - c >= 0) {
								if (tempD[i][j - c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
								} else if (tempD[i][j - c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i][j - c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i][j - c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i][j - c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;

								}
							}
							c = 1;
							while (i + r < 10) {
								if (tempD[i + r][j].equalsIgnoreCase("3+ Moves Away")) {
									r++;
								} else if (tempD[i + r][j].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i + r][j].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i + r][j].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i + r][j].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {

									r++;
								}
							}
							r = 1;
							while (i - r >= 0) {
								if (tempD[i - r][j].equalsIgnoreCase("3+ Moves Away")) {
									r++;
								} else if (tempD[i - r][j].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i - r][j].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i - r][j].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i - r][j].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {

									r++;
								}
							}
							r = 1;
							while (j + c < 10 && i + r < 10) {
								if (tempD[i + r][j + c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
									r++;
								} else if (tempD[i + r][j + c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i + r][j + c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i + r][j + c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i + r][j + c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;
									r++;
								}
							}
							c = 1;
							r = 1;
							while (j + c < 10 && i - r >= 0) {
								if (tempD[i - r][j + c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
									r++;
								} else if (tempD[i - r][j + c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i - r][j + c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i - r][j + c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i - r][j + c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;
									r++;
								}
							}
							c = 1;
							r = 1;
							while (j - c >= 0 && i + r < 10) {
								if (tempD[i + r][j - c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
									r++;
								} else if (tempD[i + r][j - c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i + r][j - c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i + r][j - c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i + r][j - c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;
									r++;
								}
							}
							c = 1;
							r = 1;
							while (j - c >= 0 && i - r >= 0) {
								if (tempD[i - r][j - c].equalsIgnoreCase("3+ Moves Away")) {
									c++;
									r++;
								} else if (tempD[i - r][j - c].equalsIgnoreCase("arrow")) {
									break;
								} else if (tempD[i - r][j - c].equalsIgnoreCase("white")) {
									w3 = true;
									break;
								} else if (tempD[i - r][j - c].equalsIgnoreCase("black")) {
									b3 = true;
									break;
								} else if (tempD[i - r][j - c].equalsIgnoreCase("tied")) {
									b3 = true;
									w3 = true;
									break;
								} else {
									c++;
									r++;
								}
							}
							c = 1;
							r = 1;

						} else if (tempD[i][j].equalsIgnoreCase("black")) {
							w3 = false;
							b3 = true;
						} else if (tempD[i][j].equalsIgnoreCase("white")) {
							b3 = false;
							w3 = true;
						} else {
							w3 = true;
							b3 = true;
						}
						// Label tiles with ownership or unknown
						if (w3 == true && b3 == true) {
							tempB[i][j] = "tied";
						} else if (w3 == true && b3 == false) {
							wh = wh + 1;
							tempB[i][j] = "white";
						} else if (w3 == false && b3 == true) {
							bl = bl + 1;
							tempB[i][j] = "black";
						} else {
							tempB[i][j] = ">3 moves away";
							more = true;
						}
					}
				} // End of board scan #3

			}
			// unnecessary?
			more = false;
		}
	}// End of tileBWValue(String b) function
}// end of class
