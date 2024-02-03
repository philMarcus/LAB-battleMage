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
//His strategy is to block upwards if the total threat is greater 
//than 30, and to attack with a power of 1 otherwise. This fighter is very unlikely to
//win any battles. You can do better!
public class DumbFighter implements Character {

	//Dumb, but not dumb enough to use more than 200 points of total resources!
	
	//hitPoints resource. Gotta have one!
	private Resource hp = new Resource("HP", 180);
	
	//will use stamina to perform Block and Attack actions
	private Resource stamina = new Resource("Stamina", 20);

	@Override
	// This method returns the Dumb Fighter's name
	public String toString() {

		return "Dumb Fighter";
	}

	@Override
	// this method returns the Resource object used as hit points.
	public Resource getHitPointResource() {
		return hp;
	}

	@Override
	//this will return an Attack action if the total threat is less than 30.
	//it will return a Block action in the UP direction otherwise.
	//Both actions use the stamina resource.
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);

		return new Block(Direction.UP, stamina);

	}

}
