package characters;

import Main.Utilities;
import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameObject {
    gamePanel gp;
    public int Worldx, Worldy;
    public int speed;

    public BufferedImage up1, up2, up3, down1 , down2, down3, left1, left2 ,left3 ,right1,right2,right3;
    public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4, attackUp5, attackDown1,attackDown2,attackDown3,attackDown4,attackDown5;
    public BufferedImage attackRight1, attackRight2,attackRight3, attackRight4,attackRight5, attackLeft1, attackLeft2, attackLeft3,attackLeft4,attackLeft5;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean isAttacking = false;
    public GameObject(gamePanel gp){
        this.gp = gp;
    }
    public BufferedImage setup(String imagePath){
        Utilities uTool = new Utilities();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}