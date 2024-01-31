package game;

public class Resource {

	private final int maxValue;
	private int value;
	private final String name;
	
	public Resource(String n, int max) {
		name = n;
		maxValue = max;
		value = max;	
	}
	
	//returns true if cost is paid, or false if value isn't enough to pay
	public boolean pay(int cost){
		//can't pay if value < cost.
		if (cost > value) return false;
		
		value -= cost;
		return true;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		String s = name;
		s+=": " + value+ "\n";
		
		//display "resource bar", one full pip for every 10% remaining
		double d = 10*value/maxValue;
		int showFull = (int)d;
		for (int i=0;i<showFull;i++) {
			s+="@";
		}
		for (int i=10;i>showFull;i--) {
			s+=".";
		}
		return s+"\n";
	}
	
}
