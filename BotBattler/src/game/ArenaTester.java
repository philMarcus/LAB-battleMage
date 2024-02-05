package game;

import characters.BadBlocker;
import characters.DumbFighter;
import characters.GoodBlockerFighter;
import characters.SadMage;

public class ArenaTester {
	private static int wins;
	private static int num = 100000;

	public static void main(String[] args) {
		for (int i = 0; i < num; i++) {
			DumbFighter player = new DumbFighter();
			Battle b = new Battle(player);
			if (b.doBattle(false, false)) {
				wins++;
				System.out.println(player.toString() + " gets win " + wins + " in game " + (i + 1) + "  "
						+ ((double) wins / (i + 1)));
			}
		}
		System.out.println("Final score:" + wins + "/" + num + "  " + ((double) wins / num));

	}
}
