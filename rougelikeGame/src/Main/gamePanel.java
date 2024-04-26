    package Main;

    import Tile.TileManager;
    import characters.Player;
    import object.SuperObject;

    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JPanel;

    public class gamePanel extends JPanel implements Runnable {

        // Constants for frames per second (FPS) and tile size
        public final int FPS = 60;
        final int originalTileSize = 16;
        final int scale = 3;
        public final int tileSize = originalTileSize * scale;
        public final int maxScreenCol = 16;
        public final int maxScreenRow = 12;
        public final int screenWidth = tileSize * maxScreenCol;
        public final int screenHeight = tileSize * maxScreenRow;

        //World
        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;
        public final int worldWidth = tileSize * maxWorldCol;
        public final int worldHeight = tileSize * maxWorldRow;

        //System
        TileManager TileM = new TileManager(this);
        public keyHandler keys = new keyHandler(this); //instantiate for keys
        Thread gameThread;
        public Player player = new Player(this, keys);
        public Collision Checker = new Collision(this);
        public AssetSetter aSetter = new AssetSetter(this);
        public UI ui = new UI(this);
        public SuperObject obj[] = new SuperObject[10];
        public Event event = new Event(this);


        //GameState
        public int gameState;
        public final int playState = 1;
        public final int pauseState = 2;
        public final int dialogueState = 3;



        public gamePanel() {
            // Set panel properties
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keys);
            this.setFocusable(true); // Ensure panel can receive key events
            this.requestFocusInWindow(); // Request focus
        }

        // Method to setup the items in the  game
        public void setupGame() {
            aSetter.setObject();
            gameState = playState;

        }

        public void gameThread() {
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        // Paint component method to draw graphics
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            //Tile
            TileM.draw(g2);

            //Player
            player.draw(g2);

            //UI
            ui.draw(g2);

            //Object
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }
            g2.dispose();
        }

        @Override
        // Run method for the game thread
        public void run() {

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long currentTime;
            long lastTime = System.nanoTime();
            long timer = 0;
            long drawCount = 0;


            // Update and repaint
            while (gameThread != null) {

                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if (delta >= 1) {
                    update();
                    repaint();
                    drawCount++;
                }
                if (timer >= 1000000000) {
                    System.out.println("FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

                // Sleep to control frame rate
                try {
                    Thread.sleep(1000 / 60); //for the movement of the player
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        public void update() {
            if (gameState == playState) {
                player.update();
            }if(gameState == pauseState){

            }
        }
    }