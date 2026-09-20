public class Puzzle {

    String question;
    String answer;
    int points;

    // Constructor
    public Puzzle(String question, String answer, int points) {

        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    // Get question
    public String getQuestion() {
        return question;
    }

    // Check answer
    public boolean checkAnswer(String userAnswer) {

        if (userAnswer.equalsIgnoreCase(answer)) {
            return true;
        }

        return false;
    }

    // Get points
    public int getPoints() {
        return points;
    }
}