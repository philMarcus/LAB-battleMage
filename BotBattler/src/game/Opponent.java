package game;

//this class represents the opponent that the player character is fighting
public class Opponent {

	private int hitPoints;

	//a positive vulnerability will increase physical damage, but decrease magical damage
	//a negative vulnerability will do the opposite.
	private int vulnerability;

	//the level of the opponent: higher level will have bigger threat
	// and/or more hit points
	private int level;

	public void newTurn() {
		//TODO
		// create a new random Threat
		//randomize vulnerability
	}

	public void takeDamage(int damage) {
		//reduce opponent's hp by passed damage
		hitPoints -= damage;
	}

	public boolean isAlive() {
		return (hitPoints > 0);
	}

	//Physical attacks are increased by this amount. Watch out! If this is negative, physical damage will be reduced!
	public int getPhysicalVulnerablility() {
		return vulnerability;
	}

	//Magical blast damage is increased by this amount. Watch out! If this is negative, magical damage will be reduced!
	public int getMagicalVulnerablility() {
		return -1*vulnerability;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getLevel() {
		return level;
	}



}
