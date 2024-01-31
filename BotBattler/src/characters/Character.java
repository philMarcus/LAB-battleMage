package characters;
import actions.Action;
import game.Resource;
import game.Threat;

public interface Character {

	public Resource getHitPoints();
	
	public Action takeTurn(Threat t);
	
}
