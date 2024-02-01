package characters;

import actions.Action;
import game.Opponent;
import game.Resource;
import game.Threat;

//The game of battleMage is played by writing a Java class to
//implement this character interface and then constructing an
//instance of your character in the arena to see how many increasingly
//tough battles it can survive.
//
//WHO WILL WRITE THE STRONGEST BATTLEMAGE?!?!?
//
public interface Character {

	public Resource getHitPointResource();

	public Action takeTurn(Threat threatInfo, Opponent oppInfo);

}
