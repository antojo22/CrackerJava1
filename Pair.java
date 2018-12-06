/**
 * A utility class to store a pair of two objects
 */
public class Pair<X,Y> {
	private X first;
	private Y second;
	
	public Pair(X first, Y second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * @return the first
	 */
	public X getFirst() {
		return first;
	}

	/**
	 * @return the second
	 */
	public Y getSecond() {
		return second;
	}
		
}
