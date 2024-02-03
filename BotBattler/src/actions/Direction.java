package actions;

//this type defines the blocking directions and which quadrants they cover.
//Each direction is given parameters that are used in the constructor.
public enum Direction {
	UP(1, 2, "high"), // the top half is quadrants 1 & 2
	DOWN(3, 4, "low"), // the bottom half is quadrants 3 & 4
	LEFT(2, 3, "to the left"), // the left half is quadrants 2 & 3
	RIGHT(1, 4, "to the right"); // the right half is quadrants 1 & 4

	private final int[] quadrants;
	private final String s; // this holds the string description of the direction

	Direction(int qa, int qb, String adj) {
		int[] q = { qa, qb };
		this.quadrants = q;
		this.s = adj;
	}

	public int[] getQuadrants() {
		return quadrants;
	}

	public String toString() {
		return s;
	}
}
