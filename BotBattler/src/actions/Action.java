package actions;

import game.Opponent;
import game.Threat;

public interface Action {

	// updates resource by decreasing cost of action,
	// returns true if cost is payable and paid.
	public boolean payCost();

	//do the action by having some effect on the opponent and/or threat
	public void resolve(Threat t, Opponent o);

}
