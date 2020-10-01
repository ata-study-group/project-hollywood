package main.java.activity;

import main.java.gameplay.GameOperation;
import main.java.gameplay.GameState;
import main.java.gameplay.InputHandler;
import main.java.type.Movie;
import main.java.type.MovieDao;
import main.java.type.Round;
import main.java.type.RoundDao;

import java.io.IOException;
import javax.inject.Inject;

public class StartRoundActivity implements GameActivity {
    private RoundDao roundDao;
    private MovieDao movieDao;
    private InputHandler inputHandler;
    private GameState state;

    @Inject
    public StartRoundActivity(InputHandler inputHandler, RoundDao roundDao, MovieDao movieDao, GameState state) {
        this.inputHandler = inputHandler;
        this.state = state;
        this.roundDao = roundDao;
        this.movieDao = movieDao;
    }

    // TODO: handle IOException more elegantly
    @Override
    public String handleRequest() {
        String movieEntry = inputHandler.getString("", "Enter movie for round: ");
        int numPlayers = state.getNumPlayers();

        try {
            movieDao.addMovieByTitle(movieEntry);
        } catch (IOException e) {
            state.setNextOperation(GameOperation.START_ROUND);
            return "Movie not found.";
        }
        Movie newMovie = movieDao.getNextMovie();

        Round newRound = new Round();
        newRound.setMovie(newMovie);

        newRound = roundDao.startNewRound(newRound, numPlayers);
        state.setCurrentRound(newRound);
        state.setNextOperation(GameOperation.SUBMIT_ANSWER);

        return "\n--------------------------";
    }
}
