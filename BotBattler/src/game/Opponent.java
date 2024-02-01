package game;

//this class represents the opponent that the player character is fighting
public class Opponent implements Cloneable {

	private int hitPoints;
	private final int maxHP = 100; // opponent's starting hit points (at level 1)
	private final int maxV = 4; // sets numerical range of opponent's vulnerabilities

	// a positive vulnerability will increase physical damage, but decrease magical
	// damage
	// a negative vulnerability will do the opposite.
	private int vulnerability;

	// the level of the opponent: higher level will have bigger threat
	// and/or more hit points
	// TODO increase difficulty with level
	private int level;

	public Opponent() {
		level = 1;
		hitPoints = maxHP;
		newVulnerability(maxV);
	}

	public void newVulnerability(int x) {
		// roll an x-sided die. Subtract 1 (so vulnerability can be zero).
		vulnerability = Threat.rollDie(x) - 1;

		// Vulnerability should be made negative half the time.
		// This is so there's equal chance of a physical or a magical vulnerability
		if (Threat.rollDie(2) == 2) {
			vulnerability *= -1;
		}
	}

	public void takeDamage(int damage) {
		// reduce opponent's hp by passed damage
		hitPoints -= damage;
	}

	public boolean isAlive() {
		return (hitPoints > 0);
	}

	// Physical attacks are increased by this amount. Watch out! If this is
	// negative, physical damage will be reduced!
	public int getPhysicalVulnerablility() {
		return vulnerability;
	}

	// Magical blast damage is increased by this amount. Watch out! If this is
	// negative, magical damage will be reduced!
	public int getMagicalVulnerablility() {
		return -1 * vulnerability;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		String s = "Level " + level + " opponent has " + hitPoints + " hit points remaining.\n";
		if (vulnerability == 0) {
			s += "Opponent has no specific vulnerability right now.\n";
		} else {
			s += "Opponent is ";
			for (int i = vulnerability; i > 1; i--) {
				s += "really ";
			}
			s += "vulnerable to ";
			if (vulnerability > 0)
				s += "physical attack damage ";
			else
				s += "magical blast damage ";
			s += "right now.\n";

		}
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {

	    return super.clone();
	}

}
