package game;

import java.util.Scanner;

import actions.Action;
import actions.MagicBlast;
import characters.Character;


//This class represents a single battle between the player's class
//and the Opponent
public class Battle {
	// player is an instance of a class that implements the Character interface
	private Character player;

	// The Opponent the player is battling
	private Opponent opp;
	
	//the level of the threat/opponent
	private int level;

	// The threat, by quadrant, that the player is facing
	private Threat currentThreat;

	// The resource that's tracking player's HP
	private Resource playerHP;

	// keeps track of total resources used by player. Too many and you're
	// disqualified!
	private int totalResources;

	// If totalResources exceeds this value, player is disqualified and loses!
	private final int maxTotalResources = 200;

	// number of turn this battle has lasted so far;
	private int turn;

	// true if the battle is finished
	private boolean isOver = false;

	// true if the player has won the battle;
	private boolean playerWin = false;

	// input from the user, only used to press Enter between turns.
	private Scanner input = new Scanner(System.in);

	public Battle(Character p, int level) {
		this.level = level;
		player = p;
		opp = new Opponent(level);
		currentThreat = new Threat(level);
		playerHP = player.getHitPointResource();
		
		//player hit points count towards the 200 resources!
		totalResources = playerHP.getMaxValue();

		// A new battle will reset the Magic Blast counter.
		MagicBlast.resetUses();
	}

	// executes a turn of the battle. Returns a string containing the results of the
	// turn.
	public String playTurn() {
		// turnLog stores a description of the turn
		String turnLog = "Turn " + turn + " results:\n";
		turnLog += currentThreat.toString();
		turnLog += opp.toString() + "\n";
		turnLog += player.toString() + " ";

		// get the player's choice of action.
		// this is when your decision-making method actually gets called.
		//we pass clones of the Threat and Opponent objects, so the player's class can't
		// directly change the threat or remove hitpoints from the opponent
		Action action = player.takeTurn(new Threat(currentThreat), new Opponent(opp));

		
		// before we pay the action's cost and resolve the action, cheater check:
		// if we haven't spent this resource before, (and it's not the player's HP),
		// add it's maxValue to total resources. This is so we can check that the player
		// isn't cheating by using too many resources.
		Resource res = action.getResource();
		if (res.isUnspent() && !res.equals(playerHP))
			totalResources += res.getMaxValue();
		// check for too many resources, and disqualify if need be
		if (totalResources > maxTotalResources) {
			isOver = true;
			return turnLog + "is disqualified for having too many reources. Lose.\n";
		}

		// Pay the cost. If it gets paid, do the action! (and update the log)
		if (action.payCost()) {
			action.resolve(currentThreat, opp);
			turnLog += action.toString();
		} else
			turnLog += "does nothing. Can't afford the " + res.getName() + ".\n";

		// if the opponent is out of HP, player wins!
		if (!opp.isAlive()) {
			playerWin = true;
			isOver = true;
			return turnLog += "The opponent has been defeated! Win.\n";
		}

		// player takes damage equal to remaining threat,
		// or, if not enough hp, takes damage equal to all remaining hp
		int dmg = Math.min(currentThreat.getTotalThreat(), playerHP.getValue());
		playerHP.pay(dmg);

		turnLog += player.toString() + " takes " + dmg + " damage. ";
		turnLog += playerHP.toString();

		// If the player is out of hit points, it's over!
		if (playerHP.getValue() <= 0) {
			isOver = true;
			turnLog += player.toString() + " dies. Lose.\n";
		}
		// generate a new random threat and vulnerability
		currentThreat = new Threat(level);
		opp.newVulnerability();

		return turnLog;
	}

	// runs a battle. Loops over playTurn until the battle is over.
	// will print a log to the console if print is true
	// will wait for user to hit Enter between turns if dramaticPause is true.
	// returns true for player victory, false for a loss
	public boolean doBattle(boolean print, boolean dramaticPause) {

		while (!isOver) {
			// increase turn count
			turn++;
			
			// play the turn. store the log in string s.
			String s = playTurn();
			
			//print and wait for user to hit enter, if the methods parameters are "true"
			if (print)
				System.out.println(s);
			if (dramaticPause)
				input.nextLine();
		}
		return playerWin;
	}

	public Character getPlayer() {
		return player;
	}

	public Threat getCurrentThreat() {
		return currentThreat;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isOver() {
		return isOver;
	}

	public boolean isPlayerWin() {
		return playerWin;
	}

}
