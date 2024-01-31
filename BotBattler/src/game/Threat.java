package game;

public class Threat {

	//array containing incoming damage for each quadrant
	private int[] vals;
	
	public int getQuadrantThreat(int q) {
		return vals[q];
	}
	
}
