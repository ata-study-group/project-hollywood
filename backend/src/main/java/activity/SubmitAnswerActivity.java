package activity;

import gameplay.GameState;
import gameplay.InputHandler;
import type.Movie;
import type.Player;
import type.Round;
import type.RoundDao;

import javax.inject.Inject;

public class SubmitAnswerActivity implements GameActivity {
    private RoundDao roundDao;
    private InputHandler inputHandler;
    private GameState state;

    @Inject
    public SubmitAnswerActivity(RoundDao roundDao, InputHandler inputHandler, GameState state) {
        this.roundDao = roundDao;
        this.inputHandler = inputHandler;
        this.state = state;
    }

    // TODO: increment Player scores to accumulate over multiple rounds
    @Override
    public String handleRequest() {
        Round currentRound = state.getCurrentRound();
        Movie currentMovie = currentRound.getMovie();
        System.out.printf("\nRound %s:\n%s\n",
            roundDao.getRoundNumber() + 1,
            currentMovie);

        for (Player player : currentRound.getPlayers()) {
            String prompt = String.format("\nSubmit answer for %s:", player.getPlayerName());
            String playerAnswer = inputHandler.getString(prompt, "> ");
            currentRound.addPlayerAnswer(Double.parseDouble(playerAnswer), player);
        }

        double correctRating = currentMovie.getImdbRating();
        double bestAnswer = currentRound.calculateBestAnswer();
        Player winner = currentRound.findWinner(bestAnswer);

        return String.format("\n--------------------------\nthe IMDb rating for %s is %s" +
                "\nThe winner is %s, with %s!\n--------------------------\n",
            currentMovie.getTitle(),
            correctRating,
            winner.getPlayerName(), bestAnswer);
    }
}
