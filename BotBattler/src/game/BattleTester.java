package game;

import characters.DumbFighter;
import characters.GoodBlockerFighter;
import characters.SadMage;
import characters.TestFighter;

// The game of battleMage is played by writing a Java class to
//implement the Character interface and then constructing an
//instance of your character in the arena to see how many increasingly
//tough opponents it can survive.
//
//Designed for Revere High School AP CS A students who have completed through Unit 5 (writing classes)
//
//WHO WILL WRITE THE STRONGEST BATTLEMAGE?!?!?
//
//To implement the interface, just make sure of two things:
//
//1) your class header has "implements Character"
//for example,  "public class YourClass implements Character {..."
//and
//2) Your class must contain the methods listed below, using the signatures exactly
//as written here.
//
//Everything else is up to you!
//
//by Marcus
//
//This class tests a character in a battle.
public class BattleTester {

	public static void main(String[] args) {

		// create a player of the DumbFighter class
		// ******************!!!************************
		// Replace DumbFighter with your class to play!!!
		// ******************!!!************************
		DumbFighter player = new DumbFighter();

		// create a new battle object feat. player
		Battle battle = new Battle(player);

		// do the battle, printing turn logs, and waiting for the user to hit Enter
		// between turns
		battle.doBattle(true, true);

	}

}
