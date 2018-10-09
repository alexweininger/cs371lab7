package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

	private int turnId;
	private int player0Score;
	private int player1Score;
	private int currentRunningTotal;
	private int dieValue;

	public PigGameState() {
		this.turnId = 0;
		this.player0Score = 0;
		this.player1Score = 0;
		this.currentRunningTotal = 0;
		this.dieValue = 1;
	}

	public PigGameState(PigGameState g) {
		this.turnId = g.turnId;
		this.player0Score = g.player0Score;
		this.player1Score = g.player1Score;
		this.currentRunningTotal = g.currentRunningTotal;
		this.dieValue = g.dieValue;
	}

	public int getTurnId() {
		return turnId;
	}

	public void setTurnId(int turnId) {
		this.turnId = turnId;
	}

	public int getPlayer0Score() {
		return player0Score;
	}

	public void setPlayer0Score(int player0Score) {
		this.player0Score = player0Score;
	}

	public int getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}

	public int getCurrentRunningTotal() {
		return currentRunningTotal;
	}

	public void setCurrentRunningTotal(int currentRunningTotal) {
		this.currentRunningTotal = currentRunningTotal;
	}

	public int getDieValue() {
		return dieValue;
	}

	public void setDieValue(int dieValue) {
		this.dieValue = dieValue;
	}


}
