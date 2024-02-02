package game;

import actions.Action;
import characters.Character;

public class Battle {
	// player is an instance of a class that implements the Character interface
	private Character player;

	// The Opponent the player is battling
	private Opponent opp;

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

	public Battle(Character p) {
		player = p;
		opp = new Opponent();
		currentThreat = new Threat();
		playerHP = player.getHitPointResource();
		totalResources = playerHP.getMaxValue();
		turn = 1;
	}

	//executes a turn of the game. Returns a string containing the results of the turn.
	public String playTurn() {
		String turnLog = "Turn "+turn+" results:\n"+player.getName()+" "; //stores a description of the turn
		
		// get the player's choice of action.
		// pass clones of the Threat and Opponent objects, so the player class can't
		// directly change the threat or remove hitpoints from the opponent
		Action action = player.takeTurn(currentThreat.clone(), opp.clone());

		// before we pay the action's cost and resolve the action check:
		// if we haven't spent this resource before, and it's not the player's HP,
		// add the maxValue to total resources. This is so we can check that the player
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
		}
		else
			turnLog += "does nothing. Can't afford the "+res.getName()+".\n";

		// if the opponent is out of HP, player wins!
		if (!opp.isAlive()) {
			playerWin = true;
			isOver = true;
			return turnLog += "The opponent has been defeated! Win.\n";
		}

		// player takes damage equal to remaining threat
		playerHP.pay(currentThreat.getTotalThreat());
		turnLog += player.getName()+" takes "+currentThreat.getTotalThreat()+" damage.\n";

		// If the player is out of hit points, it's over!

		if (playerHP.getValue() <= 0) {
			isOver = true;
			turnLog += player.getName()+" dies. Lose.\n";
		}
		//generate a new random threat and vulnerability
		currentThreat = new Threat();
		opp.newVulnerability();
		
		return turnLog;
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
