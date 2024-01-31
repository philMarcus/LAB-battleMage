package actions;
import game.Opponent;
import game.Resource;
import game.Threat;

public class Block implements Action {
	

	

	private Resource r; //the resource used to pay the cost of the action
	
	@Override
	//Block costs 1 of any resource with a value of 20 or less.
	public boolean payCost() {
		// resource must be <=20 to use block
		if (r.getValue() > 20) return false; 
	
		return r.payCost(1);

	}

	@Override
	//Block removes all threat from either TOP, BOTTOM, LEFT, or RIGHT half
	public void resolve(Threat t, Opponent o) {
		// TODO Auto-generated method stub

	}

}
