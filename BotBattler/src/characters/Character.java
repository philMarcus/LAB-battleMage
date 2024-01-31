package characters;
import Resource;
import Threat;
import actions.Action;

public interface Character {

	public Resource getHitPoints();
	
	public Action takeTurn(Threat t);
	
}
