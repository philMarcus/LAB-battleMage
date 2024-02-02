package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class MagicBlast implements Action {
	private Resource res; // the resource used to pay the cost of the action
	private int damage; //the amount of damage this blast does
	private int cost = 10; //the resource cost of performing the blast

	public MagicBlast(Resource r) {
		res = r;
	}

	@Override
	//Magic Blasts always costs 10 of any resource
	// returns true if cost is payable and paid.
	public boolean payCost() {
		return res.pay(cost);
	}

	@Override
	//Magic Blast blasts away a third of opponent's remaining hit points! (Plus or minus damage from magical vulnerability!)
	public void resolve(Threat t, Opponent o) {
		//use math.ceil to always round up the damage to the nearest integer
		//if the opponent has 1 hp, magic blast should finish them off!
		damage = (int)Math.ceil(o.getHitPoints()/3) + o.getMagicalVulnerablility();
		o.takeDamage(damage);
	}

	public Resource getResource() {
		return res;
	}
	
	public String toString() {
		return "casts Magic Blast for "+damage+" damage, at a cost of "+cost+". "+res.toString();
	}

}
