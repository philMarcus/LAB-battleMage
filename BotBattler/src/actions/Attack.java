package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class Attack implements Action {
	private int numHits;  //how many hits the attack will make
	private Resource res; //The resource used to pay for the attack

	private int damage=10;	//attacks do 10 base damage
	
	public Attack(int n, Resource r) {
		numHits = n;
		res = r;
	}
	
	@Override
	//Attacks cost 2^x, where x is the number of hits
	public boolean payCost() {
				return res.pay((int)Math.pow(2, numHits));
	}

	@Override
	//each hit in an attack damages for 10 plus the opponent's physical vulnerability
	public void resolve(Threat t, Opponent o) {
		o.takeDamage(numHits*(damage + o.getPhysicalVulnerablility()));
	}

	public int getNumHits() {
		return numHits;
	}

	public Resource getRes() {
		return res;
	}

	public int getDamage() {
		return damage;
	}

}
