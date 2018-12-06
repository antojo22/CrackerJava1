import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the solver to solve a given puzzle
 */
public class Solver {

	static int[][] moves = {{0,1,3},
			                {0,2,5},
			                {1,3,6},
			                {1,4,8},
			                {2,4,7},
			                {2,5,9},
			                {3,6,10},
			                {3,7,12},
			                {4,7,11},
			                {4,8,13},
			                {5,8,12},
			                {5,9,14},
			                {3,4,5},
			                {6,7,8},
			                {7,8,9},
			                {10,11,12},
			                {11,12,13},
			                {12,13,14}};
	
	public static List<Move> step() {
		List<Move> allMoves = new ArrayList<Move>();
		for(int i = 0; i < moves.length; i++) {
			int from = moves[i][0];
			int over = moves[i][1];
			int to = moves[i][2];
			allMoves.add(new Move(from, over, to));
			allMoves.add(new Move(to, over, from));
		}
		return allMoves;
	}
	
	public static BoardState move(BoardState boardState, Move move) {
		int k = boardState.getNumCellsOccupied();
		boolean[] d = boardState.getOccupied();
		int from = move.getFrom();
		int over = move.getOver();
		int to = move.getTo();
		if(d[from] && d[over] && !d[to]) {			
			BoardState copy = boardState.clone();
			copy.setFilled(from, false);
			copy.setFilled(over, false);
			copy.setFilled(to, true);
			return copy;
		}
		else {
			return null;
		}
	}
	
	public static void replay(List<Move> ms, BoardState kd) {
		for(Move m : ms) {
			kd.show();
			//int k = kd.getNumCellsOccupied();
			BoardState copy = kd.clone();
			int from = m.getFrom();
			int over = m.getOver();
			int to = m.getTo();
			copy.setFilled(from, false);
			copy.setFilled(over, false);
			copy.setFilled(to, true);
			kd = copy;
		}
		kd.show();
	}
	
	public static Pair<List<Move>, BoardState> puzzle(int i) {
		BoardState kd = new BoardState(i);
		List<Pair<List<Move>, BoardState>> result = solve(kd);
		Pair<List<Move>, BoardState> first = result.get(0);
		Pair<List<Move>, BoardState> r = new Pair<List<Move>, BoardState>(first.getFirst(), kd);
		return r;
	}
	
	public static List<Pair<List<Move>, BoardState>> solve(BoardState kd) {
		int k = kd.getNumCellsOccupied();
		if(k < 2) {
			Pair<List<Move>, BoardState> p = new Pair<List<Move>, BoardState>(new ArrayList<Move>(), kd);
			List<Pair<List<Move>, BoardState>> result = new ArrayList<Pair<List<Move>, BoardState>>();
			result.add(p);
			return result;
		}
		else {
			List<Pair<List<Move>, BoardState>> result = new ArrayList<Pair<List<Move>, BoardState>>();
			for(Move m : step()) {
				BoardState kc = move(kd, m);
				if(kc != null) {
					List<Pair<List<Move>, BoardState>> r =  solve(kc);
					for(Pair<List<Move>, BoardState> p : r) {
						List<Move> ms = p.getFirst();
						ms.add(0, m);
						result.add(p);
					}
				}
			}
			return result;
		}
	}
	
	public static void go() {		
		for(int i = 0; i < 5; i++) {
			System.out.printf("=== %d ===\n", i);
			Pair<List<Move>, BoardState> result = puzzle(0);
			List<Move> ms = result.getFirst();
			BoardState kd = result.getSecond();
			replay(ms, kd);
		}				
	}
}
