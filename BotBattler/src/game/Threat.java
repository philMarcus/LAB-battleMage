package game;

//This class represents the threat the player is facing this turn.
//Threat is represented as incoming damage from the four different quadrants
// 1: top right
// 2: top left
// 3: bottom left
// 4. bottom right
//
//If the player's action doesn't block or reduce the threat, the player will take the total
//damage from all quadrants.
//
public class Threat {

	// array containing incoming damage for each quadrant
	private int[] vals;

	// The number of sides on the die to roll to determine the base threat in each
	// quadrant
	private final int baseThreat = 8;

	// Every x turns, one quadrant will have extra "spike" threat!
	private final int spikeFrequency = 3;

	// When there's "spike" threat, this is how many extra dice to roll
	private final int spikeDice = 8;

	// every x levels, increase the sides of the threat die.
	private final int threatIncreaseFrequency = 5;

	//the level of the threat.
	private int level;

	//constructor for threat of a given level
	public Threat(int level) {

		this.level = level;

		// There are always four quadrants, so a size four array will store the threat.
		vals = new int[4];

		// roll a die for the threat in each quadrant
		for (int i = 0; i < 4; i++) {
			vals[i] = rollDie(baseThreat + (level / threatIncreaseFrequency));
		}

		// Sometimes, a quadrant will have extra "spike" threat.
		if (rollDie(spikeFrequency) == spikeFrequency) {
			// choose a random quadrant
			int q = rollDie(4);
			// add spike threat to that quadrant
			vals[q - 1] += rollDice(baseThreat + (level / threatIncreaseFrequency), spikeDice);
		}

	}
	
	//constructor for cloned threat
	public Threat(Threat toClone) {
		this.level = toClone.level;
		vals = new int[4];
		for(int i=0;i<4;i++) {
			this.vals[i] = toClone.getQuadrantThreat(i+1);
		}
	}
	
	

	// rolls an x-sided die
	// returns a random int between 1 and sides
	public static int rollDie(int sides) {
		return (int) (Math.random() * sides + 1);
	}

	// rolls any number of x-sided dice
	public static int rollDice(int sides, int num) {
		int sum = 0;
		// This calls the rollDie method, num times.
		for (int i = 0; i < num; i++) {
			sum += rollDie(sides);
		}
		return sum;
	}

	// returns the threatened damage in quadrant q
	public int getQuadrantThreat(int q) {
		return vals[q - 1];
	}

	// returns the total threat across all quadrants
	public int getTotalThreat() {
		int t = 0;
		for (int i = 0; i < 4; i++) {
			t += vals[i];
		}
		return t;
	}

	// reduces the threat from the quadrants listed in the q array,
	// to a fraction equal to pct.
	// Returns how much threat was removed
	public int reduceThreat(int[] q, double pct) {
		int initialThreat = getTotalThreat();

		// loop over the passed quadrants and multiply threat by the passed percentage
		// (automatically truncating threat to an integer)
		for (int i = 0; i < q.length; i++) {
			vals[q[i] - 1] *= pct;
		}
		return initialThreat - getTotalThreat(); // the amount removed is the initial threat minus the current threat
	}

	public int getLevel() {
		return level;
	}

	@Override
	public String toString() {
		String s = "THREAT " + getTotalThreat() + ":\n";
		s += "==============\n";
		s += "||  " + vals[1] + " || " + vals[0] + "  ||\n";
		s += "==============\n";
		s += "||  " + vals[2] + " || " + vals[3] + "  ||\n";
		s += "==============\n";

		return s;
	}


}
