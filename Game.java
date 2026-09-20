public class Game {

    Player player;
    Room[] rooms;
    int currentRoom;

    // Constructor
    public Game(Player player) {

        this.player = player;
        currentRoom = 0;

        rooms = new Room[3];

        rooms[0] = new Room(
                "Mysterious Library",
                "You are inside an old library. Find the hidden clue."
        );

        rooms[1] = new Room(
                "Locked Laboratory",
                "A strange laboratory is locked. Solve the puzzle to escape."
        );

        rooms[2] = new Room(
                "Secret Basement",
                "You reached the final room. Find the final password."
        );
    }

    // Get current room
    public Room getCurrentRoom() {
        return rooms[currentRoom];
    }

    // Move to next room
    public boolean moveNextRoom() {

        if (currentRoom < rooms.length - 1) {

            currentRoom++;
            player.nextRoom();

            return true;
        }

        return false;
    }

    // Check whether player escaped
    public boolean isGameComplete() {

        if (currentRoom == rooms.length - 1) {
            return true;
        }

        return false;
    }

    // Get player
    public Player getPlayer() {
        return player;
    }
}