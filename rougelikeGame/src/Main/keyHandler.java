package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    public boolean upward, backward, forward, downward;

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
            backward = true;
        }
        if (key == KeyEvent.VK_S) {
            downward = true;
        }
        if (key == KeyEvent.VK_D) {
            forward = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            upward = false;
        }
        if (key == KeyEvent.VK_A) {
            backward = false;
        }
        if (key == KeyEvent.VK_S) {
            downward = false;
        }
        if (key == KeyEvent.VK_D) {
            forward = false;
        }
    }
}