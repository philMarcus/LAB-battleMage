package game;

import characters.TestFighter;

//This class tests a character in a battle.
public class BattleMageTester {

	public static void main(String[] args) {

		// create a player of the Test Fighter class
		TestFighter player = new TestFighter();
		// create a new battle object feat. player
		Battle battle = new Battle(player);
		// do the battle, printing turn logs, and waiting for the user to hit Enter
		// between turns
		battle.doBattle(true, true);

	}

}
