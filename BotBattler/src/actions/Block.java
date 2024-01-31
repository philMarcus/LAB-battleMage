package actions;
import game.Resource;

public class Block implements Action {

	
	@Override
	
	//Block costs 1 of any resource with a value of 20 or less.
	public boolean payCost(Resource r) {
		// resource must be <=20 to use block
		if (r.getValue() > 20) return false; 
	
		return r.payCost(1);

	}

	@Override
	//Block removes all threat from either TOP, BOTTOM, LEFT, or RIGHT half
	public void resolve() {
		// TODO Auto-generated method stub

	}

}