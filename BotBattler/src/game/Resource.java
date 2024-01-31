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
	public boolean payCost(int cost){
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
	
	
}
