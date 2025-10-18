package characters;
import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import actions.MagicBlast;
import game.Opponent;
import game.Resource;
import game.Threat;

public class Kaleb implements Character{
	private Resource hp;
	private Resource stamina; 
	private Resource mana;
	public Kaleb() {
		hp = new Resource("HP", 80);
		stamina = new Resource ("Stamina", 100);
		mana = new Resource ("Mana", 20);
	}
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		int direction = 0;
		int topDanger = threatInfo.getQuadrantThreat(1) + threatInfo.getQuadrantThreat(2);
		int downDanger = threatInfo.getQuadrantThreat(3) + threatInfo.getQuadrantThreat(4);
		int leftDanger = threatInfo.getQuadrantThreat(2) + threatInfo.getQuadrantThreat(3);
		int rightDanger = threatInfo.getQuadrantThreat(1) + threatInfo.getQuadrantThreat(4);
		//These variables find the total amount of damage in each direction.
		
		
		if (topDanger >= downDanger && topDanger >= rightDanger && topDanger >= leftDanger) {
			direction = 1;
		}
		else if (downDanger >= topDanger && downDanger >= rightDanger && downDanger >= leftDanger){
			direction = 3;
		}
		if (leftDanger >= rightDanger && leftDanger >= topDanger && leftDanger >= downDanger) {
			direction = 2;
		}
		else if (rightDanger >= leftDanger && rightDanger >= topDanger && rightDanger >= downDanger) {
			direction = 4;
		}
		//These if statements find which direction has the highest amount of total damage, and sets the direction variable to block it if its the highest.
		
		if (threatInfo.getTotalThreat() < 30) {
			int whichAtk = 0;
			if (oppInfo.getMagicalVulnerablility() > 0) {
				whichAtk = 1;
			}
			if (oppInfo.getPhysicalVulnerablility() > 0) {
				whichAtk = 2;
			}
			if (oppInfo.getMagicalVulnerablility() > oppInfo.getPhysicalVulnerablility()) {
				whichAtk = 1;
			}
			if (whichAtk == 1) {
				return new MagicBlast(mana);
			}
			else if (whichAtk == 2) {
				return new Attack(1, stamina);
			}
			
		}
		
	
			
		else if (direction == 1) {
			return new Block(Direction.UP, stamina);
			}
		else if(direction == 2) {
			return new Block(Direction.LEFT, stamina);
			}
		else if (direction == 3) {
			return new Block(Direction.DOWN, stamina);
			}
		else if (direction == 4) {
			return new Block(Direction.RIGHT, stamina);
		}
		/**If the combined damage on the board is over 30, goodBlocker will block based off of the variable that was set by the previous if statements. */
		
		
		
		return new Block(Direction.DOWN, stamina);
	}

	// This method is where you declare which resource represents your character's
	// hit Points
	// This is the resource that will be reduced by unblocked threat
	// When this resource runs out, your character loses.
	public Resource getHitPointResource() {
		return hp;
	}

	// This method just returns your charcter's name
	public String toString() {
		return "Best Fighter";
	}
}