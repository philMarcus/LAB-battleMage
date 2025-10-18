package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;

//This example class represents a fighter who is very bad at blocking. 
//But they at least get a D- for compiling && not being copied from another student!!1
//
//The strategy is to block upwards if the total threat is greater 
//than 30, and to attack with a power of 1 otherwise. This fighter won't win many battles.
//You can do better!
//
public class BadBlocker implements Character {

	// hitPoints resource. Gotta have one!
	private Resource hp;

	// will use stamina to perform Block and Attack actions
	private Resource stamina;

	public BadBlocker() {
		// Bad blocker is bad, but not bad enough to use more than 200 points of total
		// resources!
		hp = new Resource("HP", 180);
		stamina = new Resource("Stamina", 20);

	}

	@Override
	// this will return an Attack action if the total threat is less than 30.
	// and will return a Block action in the UP direction otherwise.
	//
	// Bad blocker should look closer at Threat and learn to block.
	//
	// Both actions use the stamina resource.
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);

		return new Block(Direction.UP, stamina);

	}

	@Override
	// this method returns the Resource object to be used as hit points.
	// This is the resource that will be reduced by unblocked threat
	// Bad Blocker will die when he runs out of this resource.
	public Resource getHitPointResource() {
		return hp;
	}

	@Override
	// This method returns Bad Blocker's name
	public String toString() {
		return "Bad Blocker";
	}

}
