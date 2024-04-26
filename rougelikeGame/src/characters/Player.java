    package characters;

    import Main.gamePanel;
    import Main.keyHandler;

    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;

    public class Player extends GameObject {

        keyHandler keys;

        public final int screenX;
        public final int screenY;
        int counter2 = 0;

        public Player(gamePanel gp, keyHandler keys) {
            super(gp);
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
            attackImg();
        }

        public void playerMovement() {
            Worldx = gp.tileSize * 23;
            Worldy = gp.tileSize * 21;
            speed = 4;
            direction = "down";
        }

        public void playerImg() { //Character
            up1 = setup("/char/walkUp1");
            up2 = setup("/char/walkUp2");
            right1 = setup("/char/Char1walk");
            right2 = setup("/char/Char1Walk1");
            left1 = setup("/char/wa");
            left2 = setup("/char/walkleft2");
            down1 = setup("/char/walkDown1");
            down2 = setup("/char/walkDown2");
        }
        public void attackImg(){
            attackRight1 = setup("/Animation/attackRight1");
            attackRight2 = setup("/Animation/attackRight2");
            attackRight3 = setup("/Animation/attackRight3");
            attackRight4 = setup("/Animation/attackRight4");
            attackRight5 = setup("/Animation/attackRight5");

            attackUp1 = setup("/Animation/attackUp1");
            attackUp2 = setup("/Animation/attackUp2");
            attackUp3 = setup("/Animation/attackUp3");
            attackUp4 = setup("/Animation/attackUp4");
            attackUp5 = setup("/Animation/attackUp5");

            attackLeft1 = setup("/Animation/attackLeft1");
            attackLeft2 = setup("/Animation/attackLeft2");
            attackLeft3 = setup("/Animation/attackLeft3");
            attackLeft4 = setup("/Animation/attackLeft4");
            attackLeft5 = setup("/Animation/attackLeft5");

            attackDown1 = setup("/Animation/attackDown1");
            attackDown2 = setup("/Animation/attackDown2");
            attackDown3 = setup("/Animation/attackDown3");
            attackDown4 = setup("/Animation/attackDown4");
            attackDown5 = setup("/Animation/attackDown5");
        }
        public void update() {
            if(isAttacking){
                attackAnimationFrames();
            }else if(keys.upward == true || keys.downward == true || keys.left == true || keys.right == true || keys.isAttacking){

                if (keys.upward == true) {
                    direction = "up";

                } else if (keys.downward == true) {
                    direction = "down";

                } else if (keys.left == true) {
                    direction = "left";

                } else if (keys.right == true) {
                    direction = "right";
                }
                if(keys.isAttacking){
                    isAttacking = true;
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
            int tempScreenX = screenX;
            int tempScreenY = screenY;
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

            if (isAttacking) {
                switch (direction) {
                    case "up":
                        tempScreenY -= gp.tileSize;
                        if (spriteNum == 1) {
                            image = attackUp1;
                        } else if (spriteNum == 2) {
                            image = attackUp2;
                        } else if (spriteNum == 3) {
                            image = attackUp3;
                        } else if (spriteNum == 4) {
                            image = attackUp4;
                        } else if (spriteNum == 5) {
                            image = attackUp5;
                        }
                        break;
                    case "right":
                        tempScreenX += gp.tileSize;
                        if (spriteNum == 1) {
                            image = attackRight1;
                        } else if (spriteNum == 2) {
                            image = attackRight2;
                        } else if (spriteNum == 3) {
                            image = attackRight3;
                        } else if (spriteNum == 4) {
                            image = attackRight4;
                        } else if (spriteNum == 5) {
                            image = attackRight5;
                        }
                        break;
                    case "left":
                        tempScreenX -= gp.tileSize;
                        if (spriteNum == 1) {
                            image = attackLeft1;
                        } else if (spriteNum == 2) {
                            image = attackLeft2;
                        } else if (spriteNum == 3) {
                            image = attackLeft3;
                        } else if (spriteNum == 4) {
                            image = attackLeft4;
                        } else if (spriteNum == 5) {
                            image = attackLeft5;
                        }
                        break;
                    case "down":
                        tempScreenY += gp.tileSize;
                        if (spriteNum == 1) {
                            image = attackDown1;
                        } else if (spriteNum == 2) {
                            image = attackDown2;
                        } else if (spriteNum == 3) {
                            image = attackDown3;
                        } else if (spriteNum == 4) {
                            image = attackDown4;
                        } else if (spriteNum == 5) {
                            image = attackDown5;
                        }
                        break;
                }
                g2.drawImage(image, tempScreenX, tempScreenY, gp.tileSize, gp.tileSize, null);
            }
        }
        public void attackAnimationFrames(){
            spriteCounter++;
            if(spriteCounter<=5){
                spriteNum = 1;
            }
            if (spriteCounter>5 && spriteCounter<=10){
                spriteNum = 2;
            }
            if (spriteCounter>10 && spriteCounter<=15) {
                spriteNum = 3;
            }
            if (spriteCounter>15 && spriteCounter<=20){
                spriteNum = 4;
            }
            if (spriteCounter>20 && spriteCounter<=25){
                spriteNum = 5;
            }
            if (spriteCounter>25){
                spriteNum = 1;
                spriteCounter = 0;
                isAttacking = false;
            }
        }
    }