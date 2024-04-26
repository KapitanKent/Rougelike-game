package Main;

import java.awt.*;

public class Event {

    gamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX , eventRectDefaultY;

    public Event(gamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x =23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent(){
        if(hit(27,27,"left") ==true){
            teleport(gp.dialogueState);}

        }


    public boolean hit(int eventCol, int eventRow, String reqDirection){

        boolean hit = false;

        gp.player.solidArea.x = gp.player.Worldx + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.Worldy + gp.player.solidArea.y;
        //getting eventrect solid area position
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;


        return hit;
    }
    public void teleport(int gameState){
        gp.gameState = gameState;
        gp.player.Worldx = gp.tileSize*37;
        gp.player.Worldy = gp.tileSize*10;

    }
}
