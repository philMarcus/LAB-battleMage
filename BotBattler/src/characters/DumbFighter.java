package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;

//This example class represents a very bad fighter. 
//But he gets a D- for compiling && not being copied from another student!!1
//
//The strategy is to ...ATTACK EVERY TURN!!!
//Dumbfighter loses 99% of the time. You can do better!
public class DumbFighter implements Character {

	// hitPoints resource. Gotta have one!
	private Resource hp;

	// will use stamina to perform Block and Attack actions
	private Resource stamina;

	public DumbFighter() {
		// Dumb, but not dumb enough to use more than 200 points of total resources!
		hp = new Resource("HP", 180);
		stamina = new Resource("Stamina", 20);

	}

	@Override
	// This method returns the Dumb Fighter's name
	public String toString() {
		return "Dumb Fighter";
	}

	@Override
	// this method returns the Resource object used as hit points.
	// This is the resource that will be reduced by unblocked threat
	// Dumb Fighter will die when he runs out of this resource.
	public Resource getHitPointResource() {
		return hp;
	}

	@Override
	// this will always return an Attack action, spending stamina.
	//
	// Dumb Fighter is too dumb to even care about Threat.
	//
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		return new Attack(1, stamina);

	}

}
