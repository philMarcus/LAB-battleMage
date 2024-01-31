package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class Attack implements Action {
	private int numHits;  //how many hits the attack will make
	private Resource res; //The resource used to pay for the attack
	//the level of the opponent, higher level will have bigger threat
	// and/or more hit points
	private int level; 
	
	public Attack(int n, Resource r) {
		numHits = n;
		res = r;
	}
	
	@Override
	//Attack cost 2^x, where x is the number of hits
	public boolean payCost() {
		// TODO Auto-generated method stub
		return res.payCost((int)Math.pow(2, numHits));
	}

	@Override
	public void resolve(Threat t, Opponent o) {
		// TODO Auto-generated method stub

	}

}
