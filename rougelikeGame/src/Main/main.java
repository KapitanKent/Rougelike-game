package Main;

import javax.swing.JFrame;

public class main {
        public static void main(String[] args) {
                JFrame game = new JFrame();

                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setResizable(false);
                game.setTitle("Dungeon Crawl");
                game.setLocationRelativeTo(null);

                gamePanel gamePanel = new gamePanel();
                game.add(gamePanel);
                game.pack();

                game.setVisible(true);

                gamePanel.gameThread(); // Start the game thread
        }
}