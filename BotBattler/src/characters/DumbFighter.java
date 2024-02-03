package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;

//This example class represents a very bad fighter. His strategy is to block if the threat is greater 
//than 30, and to attack with a power of 1 otherwise. This fighter is very unlikely to
//win any battles. You can do better!
public class DumbFighter implements Character {

	private Resource hp = new Resource("HP", 180);
	private Resource stamina = new Resource("Stamina", 20);

	@Override
	public String getName() {

		return "Dumb Fighter";
	}

	@Override
	public Resource getHitPointResource() {

		return hp;
	}

	@Override
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);

		return new Block(Direction.UP, stamina);

	}

}
