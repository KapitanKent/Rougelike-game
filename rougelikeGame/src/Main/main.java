package Main;

import javax.swing.JFrame;

public class main {
        public static void main(String[] args) {
                JFrame game = new JFrame();

                // Set properties for the JFrame
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setResizable(false);
                game.setTitle("Dungeon Crawl");
                game.setLocationRelativeTo(null);

                // Create a new game panel
                gamePanel gamePanel = new gamePanel();

                // Setup the game
                gamePanel.setupGame();
                // Add the game panel to the JFrame

                game.add(gamePanel);
                game.pack();

                game.setVisible(true);

                gamePanel.gameThread(); // Start the game thread
        }
}