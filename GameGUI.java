import javax.swing.*;
import java.awt.*;

public class GameGUI {

    JFrame frame;

    JLabel roomLabel;
    JLabel scoreLabel;
    JLabel inventoryLabel;

    JTextArea descriptionArea;
    JTextArea questionArea;

    JTextField answerField;

    JButton submitButton;
    JButton hintButton;

    Game game;

    PuzzleManager puzzleManager;
    Inventory inventory;
    Hint hint;
    Score score;

    // Constructor
    public GameGUI(Game game) {

        this.game = game;

        puzzleManager = new PuzzleManager();
        inventory = new Inventory();
        hint = new Hint();
        score = new Score();

        createGUI();
    }

    // Create GUI
    public void createGUI() {

        frame = new JFrame("Escape Room");

        frame.setSize(700, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();

        roomLabel = new JLabel();

        scoreLabel = new JLabel();

        inventoryLabel = new JLabel();

        topPanel.add(roomLabel);
        topPanel.add(scoreLabel);
        topPanel.add(inventoryLabel);

        frame.add(topPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new GridLayout(3, 1));

        descriptionArea = new JTextArea();

        descriptionArea.setEditable(false);

        questionArea = new JTextArea();

        questionArea.setEditable(false);

        answerField = new JTextField();

        centerPanel.add(descriptionArea);
        centerPanel.add(questionArea);
        centerPanel.add(answerField);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();

        submitButton = new JButton("Submit Answer");

        hintButton = new JButton("Hint");

        bottomPanel.add(submitButton);
        bottomPanel.add(hintButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Submit button
        submitButton.addActionListener(e -> checkAnswer());

        // Hint button
        hintButton.addActionListener(e -> showHint());

        updateGUI();
    }

    // Update GUI
    public void updateGUI() {

        int roomNumber = game.getPlayer().getCurrentRoom() - 1;

        Room room = game.getCurrentRoom();

        Puzzle puzzle = puzzleManager.getPuzzle(roomNumber);

        roomLabel.setText(
                "Room: " + game.getPlayer().getCurrentRoom()
        );

        scoreLabel.setText(
                "   Score: " + score.getScore()
        );

        inventoryLabel.setText(
                "   Items: " + inventory.getItems()
        );

        descriptionArea.setText(
                room.getRoomName() + "\n\n" +
                room.getDescription()
        );

        questionArea.setText(
                "Puzzle:\n" + puzzle.getQuestion()
        );

        answerField.setText("");
    }

    // Check answer
    public void checkAnswer() {

        int roomNumber = game.getPlayer().getCurrentRoom() - 1;

        Puzzle puzzle = puzzleManager.getPuzzle(roomNumber);

        String answer = answerField.getText();

        if (puzzle.checkAnswer(answer)) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Correct answer!"
            );

            score.addPoints(puzzle.getPoints());

            inventory.addItem("Key " + (roomNumber + 1));

            game.getCurrentRoom().completeRoom();

            if (game.moveNextRoom()) {

                updateGUI();

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Congratulations " +
                        game.getPlayer().getName() +
                        "! You escaped!\nFinal Score: " +
                        score.getScore()
                );

                submitButton.setEnabled(false);
                hintButton.setEnabled(false);
            }

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Wrong answer! Try again."
            );

            score.deductPoints(5);

            scoreLabel.setText(
                    "   Score: " + score.getScore()
            );
        }
    }

    // Show hint
    public void showHint() {

        int roomNumber = game.getPlayer().getCurrentRoom() - 1;

        String message = hint.getHint(roomNumber);

        JOptionPane.showMessageDialog(
                frame,
                message
        );

        score.deductPoints(5);

        scoreLabel.setText(
                "   Score: " + score.getScore()
        );
    }

    // Show GUI
    public void showGUI() {

        frame.setVisible(true);
    }
}