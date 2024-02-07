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
	int dmgPerHit; // the amount of damage I'll do, considering vulnerability
	
	//We'll track how many blasts we've used so that we can determine if we can afford them
	int usedMagicBlasts =0;



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
	
	//calculate the largest attack power that will keep
	//a minimum remaining value of the resource
	public static int affordAttack(Resource r, int minValue) {
		//increases n until
		for (int n=0;n<5;n++) {
			//n is not affordable
			if ((r.getValue()- minValue) < Math.pow(3,n)-2)
				//and returns the last affordable n
				return n-1;
		}
		return 0;
	}
	
	//calculate the largest attack power that will keep
	//a minimum remaining value of the resource
	public static int affordShield(Resource r, int minValue) {
		//increases n until
		for (int n=0;n<9;n++) {
			//n is not affordable
			if ((r.getValue()- minValue) < Math.pow(2,n))
				//and returns the last affordable n
				return n-1;
		}
		return 0;
	}
	
	//determine if the Magic Blast is can be afforded with a minimum
	//value of the resource remaining.
	public boolean canAffordBlast(Resource r, int minValue) {
		return(r.getValue()-minValue >= 10 - usedMagicBlasts);
	}
	
	//determines if we can block and have a minimum value of the resource remaining
	public static boolean canBlock(Resource r, int minValue) {
		//must have 20 or less of the resource as well as being able to afford the cost of 1.
		return ((r.getValue() <= 20)&&(r.getValue()-minValue >= 1));
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
		
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);

		return new Block(dir, stamina);

	}
	
	@Override
	public String toString() {
		return "Mr. Marcus";
	}

}
//this class stores an action, along with values to calculate it's
//delta-ratio
class analyzedAction{


	Action a; 
	int pi; //player's current hp
	int oi; //opponent's current hp
	int pf; //players hp after this action
	int of; //opponent's hp after this action.
	
	public analyzedAction(Action a, int pi, int oi, int pf, int of) {
		this.a = a;
		this.pi = pi;
		this.oi = oi;
		this.pf = pf;
		this.of = of;
	}


	
	int getScore() {
		//equivalent to the change in ratio of your to opp's HP as a result
		//of this action. Want to maximize.
		return pf*oi-pi*of;
	}
	
}
