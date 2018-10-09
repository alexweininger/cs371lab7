package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

public class SmartComputerPlayer extends GameComputerPlayer {


	public SmartComputerPlayer(String name) {
		super(name);
	}

	@Override
	protected void receiveInfo(GameInfo info) {
		if (info instanceof PigGameState) {
			PigGameState g = (PigGameState) info;
			if (g.getTurnId() != this.playerNum) {
				return;
			}

			int value = 6;

			if(g.getPlayer1Score() - g.getPlayer0Score() < 0) {
				value = 10;
			}

			boolean roll = (g.getCurrentRunningTotal() < value)? true:false;

			sleep(1500);
			if (!roll) {
				PigHoldAction a = new PigHoldAction(this);
				game.sendAction(a);
				return;
			} else {
				PigRollAction a = new PigRollAction(this);
				game.sendAction(a);
				return;
			}
		}
	}
}
