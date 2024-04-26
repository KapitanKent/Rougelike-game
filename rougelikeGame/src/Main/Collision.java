    package Main;

    import characters.System;

    public class Collision {

        gamePanel gp;

        public Collision(gamePanel gp){

        this.gp = gp;

        }

        public void checkTile(System system){
            if (gp.TileM == null || gp.TileM.tile == null) {
                // Handle null TileManager or tile array
                return;
            }
            int systemLeftWorldX = system.Worldx + system.solidArea.x;
            int systemRightWorldX = system.Worldx + system.solidArea.x + system.solidArea.width;
            int systemTopWorldY = system.Worldy + system.solidArea.y;
            int systemBotWorldY = system.Worldy + system.solidArea.y + system.solidArea.height;

            int systemLeftCol = systemLeftWorldX / gp.tileSize;
            int systemRightCol = systemRightWorldX / gp.tileSize;
            int systemTopRow = systemTopWorldY / gp.tileSize;
            int systemBottomRow = systemBotWorldY / gp.tileSize;

            int tileNum1, tileNum2;

            switch (system.direction) {
                case "up":
                    systemTopRow = (systemTopWorldY - system.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemTopRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        system.collisionOn = true;
                    }
                    break;
                case "down":
                   systemBottomRow = (systemBotWorldY + system.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemBottomRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        system.collisionOn = true;
                    }
                    break;
                case "left":
                    systemLeftCol = (systemLeftWorldX - system.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemLeftCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        system.collisionOn = true;
                    }
                    break;
                case "right":
                    systemRightCol = (systemRightWorldX + system.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemRightCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        system.collisionOn = true;
                    }
                    break;
            }
        }

            public int checkObject(System system, boolean player) {

                int index = 999;

                // Checking collision with the player or other systems
                for (int i = 0; i < gp.obj.length; i++) {
                    if (gp.obj[i] != null) {

                    //get system solid area position
                    system.solidArea.x = system.Worldx + system.solidArea.x;
                    system.solidArea.y = system.Worldy + system.solidArea.y;

                    //object solid area position
                    gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                    gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;


                    switch (system.direction) {
                        case "up":
                            system.solidArea.y -= system.speed;
                            if (system.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    system.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "down":
                            system.solidArea.y += system.speed;
                            if (system.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    system.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "left":
                            system.solidArea.x -= system.speed;
                            if (system.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    system.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "right":
                            system.solidArea.x += system.speed;
                            if (system.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    system.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                                break;
                            }
                        }

                        system.solidArea.x = system.solidAreaDefaultX;
                        system.solidArea.y = system.solidAreaDefaultY;
                        gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                        gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

                }
                }return index;
             }
        }
