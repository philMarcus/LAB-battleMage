package game;

//this class represents the opponent that the player character is fighting
//the player's character class will probably want to use information
//like the opponents hit points, level, and physical/magical vulnerability when deciding
//which action to choose.
public class Opponent{

	private int hitPoints;
	private int maxHP = 100; // opponent's starting hit points (at level 1)
	private int maxV = 4; // sets numerical range of opponent's vulnerabilities

	// a positive vulnerability will increase physical damage, but decrease magical
	// damage
	// a negative vulnerability will do the opposite.
	private int vulnerability;

	// the level of the opponent: higher level will have bigger threat
	// and/or more hit points
	private int level;
	
	//constructor for an opponent of a given level
	public Opponent(int level) {
		this.level = level;
		//opponent gains one HP per level after 1.
		hitPoints = maxHP + level - 1;
		newVulnerability();
	}
	
	//constructor to make a cloned opponent
	public Opponent(Opponent toClone) {
		this.level = toClone.level;
		this.hitPoints = toClone.getHitPoints();
		this.vulnerability = toClone.getPhysicalVulnerablility();
		
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
			for (int i = Math.abs(vulnerability); i > 1; i--) {
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


}
