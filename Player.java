public class Player {

    String name;
    int score;
    int currentRoom;

    // Constructor
    public Player(String name) {
        this.name = name;
        score = 0;
        currentRoom = 1;
    }

    // Add score
    public void addScore(int points) {
        score = score + points;
    }

    // Get player name
    public String getName() {
        return name;
    }

    // Get score
    public int getScore() {
        return score;
    }

    // Get current room
    public int getCurrentRoom() {
        return currentRoom;
    }

    // Move to next room
    public void nextRoom() {
        currentRoom = currentRoom + 1;
    }
}