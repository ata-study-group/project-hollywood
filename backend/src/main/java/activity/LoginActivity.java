package activity;

import gameplay.GameState;
import gameplay.InputHandler;

import javax.inject.Inject;

public class LoginActivity implements GameActivity {
    private InputHandler inputHandler;
    private GameState state;
    private int MIN_PLAYERS = 1;
    private int MAX_PLAYERS = 10;

    @Inject
    public LoginActivity(InputHandler inputHandler, GameState state) {
        this.inputHandler = inputHandler;
        this.state = state;
    }

    @Override
    public String handleRequest() {
        int numPlayers = requestNumPlayers();

        state.setNumPlayers(numPlayers);
        return "";
    }

    private int requestNumPlayers() {
        return inputHandler.getInteger(MIN_PLAYERS, MAX_PLAYERS, "How many players? ");
    }
}
