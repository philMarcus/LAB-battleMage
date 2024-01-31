package actions;
import game.Opponent;
import game.Resource;
import game.Threat;

public interface Action {
	
	//updates resource by decreasing cost of action, 
	//returns true is cost is payable and paid.
 public boolean payCost();
	
 public void resolve(Threat t, Opponent o);  
	
}
