package main.java;


import main.java.activity.ExitActivity;
import main.java.activity.LoginActivity;
import main.java.activity.StartRoundActivity;
import main.java.activity.SubmitAnswerActivity;
import main.java.gameplay.Game;
import main.java.gameplay.GameState;
import main.java.gameplay.InputHandler;
import main.java.type.MovieDao;
import main.java.type.RoundDao;

// TODO: import dagger-compiler library to convert annotated classes to code
public class Main {
    private static InputHandler inputHandler;
    private static GameState gameState;

    public static void main(String[] args) {
        Game game = new Game(
            getInputHandler(),
            getLoginActivity(),
            getStartRoundActivity(),
            getSubmitAnswerActivity(),
            getExitActivity(),
            getGameState()
        );
        game.handleRequests();
    }

    private static InputHandler getInputHandler() {
        if (inputHandler == null) {
            inputHandler = new InputHandler();
        }
        return inputHandler;
    }

    private static GameState getGameState() {
        if (gameState == null) {
            gameState = new GameState();
        }
        return gameState;
    }

    private static LoginActivity getLoginActivity() {
        return new LoginActivity(getInputHandler(), getGameState());
    }

    private static StartRoundActivity getStartRoundActivity() {
        return new StartRoundActivity(getInputHandler(),getRoundDao(), getMovieDao(), getGameState());
    }

    private static SubmitAnswerActivity getSubmitAnswerActivity() {
        return new SubmitAnswerActivity(getRoundDao(), getInputHandler(), getGameState());
    }

    private static ExitActivity getExitActivity() {
        return new ExitActivity(getGameState());
    }

    private static RoundDao getRoundDao() {
        return new RoundDao();
    }

    private static MovieDao getMovieDao() {
        return new MovieDao();
    }
}
