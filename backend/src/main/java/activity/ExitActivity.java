package main.java.activity;

import main.java.gameplay.GameOperation;
import main.java.gameplay.GameState;

import javax.inject.Inject;

public class ExitActivity implements GameActivity {
    private GameState state;

    // TODO: change to 'EndGame'
    // TODO: implement getFinalWinner (from Player scores)
    @Inject
    public ExitActivity(GameState gameState) { this.state = gameState; }

    @Override
    public String handleRequest() {
        state.setNextOperation(GameOperation.EXIT);
        return "\nHope you enjoyed, good-bye!";
    }
}
