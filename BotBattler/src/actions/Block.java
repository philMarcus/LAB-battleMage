package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class Block implements Action {

	private Direction direction;
	private Resource res; // the resource used to pay the cost of the action
	private int reduced; //the amount of threat this block blocked

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
	// "reduced" variable is set to the amount of damage the block blocked
	public void resolve(Threat t, Opponent o) {
		reduced = t.reduceThreat(direction.getQuadrants(), 0.0);
	}

	public Resource getResource() {
		return res;
	}
	
	public String toString() {
		return "blocks "+direction.toString()+", reducing total threat by "+reduced+".\n";
	}

}

//this type defines the blocking directions and which quadrants they cover.
enum Direction {
	UP(1, 2, "high"), // the top half is quadrants 1 & 2
	DOWN(3, 4, "low"), // the bottom half is quadrants 3 & 4
	LEFT(2, 3,"to the left"), // the left half is quadrants 2 & 3
	RIGHT(1, 4,"to the right"); // the right half is quadrants 1 & 4

	private final int[] quadrants;
	private final String s; //this holds the string description of the direction

	Direction(int qa, int qb, String adj) {
		int[] q = { qa, qb };
		this.quadrants = q;
		this.s=adj;
	}

	public int[] getQuadrants() {
		return quadrants;
	}
	
	public String toString() {
		return s;
	}

}
