package game;

public enum Direction {
	UP(1,2),  //the top half is quadrants 1 & 2
	DOWN(3,4), //the bottom half is quadrants 3 & 4
	LEFT(2,3), //the left half is quadrants 2 & 3
	RIGHT(1,4); //the right half is quadrants 1 & 4
	
	private final int[] quadrants;
	
	Direction(int qa, int qb){
		quadrants = new int[1];
		this.quadrants[0] = qa;
		this.quadrants[1] = qb;
	}
	
	public int[] getQuadrants() {
		return quadrants;
	}
}
