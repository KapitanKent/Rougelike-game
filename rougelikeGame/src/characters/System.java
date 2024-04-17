package characters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class System {

    public int Worldx, Worldy;
    public int speed;

    public BufferedImage up1, up2, up3, up4;
    public String direction;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}