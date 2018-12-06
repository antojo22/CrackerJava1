/**
 * This class model the details of a move in the cracker game.
 */
public class Move {
	private int from;
	private int over;
	private int to;
	
	public Move(int from, int over, int to) {
		this.from = from;
		this.over = over;
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * @return the over
	 */
	public int getOver() {
		return over;
	}

	/**
	 * @return the to
	 */
	public int getTo() {
		return to;
	}
	
}
