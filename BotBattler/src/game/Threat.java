package game;

public class Threat {

	//array containing incoming damage for each quadrant
	private int[] vals;
	
	//The number of sides on the die to roll to determine the base threat in each quadrant
	private final int baseThreat = 10;
	
	//Every x turns, one quadrant will have extra threat!
	private final int spikeFrequency = 4; 
	
	//When there's "spike" threat, this is how many extra dice to roll
	private final int spikeDice = 5; 
	
	public Threat() {
		
		//There are always four quadrants, so a size four array will store the threat.
		vals = new int[4];
		
		//roll a die for the threat in each quadrant
		for(int i=0;i<4;i++) {
			vals[i] = rollDie(baseThreat);
		}
		
		//Sometimes, a quadrant will have extra "spike" threat.
		if (rollDie(spikeFrequency) == spikeFrequency) {
			//choose a random quadrant
			int q = rollDie(4);
			//add spike threat to that quadrant
			va
		}
		
	}
	
	//rolls an x-sided die
	//returns a random int between 1 and sides
	private int rollDie(int sides) {
		return (int)(Math.random()*sides +1);
	}
	
	//rolls any number of x-sided dice
	private int rollDice(int sides, int num ) {
		int sum = 0;
		for(int i=0;i<num;i++) {
			sum += rollDie(sides);
		}
		return sum;
	}

	//returns the threatened damage in quadrant q
	public int getQuadrantThreat(int q) {
		return vals[q-1];
	}

	//reduces the threat from the quadrants listed in the q array,
	//to a fraction equal to pct.
	public void reduceThreat(int[] q, double pct) {
		//loop over the passed quadrants and multiply threat by the passed percentage
		//(automatically truncating threat to an integer)
		for (int i=0;i <q.length; i++) {
			vals[q[i]-1] *= pct;
		}
	}

	@Override
	public String toString() {
		String s = "THREAT:\n";
		s += "==============================\n";
		s += "||  "+ vals[1] +" || "+ vals[0] +"  ||\n";
		s += "||  "+ vals[2] +" || "+ vals[3] +"  ||\n";
		s += "==============================\n";

		return s;
	}

}
