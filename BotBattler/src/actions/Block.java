package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class Block implements Action {

	private Direction direction;
	private Resource res; // the resource used to pay the cost of the action

	// Creates a Block action in the UP, DOWN, LEFT, or RIGHT direction, spending
	// Resource r
	public Block(Direction d, Resource r) {
		direction = d;
		res = r;
	}

	@Override
	// Blocking costs 1 of any resource with a value of 20 or less.
	// returns true if cost is payable and paid.
	public boolean payCost() {
		// resource must be <=20 to use block
		if (res.getValue() > 20)
			return false;

		return res.pay(1);
	}

	@Override
	// Block removes all threat from either top, bottom, left, or right half
	public void resolve(Threat t, Opponent o) {
		t.reduceThreat(direction.getQuadrants(), 0.0);
	}

}

//this type defines the blocking directions and which quadrants they cover.
enum Direction {
	UP(1,2),  //the top half is quadrants 1 & 2
	DOWN(3,4), //the bottom half is quadrants 3 & 4
	LEFT(2,3), //the left half is quadrants 2 & 3
	RIGHT(1,4); //the right half is quadrants 1 & 4

	private final int[] quadrants;

	Direction(int qa, int qb){
		int[] q = {qa, qb};
		this.quadrants = q;
	}

	public int[] getQuadrants() {
		return quadrants;
	}
}
