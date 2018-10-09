package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState gameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        gameState = new PigGameState();
        //TODO  You will implement this constructor
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == gameState.getTurnId()) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method

        if(action instanceof PigHoldAction) {
            if(gameState.getTurnId() == 1) {
                gameState.setPlayer1Score(gameState.getCurrentRunningTotal() + gameState.getPlayer1Score());
                gameState.setTurnId(0);
            } else {
                gameState.setPlayer0Score(gameState.getCurrentRunningTotal() + gameState.getPlayer0Score());
                gameState.setTurnId(1);
            }

            gameState.setCurrentRunningTotal(0);
            return true;

        } else if (action instanceof PigRollAction) {

            Random r = new Random();
            gameState.setDieValue(r.nextInt(5) + 1);

            if (gameState.getDieValue() == 1) {
            	gameState.setCurrentRunningTotal(0);
            	if (gameState.getTurnId() == 0) {
            		gameState.setTurnId(1);
	            }else {
		            gameState.setTurnId(0);
	            }
            } else {
				gameState.setCurrentRunningTotal(gameState.getCurrentRunningTotal() + gameState.getDieValue());
            }
			return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
	    PigGameState copy = new PigGameState(gameState);
	    p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
	    if (gameState.getPlayer1Score() >= 50) {
	    	return playerNames[1] + " scored " + gameState.getPlayer1Score();
	    } else if (gameState.getPlayer0Score() >= 50) {
	    	return playerNames[0] + " scored " + gameState.getPlayer0Score();
	    }
        return null;
    }

}// class PigLocalGame
