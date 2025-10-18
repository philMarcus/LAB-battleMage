
package characters;

import actions.Action;
import actions.Attack;
import actions.Block;
import actions.Direction;
import game.Opponent;
import game.Resource;
import game.Threat;
import java.util.HashMap;

public class Nixon implements Character {

	private Resource hp;
	private Resource stamina;

	public Nixon() {
		hp = new Resource("HP", 180);
		stamina = new Resource("Stamina", 20);

	}

	@Override
	// this will return an Attack action if the total threat is less than 30.
	// and will return a Block action in the UP direction otherwise.
	//
	// Bad blocker should look closer at Threat and learn to block.
	//
	// Both actions use the stamina resource.
	public Action takeTurn(Threat threatInfo, Opponent oppInfo) {
		if (threatInfo.getTotalThreat() < 30)
			return new Attack(1, stamina);
		
		HashMap<String, Integer[]> list = new HashMap<String, Integer[]>();
		Integer[] up = {1,2};
		Integer[] down = {3,4};
		Integer[] left = {2,3};
		Integer[] right = {1,4};
		
		list.put("UP", up);
		list.put("DOWN", down);
		list.put("LEFT", left);
		list.put("RIGHT", right);
		
		// determine which direction to block
		String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
		int highestDamage = Integer.MIN_VALUE;
		Direction directionToBlock = null;
		
		for (String direction : directions) {
			int damage = 0;
			for (int quadrant : list.get(direction)) {
				damage += threatInfo.getQuadrantThreat(quadrant);
			}
			
			if (damage > highestDamage) {
				highestDamage = damage;
				if (direction.equals("UP")) {
					directionToBlock = Direction.UP;
				}
				else if (direction.equals("DOWN")) {
					directionToBlock = Direction.DOWN;
				}
				else if (direction.equals("LEFT")) {
					directionToBlock = Direction.LEFT;
				}
				else {
					directionToBlock = Direction.RIGHT;
				}
			}
		}
		
		return new Block(directionToBlock, stamina);
	}

	@Override
	// this method returns the Resource object to be used as hit points.
	// This is the resource that will be reduced by unblocked threat
	// Bad Blocker will die when he runs out of this resource.
	public Resource getHitPointResource() {
		return hp;
	}

	@Override
	// This method returns Bad Blocker's name
	public String toString() {
		return "Nixon";
	}

}