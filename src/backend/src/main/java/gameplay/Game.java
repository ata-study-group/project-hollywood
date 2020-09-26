package gameplay;

import activity.ExitActivity;
import activity.GameActivity;
import activity.LoginActivity;
import activity.StartRoundActivity;
import activity.SubmitAnswerActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class Game {
    private Map<String, GameOperation> userGameOptions = new HashMap<>();
    private Map<GameOperation, GameActivity> gameActivities = new HashMap<>();

    private InputHandler inputHandler;
    private LoginActivity loginActivity;
    private StartRoundActivity startRoundActivity;
    private SubmitAnswerActivity submitAnswerActivity;
    private ExitActivity exitActivity;
    private GameState state;

    /**
     * Creates a new CLI game for a user to interact with.
     */
    @Inject
    public Game(InputHandler inputHandler,
                LoginActivity loginActivity,
                StartRoundActivity startRoundActivity,
                SubmitAnswerActivity submitAnswerActivity,
                ExitActivity exitActivity,
                GameState state) {
        this.inputHandler = inputHandler;
        this.loginActivity = loginActivity;
        this.startRoundActivity = startRoundActivity;
        this.submitAnswerActivity = submitAnswerActivity;
        this.exitActivity = exitActivity;
        this.state = state;

        registerActivities();
    }

    /**
     * For as long as the user wants to keep using the CLI app, keeps handling their requests,
     * e.g. start a new round, exit.
     */
    public void handleRequests() {
        displayWelcomeMessage();

        state.setNextOperation(GameOperation.LOGIN);

        GameOperation nextOperation;
        do {
            nextOperation = getNextRequestedGameOperation();
            if (gameActivities.containsKey(nextOperation)) {
                System.out.println(gameActivities.get(nextOperation).handleRequest());
            } else {
                System.out.println("Invalid operation. Exiting!");
                state.setNextOperation(GameOperation.EXIT);
            }
        } while (state.getNextOperation() != GameOperation.EXIT);
    }

    private void registerActivities() {
        userGameOptions.put("1", GameOperation.START_ROUND);
        userGameOptions.put("2", GameOperation.EXIT);

        gameActivities.put(GameOperation.LOGIN, loginActivity);
        gameActivities.put(GameOperation.START_ROUND, startRoundActivity);
        gameActivities.put(GameOperation.SUBMIT_ANSWER, submitAnswerActivity);
        gameActivities.put(GameOperation.EXIT, exitActivity);
    }

    private GameOperation getNextRequestedGameOperation() {
        if (state.getNextOperation() != null) {
            GameOperation nextOperation = state.getNextOperation();
            state.setNextOperation(null);
            return nextOperation;
        }

        String prompt = "Main Menu:\n" +
            userGameOptions.entrySet().stream()
                .map((entry) -> entry.getKey() + ": " + entry.getValue().getUserVisibleRepresentation())
                .collect(Collectors.joining("\n"));

        String nextGameOperation;

        do {
            nextGameOperation = inputHandler.getString(userGameOptions.keySet(), prompt, "> ")
                .trim();
        } while ("".equals(nextGameOperation));

        return userGameOptions.get(nextGameOperation);
    }

    private void displayWelcomeMessage() {
        System.out.println("\n\nWELCOME TO PROJECT HOLLYWOOD v0.1\n\n");
    }
}
