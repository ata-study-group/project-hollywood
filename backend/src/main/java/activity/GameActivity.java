package main.java.activity;

/**
 * General activity for the Activity classes.
 */
public interface GameActivity {
    /**
     * Handles the relevant operation requested and returns response to be displayed to
     * user (if any).
     * @return String of content to be rendered to user, if any
     */
    String handleRequest();
}
