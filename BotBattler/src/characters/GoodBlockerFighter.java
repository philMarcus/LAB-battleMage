package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;


public class GoodBlockerFighter implements Character {


	private Resource hp = new Resource("HP", 180);
	private Resource stamina = new Resource("Stamina", 20);

	Direction dir; // the best direction to block

	@Override
	public Resource getHitPointResource() {
		return hp;
	}

	// returns the best direction to block and sets the blockableDmg attribute
	private Direction chooseDir(Threat t) {
		int q1 = t.getQuadrantThreat(1);
		int q2 = t.getQuadrantThreat(2);
		int q3 = t.getQuadrantThreat(3);
		int q4 = t.getQuadrantThreat(4);

		int[] threat = {q1, q2, q3, q4};
		int maxIndex = 0;
		// find biggest quadrantial threat
		for (int i = 1; i < 4; i++) {
			if (threat[i] > threat[maxIndex])
				maxIndex = i;
		}
		
		int maxQ = maxIndex + 1;
		switch (maxQ) {
		case 1:
			if (q2 > q4) {
				return Direction.UP;
			} else {
				return Direction.RIGHT;
			}
		case 2:
			if (q3 > q1) {
				return Direction.LEFT;
			} else {
				return Direction.UP;
			}
		case 3:
			if (q2 > q4) {
				return Direction.LEFT;
			} else {
				return Direction.DOWN;
			}
		default:
			if (q3 > q1) {
				return Direction.DOWN;
			} else {
				return Direction.RIGHT;
			}
		}

	}

	@Override

	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {

		// get the best direction to block
		dir = chooseDir(threatInfo);
	
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);

		return new Block(dir, stamina);

	}
	
	@Override
	public String toString() {
		return "Good Blocker";
	}

}
//Good blocker won one of the first few times tested. With one hit point left. 
//No spike damage occurred in that 10-turn game, which will
//happen (0.75)^10 or 5.6% of the time.
//
