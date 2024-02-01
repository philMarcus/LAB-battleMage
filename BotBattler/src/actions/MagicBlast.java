package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class MagicBlast implements Action {
	private Resource res; // the resource used to pay the cost of the action

	public MagicBlast(Resource r) {
		res = r;
	}

	@Override
	//Magic Blasts costs 10 of any resource
	// returns true if cost is payable and paid.
	public boolean payCost() {
		return res.pay(10);
	}

	@Override
	//Magic Blast blasts away a third of opponent's remaining hit points! (Plus or minus damage from magical vulnerability!)
	public void resolve(Threat t, Opponent o) {
		//use math.ceil to always round up the damage to the nearest integer
		//if the opponent has 1 hp, magic blast should finish them off!
		int damage = (int)Math.ceil(o.getHitPoints()/3);
		o.takeDamage(damage + o.getMagicalVulnerablility());
	}

	public Resource getResource() {
		return res;
	}

}
