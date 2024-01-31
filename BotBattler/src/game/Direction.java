package game;

public enum Direction {

	UP  ({1,2}),
	DOWN  ({3,4}),
	LEFT  ({2,3}),
	RIGHT  ({1,4});
	
	private final int[] quadrants;
	
	Direction(int[] qs){
		this.quadrants = qs;
	}
}
