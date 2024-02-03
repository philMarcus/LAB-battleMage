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

	Direction dir; // the best direction to block
	int blockableDmg; // the largest amount of dmg that could be blocked
	int unblockableDmg; // damage remaining after best block
	int dmgPerHit; // the amount of damage I'll do, considering vulnerabiltiy



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

		int[] ts = { q1, q2, q3, q4 };
		int maxIndex = 0;
		// find biggest quadrantial threat
		for (int i = 1; i < 4; i++) {
			if (ts[i] > ts[maxIndex])
				maxIndex = i;
		}
		blockableDmg = ts[maxIndex];
		int maxQ = maxIndex + 1;
		switch (maxQ) {
		case 1:
			if (q2 > q4) {
				blockableDmg += ts[1];
				return Direction.UP;
			} else {
				blockableDmg += ts[3];
				return Direction.RIGHT;
			}
		case 2:
			if (q3 > q1) {
				blockableDmg += ts[2];
				return Direction.LEFT;
			} else {
				blockableDmg += ts[0];
				return Direction.UP;
			}
		case 3:
			if (q2 > q4) {
				blockableDmg += ts[1];
				return Direction.LEFT;
			} else {
				blockableDmg += ts[3];
				return Direction.DOWN;
			}
		default:
			if (q3 > q1) {
				blockableDmg += ts[2];
				return Direction.DOWN;
			} else {
				blockableDmg += ts[0];
				return Direction.RIGHT;
			}
		}

	}

	@Override

	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		// calculate calculable variables for analysis,
		// the things we want to know to make a good decision.

		// get the best direction to block, also sets blockableDmg;
		dir = chooseDir(threatInfo);
		unblockableDmg = threatInfo.getTotalThreat() - blockableDmg;

		dmgPerHit = 10 + oppInfo.getPhysicalVulnerablility();
		int affordPowerStamina; // how much power we can afford with stamina;
		int affordPowerHP;// how much power we can afford if we pay with HP;
		int myHP = hp.getValue();
		int myStam = stamina.getValue();
		int oppHp = oppInfo.getHitPoints(); // opponent hp

	}
	
	@Override
	public String toString() {
		return "Mr. Marcus";
	}

}
