public class Hint {

    String[] hints;

    // Constructor
    public Hint() {

        hints = new String[3];

        hints[0] = "Think about a musical instrument.";
        hints[1] = "Think about something that shows time.";
        hints[2] = "Think about something used after bathing.";
    }

    // Get hint
    public String getHint(int roomNumber) {

        return hints[roomNumber];
    }
}