import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(
                null,
                "Enter your name:"
        );

        if (name == null || name.equals("")) {
            name = "Player";
        }

        Player player = new Player(name);

        Game game = new Game(player);

        GameGUI gui = new GameGUI(game);

        gui.showGUI();
    }
}