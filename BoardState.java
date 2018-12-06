/**
 * This class model the details of the board state which is the number
 * of occupied cells and the cell occupancy.
 */
public class BoardState {
	private int numCellsOccupied;
	private boolean[] occupied;
	
	public BoardState(int emptyPos) {
		occupied = new boolean[15];
		for(int i=0; i < occupied.length; i++) {
			occupied[i] = true;
		}
		occupied[emptyPos] = false;
		numCellsOccupied = 14;
	}
	
	public boolean getFilled(int pos) {
		return occupied[pos];
	}
	
	public void setFilled(int pos, boolean filled) {
		occupied[pos] = filled;
		if(filled)
			numCellsOccupied++;
		else
			numCellsOccupied--;
	}

	/**
	 * @return the numCellsOccupied
	 */
	public int getNumCellsOccupied() {
		return numCellsOccupied;
	}

	/**
	 * @return the occupied
	 */
	public boolean[] getOccupied() {
		return occupied;
	}
	
	public BoardState clone() {
		BoardState copy = new BoardState(0);
		for(int i = 0; i < occupied.length; i++) {
			copy.occupied[i] = occupied[i];
		}
		copy.numCellsOccupied = numCellsOccupied;
		return copy;
	}
	
	public void show() {
		int[][] lines = {{4,0,0},{3,1,2},{2,3,5},{1,6,9},{0,10,14}};
		for(int i = 0; i < lines.length; i++) {
			int t = lines[i][0];
			int a = lines[i][1];
			int b = lines[i][2];
			for(int j=0; j < t; j++) {
				System.out.print(" ");
			}
			for(int k = a; k <= b; k++ ) {
				if(!occupied[k])
					System.out.print(". ");
				else
					System.out.print("x ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
