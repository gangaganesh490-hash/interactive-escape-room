public class Room {

    String roomName;
    String description;
    boolean completed;

    // Constructor
    public Room(String roomName, String description) {

        this.roomName = roomName;
        this.description = description;
        completed = false;
    }

    // Get room name
    public String getRoomName() {
        return roomName;
    }

    // Get description
    public String getDescription() {
        return description;
    }

    // Check whether room is completed
    public boolean isCompleted() {
        return completed;
    }

    // Complete the room
    public void completeRoom() {
        completed = true;
    }
}