package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;

public class TestFighter implements Character {

	private Resource hp = new Resource("HP", 180);
	private Resource stamina = new Resource("Stamina", 20);
	
	public TestFighter() {
		
	}
	
	@Override
	public String getName() {
		
		return "Test Fighter";
	}

	@Override
	public Resource getHitPointResource() {

		return hp;
	}

	@Override
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1,stamina);
		
		return new Block(Direction.UP, stamina);
		
	}

}
