    package characters;

    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import javax.imageio.ImageIO;
    import Main.gamePanel;
    import Main.keyHandler;
    import org.w3c.dom.Entity;

    public class Player extends System {

        gamePanel gp;
        keyHandler keys;

        public final int screenX;
        public final int screenY;

        public Player(gamePanel gp, keyHandler keys) {
            this.gp = gp;
            this.keys = keys;

            screenX = (gp.screenWidth - gp.tileSize) / 2;
            screenY = (gp.screenHeight - gp.tileSize) / 2;

            solidArea = new Rectangle();
            solidArea.x = 8;
            solidArea.y = 16;
            solidArea.width = 32;
            solidArea.height = 32;

            playerMovement();
            playerImg();
        }

        public void playerMovement(){
            Worldx = gp.tileSize * 23;
            Worldy = gp.tileSize * 21;
            speed = 4;
            direction = "down";
        }

        public void playerImg() { //Character
            try {

                up1 = ImageIO.read(getClass().getResourceAsStream("/char/show.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/char/pngegg (1).png"));
                up3 = ImageIO.read(getClass().getResourceAsStream("/char/pngegg.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void update() {
            if (keys.upward) {
                direction = "up";
                Worldy -= speed;
            } else if (keys.downward) {
                direction = "down";
                Worldy += speed;
            } else if (keys.forward) {
                direction = "right";
                Worldx += speed;
            } else if (keys.backward) {
                direction = "left";
                Worldx -= speed;
            }
            collisionOn = false;
            gp.collisionChecker.checkTile(this);
        }

        public void draw(Graphics2D g2) {

            BufferedImage image = null;

            switch (direction) {
                case "up":
                    image = up1;
                    break;
                case "down":
                    image = up2;
                    break;
                case "left":
                    image = up3;
                    break;
                case "right":
                    image = up3;
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }