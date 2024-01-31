package actions;
import game.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;

public class Block implements Action {
	

	
	private Direction direction;
	private Resource res; //the resource used to pay the cost of the action
	
	public Block(Direction d, Resource r) {
		direction = d;
		res = r;
	}
	
	@Override
	//Block costs 1 of any resource with a value of 20 or less.
	public boolean payCost() {
		// resource must be <=20 to use block
		if (res.getValue() > 20) return false; 
	
		return res.payCost(1);
	}

	@Override
	//Block removes all threat from either TOP, BOTTOM, LEFT, or RIGHT half
	public void resolve(Threat t, Opponent o) {
		
		t.reduceThreat(direction.getQuadrants(), 0.0);

	}

}
