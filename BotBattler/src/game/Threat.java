package game;

public class Threat {

	//array containing incoming damage for each quadrant
	private int[] vals;
	
	//returns the threatened damage in quadrant q
	public int getQuadrantThreat(int q) {
		return vals[q];
	}
	
	//reduces the threat from the quadrants listed in the q array,
	//to a fraction equal to pct.
	public void reduceThreat(int[] q, double pct) {
		for (int i=0;i <q.length;i++) {
			vals[q[i]] *= pct;
		}
	}
	
}
