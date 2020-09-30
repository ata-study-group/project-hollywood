package gameplay;

import type.Round;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Contains the runtime state, particularly round and next operation.
 */
public class GameState {
    private int numPlayers;
    private Round currentRound;
    private GameOperation nextOperation;

    @Singleton
    @Inject
    public GameState() {
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public GameOperation getNextOperation() {
        return nextOperation;
    }

    public void setNextOperation(GameOperation nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public String toString() {
        return "GameState{" +
            "numPlayers=" + numPlayers +
            ", currentRound=" + currentRound +
            ", nextOperation=" + nextOperation +
            '}';
    }
}
