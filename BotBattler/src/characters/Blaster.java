package characters;

import actions.Action;
import actions.MagicBlast;
import game.Opponent;
import game.Resource;
import game.Threat;

public class Blaster implements Character {
	
	Resource hp = new Resource("HP",200);

	@Override
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {

		return new MagicBlast(hp);
	}

	@Override
	public Resource getHitPointResource() {
	
		return hp;
	}
	
	public String toString() {
		return "Blaster";
	}

}
