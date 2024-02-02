package game;

import characters.TestFighter;

public class BattleMageArena {

	public static void main(String[] args) {
		
		TestFighter player = new TestFighter();
		Battle battle = new Battle(player);
		battle.doBattle(true, true);

	}

}
