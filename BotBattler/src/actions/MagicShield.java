package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class MagicShield implements Action {

	private Resource res;// The resource used to pay for the attack
	private int power; // how many times the shield removes half of remaining threat

	public MagicShield(int pow, Resource r) {
		power = pow;
		res = r;
	}

	@Override
	// Magic Shields cost 2^power, where power is the number of times the player gets
	// "shielded"
	public boolean payCost() {
		return res.pay((int) Math.pow(2, power));
	}

	@Override
	
	//Magic Shield reduces all remaining threat by half, once for each unit of power
	public void resolve(Threat t, Opponent o) {
		
		int[] allQuadrants = {1,2,3,4}; //Magic Shield acts on threat from all quadrants
		t.reduceThreat(allQuadrants ,Math.pow(0.5,power));

	}

}
