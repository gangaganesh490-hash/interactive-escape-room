public class Score {

    int score;

    // Constructor
    public Score() {

        score = 0;
    }

    // Add points
    public void addPoints(int points) {

        score = score + points;
    }

    // Deduct points
    public void deductPoints(int points) {

        score = score - points;

        if (score < 0) {
            score = 0;
        }
    }

    // Get score
    public int getScore() {

        return score;
    }
}