package game;

//This class represents a spendable resource in the game. All characters must select
//one resource as their hitPoints. In your character class, other resources may 
//be declared, initialized, and used to pay for actions. Remember, the rule of the game is
//the maxValue of all your resources can't be greater than 200 total!
public class Resource {

	private final int maxValue; //starting value of the resource
	private int value; //current value of the resource
	private final String name; //name of the resource
	private boolean unspent; // whether this resource has yet to be spent

	public Resource(String n, int max) {
		name = n;
		maxValue = max;
		value = max;
		unspent = true; // new resources are unspent
	}

	// returns true if cost is paid, or false if value isn't enough to pay
	// also sets "unspent" flag to false
	public boolean pay(int cost) {
		// can't pay if value < cost.
		if (cost > value)
			return false;

		value -= cost;
		unspent = false; // flag that this resource has been used
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

	@Override
	public String toString() {
		String s = name;
		s += ": " + value + " ";

		// display "resource bar", one full pip for every 10% remaining
		double d = 10 * value / maxValue;
		int showFull = (int) d;
		for (int i = 0; i < showFull; i++) {
			s += "@";
		}
		// "empty" pips, one for every 10% used
		for (int i = 10; i > showFull; i--) {
			s += ".";
		}
		return s + "\n";
	}

	public boolean isUnspent() {
		return unspent;
	}

}
