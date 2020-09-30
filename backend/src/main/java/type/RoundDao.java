package type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

public class RoundDao {
    private LinkedList<Round> roundList = new LinkedList<>();

    @Inject
    public RoundDao() {
    }

    // TODO: Move this to an activity class, maintaining DAOs for storing/getting
    public Round startNewRound(Round newRound, int numPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(String.format("Player %s", i+1)));
        }
        newRound.setPlayers(players);
        roundList.addLast(newRound);

        return newRound;
    }

    public int getRoundNumber() { return roundList.size(); }

}
