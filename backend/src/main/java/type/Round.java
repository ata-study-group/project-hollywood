package main.java.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class Round {
    private Movie movie;
    private List<Player> players;
    private Map<Double, Player> answerMap = new HashMap<>();

    @Inject
    public Round() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<Double, Player> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<Double, Player> answerMap) {
        this.answerMap = answerMap;
    }

    public boolean addPlayerAnswer(Double answer, Player player) {
        if (answerMap.containsKey(answer)) {
            return false;
        }
        answerMap.put(answer, player);
        return true;
    }

    public double calculateBestAnswer() {
        double correctRating = movie.getImdbRating();
        List<Double> answers = new ArrayList<>(answerMap.keySet());
        double closestDiff = Math.abs(answers.get(0) - correctRating);
        double closestAnswer = answers.get(0);
        for (int i = 1; i < answers.size(); i++) {
            double indexDiff = Math.abs(answers.get(i) - correctRating);
            if (indexDiff < closestDiff) {
                closestDiff = indexDiff;
                closestAnswer = answers.get(i);
            }
        }
        return closestAnswer;
    }

    public Player findWinner(double bestAnswer) {
        return answerMap.get(bestAnswer);
    }
}
