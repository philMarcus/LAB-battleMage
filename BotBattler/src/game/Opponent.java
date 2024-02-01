package game;

//this class represents the opponent that the player character is fighting
public class Opponent {

	private int hitPoints;
	
	//an array containing the incoming damage to each quadrant
	private Threat currentThreat;
	
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
		//reduce hp by passed damage
		hitPoints -= damage;
	}
	public boolean isAlive() {
		return (hitPoints > 0);
	}
	
	public int getPhysicalVulnerablility() {
		return vulnerability;
	}
	
	public int getMagicalVulnerablility() {
		return -1*vulnerability;
	}


	public int getHitPoints() {
		return hitPoints;
	}
	
	
	
}
