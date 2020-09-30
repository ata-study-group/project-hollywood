package type;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.inject.Inject;

public class Player {
    private static final String TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);
    private int points = 0;

    private String playerName;
    private String timestamp;

    @Inject
    public Player(String playerName) {
        this.playerName = playerName;
        timestamp = ZonedDateTime.now(ZoneId.of("UTC")).format(TIMESTAMP_FORMATTER);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timestamp = timeStamp;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return getPoints() == player.getPoints() &&
            getPlayerName().equals(player.getPlayerName()) &&
            Objects.equals(timestamp, player.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints(), getPlayerName(), timestamp);
    }
}
