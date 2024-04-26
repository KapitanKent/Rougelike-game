    package characters;

    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import java.util.Objects;
    import javax.imageio.ImageIO;
    import Main.gamePanel;
    import Main.keyHandler;
    import org.w3c.dom.Entity;

    public class Player extends System {

        gamePanel gp;
        keyHandler keys;

        public final int screenX;
        public final int screenY;
        int counter2 = 0;

        public Player(gamePanel gp, keyHandler keys) {
            this.gp = gp;
            this.keys = keys;

            screenX = (gp.screenWidth - gp.tileSize) / 2;
            screenY = (gp.screenHeight - gp.tileSize) / 2;

            solidArea = new Rectangle();
            solidArea.x = 8;
            solidArea.y = 16;
            solidAreaDefaultX = solidArea.x;
            solidAreaDefaultY = solidArea.y;
            solidArea.width = 32;
            solidArea.height = 32;

            playerMovement();
            playerImg();
        }

        public void playerMovement() {
            Worldx = gp.tileSize * 23;
            Worldy = gp.tileSize * 21;
            speed = 4;
            direction = "down";
        }

        public void playerImg() { //Character
            try {

                up1 = ImageIO.read(getClass().getResourceAsStream("/char/walkUp1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/char/walkUp2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/char/Char1walk.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/char/Char1Walk1.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/char/wa.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/char/walkleft2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/char/walkDown1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/char/walkDown2.png"));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void update() {

            if(keys.upward == true || keys.downward == true || keys.left == true || keys.right == true){

                if (keys.upward == true) {
                    direction = "up";

                } else if (keys.downward == true) {
                    direction = "down";

                } else if (keys.left == true) {
                    direction = "left";

                } else if (keys.right == true) {
                    direction = "right";
                }

                //Check Tile Collision
                collisionOn = false;
                gp.Checker.checkTile(this);

                //Check object Collision
                int objIndex = gp.Checker.checkObject(this, true);
                pickObj(objIndex);

                //check event
               gp.event.checkEvent();
               
                //If collision is false the player can move
                if(collisionOn == false){
                    switch (direction){
                        case "up":
                            Worldy -= speed;
                            break;
                        case "down":
                            Worldy += speed;
                            break;
                        case "left":
                            Worldx -= speed;
                            break;
                        case "right":
                            Worldx += speed;
                            break;
                    }
                }

                //Character Animation
                spriteCounter++;
                if (spriteCounter > 10) {
                    if(spriteNum == 1){
                        spriteNum=2;
                    }
                    else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }

            }

        }

        public void pickObj(int i){
            if(i !=999){

            }

        }

        public void draw(Graphics2D g2) {

            BufferedImage image = null;

            switch (direction) {
                case "up":
                    if(spriteNum == 1){
                        image = up1;
                    }
                    if(spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2){
                        image = right2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }