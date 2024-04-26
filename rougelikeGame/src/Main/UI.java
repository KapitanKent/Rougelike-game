package Main;

import object.obj_Key;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class UI {

    gamePanel gp;
    Graphics2D g2;
    Font sans_serif_40 , sans_serif_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(gamePanel gp){

        this.gp = gp;
        sans_serif_40 = new Font("Sans Serif", Font.PLAIN,35);
        sans_serif_80B = new Font("Sans Serif" ,Font.BOLD, 80);

    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {

        this.g2 = g2;
        g2.setFont(sans_serif_40);
        g2.setColor(Color.WHITE);

        //PlayState
        if(gp.gameState == gp.playState){

        }
        //PauseState
        if(gp.gameState == gp.pauseState){
        drawPauseScreen();
        }
    }

    public void drawPauseScreen(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
        String text ="PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text , x, y);
    }


    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
