package characters;

import actions.Action;
import game.Opponent;
import game.Resource;
import game.Threat;

//The game of battleMage is played by writing a Java class to
//implement this character interface and then constructing an
//instance of your character in the arena to see how many increasingly
//tough opponents it can survive.
//
//WHO WILL WRITE THE STRONGEST BATTLEMAGE?!?!?
//
//To implement this interface, make sure of two things:
//
//1) your class header has "implements Character"
//e.g. "public class YourClass implements Character{..."
//and
//2) Your class must contain the methods listed below, using the signatures exactly
//as written here.
//
//Everything else is up to you!
public interface Character {

	public Resource getHitPointResource();

	public Action takeTurn(Threat threatInfo, Opponent oppInfo);

}
