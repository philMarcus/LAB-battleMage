package characters;

import actions.Action;
import actions.MagicBlast;
import actions.MagicShield;
import game.Opponent;
import game.Resource;
import game.Threat;

//sad mage is sad because they lose 99.9995% of the time.
//Can you write a magic-only character that can beat the opponent more regularly?
public class SadMage implements Character {


	private Resource hp;
	private Resource mana;

	public SadMage() {
		// sad mage's only joy is remembering not to use more than 200 total resources
		hp = new Resource("HP", 100);
		mana = new Resource("Mana", 100);
	}

	@Override
	// sad mage casts magic blast if the threat is below 30
	// otherwise, casts a magic shield.
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new MagicBlast(mana);

		return new MagicShield(2, mana);
	}

	@Override
	// sad mage's hp resource
	public Resource getHitPointResource() {
		return hp;
	}

	// a string with sad mage's name
	public String toString() {
		return "Sad Mage";
	}

}
