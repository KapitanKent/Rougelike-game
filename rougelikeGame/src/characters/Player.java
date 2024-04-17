package characters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Main.gamePanel;
import Main.keyHandler;

public class Player extends System {

    gamePanel gp;
    keyHandler keys;

    public Player(gamePanel gp, keyHandler keys) {
        this.gp = gp;
        this.keys = keys;

        playerMovement();
        playerImg();
    }

    public void playerMovement(){
        x = 100;
        y = 100;
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
            y -= speed;
        } else if (keys.downward) {
            direction = "down";
            y += speed;
        } else if (keys.forward) {
            direction = "right";
            x += speed;
        } else if (keys.backward) {
            direction = "left";
            x -= speed;
        }
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
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}