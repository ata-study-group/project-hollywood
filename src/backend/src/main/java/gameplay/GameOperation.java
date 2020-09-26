package gameplay;

public enum GameOperation {
    LOGIN("Login"),
    START_ROUND("Start a new round"),
    SUBMIT_ANSWER("Submit answer"),
    EXIT("Exit");

    private final String userVisibleRepresentation;

    GameOperation(final String userVisibleRepresentation) {
        this.userVisibleRepresentation = userVisibleRepresentation;
    }

    /**
     * Returns a string representation of the GameOperations for appropriate
     * display to a CLI user
     *
     * @return the display string for this operation
     */
    public String getUserVisibleRepresentation() { return userVisibleRepresentation; }

}
