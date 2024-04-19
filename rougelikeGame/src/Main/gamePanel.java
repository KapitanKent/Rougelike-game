    package Main;

    import Tile.TileManager;
    import characters.Player;

    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JPanel;

    public class gamePanel extends JPanel implements Runnable {

        public final int FPS = 60;
        //panel size
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

        TileManager TileM = new TileManager(this);
        keyHandler keys = new keyHandler(); //instantiate for keys
        Thread gameThread;
        public Player player = new Player(this, keys);
        public Collision Checker = new Collision(this);


        //player stock position
        int playerX = 100;
        int playerY = 100;
        int playerSpeed = 4;

        public gamePanel() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keys);
            this.setFocusable(true); // Ensure panel can receive key events
            this.requestFocusInWindow(); // Request focus
        }

        public void gameThread() {
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            TileM.draw(g2);
            player.draw(g2);

        }

        @Override
        public void run() {

            double drawInterval = 1000000000/FPS;
            double delta = 0;
            long currentTime ;
            long lastTime = System.nanoTime();
            long timer = 0;
            long drawCount = 0;

            while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " +drawCount);
                drawCount = 0;
                timer = 0;
            }


                try {
                    Thread.sleep(1000 / 60); //for the movement of the player
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        public void update() {
            player.update();
        }
    }