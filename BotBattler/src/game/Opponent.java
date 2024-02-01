package game;

//this class represents the opponent that the player character is fighting
//the player's character class will probably want to use information
//like the opponents hit points, level, and physical/magical vulnerability when deciding
//which action to choose.
//
//("implements Cloneable" is not important for the purposes of playing this game.)
public class Opponent implements Cloneable {

	private int hitPoints;
	private int maxHP = 100; // opponent's starting hit points (at level 1)
	private int maxV = 4; // sets numerical range of opponent's vulnerabilities

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
		newVulnerability();
	}

	public void newVulnerability() {
		// roll an x-sided die. Subtract 1 (so vulnerability can be zero).
		vulnerability = Threat.rollDie(maxV) - 1;

		// Vulnerability should be made negative half the time.
		// This is so there's equal chance of a physical or a magical vulnerability
		if (Threat.rollDie(2) == 2) {
			vulnerability *= -1;
		}
	}
	
	//this method reduces the opponent's hitpoints by damage amount
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

	public int getMaxHP() {
		return maxHP;
	}

	public int getMaxV() {
		return maxV;
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
	// The clone method comes from the Object class and allows us to clone an
	// Opponent
	// We want to clone the opponent so that the character class has all the info
	// about
	// the real opponent, but can't directly change it. Don't worry about this
	// method at all.
	protected Opponent clone() {
		try {
			return (Opponent) super.clone();
		} catch (CloneNotSupportedException e) {
			return new Opponent();
		}
	}

}
