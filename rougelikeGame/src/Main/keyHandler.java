package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    gamePanel gp;
    public boolean upward, left, right, downward;


    public keyHandler (gamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            upward = true;
        }
        if (key == KeyEvent.VK_A) {
            left = true;
        }
        if (key == KeyEvent.VK_S) {
            downward = true;
        }
        if (key == KeyEvent.VK_D) {
            right = true;
        }
        if(key == KeyEvent.VK_P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            upward = false;
        }
        if (key == KeyEvent.VK_A) {
            left = false;
        }
        if (key == KeyEvent.VK_S) {
            downward = false;
        }
        if (key == KeyEvent.VK_D) {
            right = false;
        }
    }
}