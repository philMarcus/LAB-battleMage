
public class Resource {

	private final int maxValue;
	private int value;
	private final String name;
	
	public Resource(String n, int max) {
		name = n;
		maxValue = max;
		value = max;
	
	}
	
	public void payCost(int cost){
		value -= cost;
	}
	
	
}
