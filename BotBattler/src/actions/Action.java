package actions;
import game.Resource;

public interface Action {
	
	//updates resource by decreasing cost of action, 
	//returns true is cost is payable and paid.
 public boolean payCost(Resource r);
	
 public void resolve();  
	
}
