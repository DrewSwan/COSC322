package cosc322;

import java.util.ArrayList;

public class queenMobility {

	ArrayList<move> moveList = new ArrayList<move>();
	int[] qlist = new int[4];
	int[] qlocx = new int[4];
	int[] qlocy = new int[4];
	int x = -1;
	int y = -1;
	int q = 0;
	
	//Retrieves information of the queen in form of {moves left,x location,y location}
	public int[] getQueen(int i) {
		
		int[] qinfo = new int[3];
		qinfo[0] = qlist[i];
		qinfo[1] = qlocx[i];
		qinfo[2] = qlocy[i];
		
		return qinfo;
	}
	//Fills list 'qlist' with number of moves per queen (ind 0 = queen # 1 moves left, etc) 
	public queenMobility(ArrayList<move> moves) {
		for (int counter = 0; counter < moves.size(); counter++) {
			if (moves.get(counter).qx == x || moves.get(counter).qx == -1) {
				if (moves.get(counter).qy == y || moves.get(counter).qy == -1) {
					x = moves.get(counter).qx;
					y = moves.get(counter).qy;
					qlocx[q] = x;
					qlocy[q] = y;

					qlist[q] += 1;
					
				}else {
					x = moves.get(counter).qx;
					y = moves.get(counter).qy;
					q = q+1;
					qlist[q] += 1;
				}
			}
		}
	}
}