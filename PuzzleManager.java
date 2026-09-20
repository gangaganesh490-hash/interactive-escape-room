public class PuzzleManager {

    Puzzle[] puzzles;

    // Constructor
    public PuzzleManager() {

        puzzles = new Puzzle[3];

        puzzles[0] = new Puzzle(
                "What has keys but cannot open a lock?",
                "piano",
                20
        );

        puzzles[1] = new Puzzle(
                "What has hands but cannot clap?",
                "clock",
                20
        );

        puzzles[2] = new Puzzle(
                "What gets wetter as it dries?",
                "towel",
                20
        );
    }

    // Get puzzle
    public Puzzle getPuzzle(int roomNumber) {

        return puzzles[roomNumber];
    }
}