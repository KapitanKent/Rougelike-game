    package Main;

    import characters.GameObject;

    public class Collision {

        gamePanel gp;

        public Collision(gamePanel gp){

        this.gp = gp;

        }

        public void checkTile(GameObject gameObject){
            if (gp.TileM == null || gp.TileM.tile == null) {
                // Handle null TileManager or tile array
                return;
            }
            int systemLeftWorldX = gameObject.Worldx + gameObject.solidArea.x;
            int systemRightWorldX = gameObject.Worldx + gameObject.solidArea.x + gameObject.solidArea.width;
            int systemTopWorldY = gameObject.Worldy + gameObject.solidArea.y;
            int systemBotWorldY = gameObject.Worldy + gameObject.solidArea.y + gameObject.solidArea.height;

            int systemLeftCol = systemLeftWorldX / gp.tileSize;
            int systemRightCol = systemRightWorldX / gp.tileSize;
            int systemTopRow = systemTopWorldY / gp.tileSize;
            int systemBottomRow = systemBotWorldY / gp.tileSize;

            int tileNum1, tileNum2;

            switch (gameObject.direction) {
                case "up":
                    systemTopRow = (systemTopWorldY - gameObject.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemTopRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        gameObject.collisionOn = true;
                    }
                    break;
                case "down":
                   systemBottomRow = (systemBotWorldY + gameObject.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemBottomRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        gameObject.collisionOn = true;
                    }
                    break;
                case "left":
                    systemLeftCol = (systemLeftWorldX - gameObject.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemLeftCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemLeftCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        gameObject.collisionOn = true;
                    }
                    break;
                case "right":
                    systemRightCol = (systemRightWorldX + gameObject.speed) / gp.tileSize;
                    tileNum1 = gp.TileM.mapTileNum[systemRightCol][systemTopRow];
                    tileNum2 = gp.TileM.mapTileNum[systemRightCol][systemBottomRow];
                    if (gp.TileM.tile[tileNum1].collision || gp.TileM.tile[tileNum2].collision) {
                        gameObject.collisionOn = true;
                    }
                    break;
            }
        }

            public int checkObject(GameObject gameObject, boolean player) {

                int index = 999;

                // Checking collision with the player or other systems
                for (int i = 0; i < gp.obj.length; i++) {
                    if (gp.obj[i] != null) {

                    //get system solid area position
                    gameObject.solidArea.x = gameObject.Worldx + gameObject.solidArea.x;
                    gameObject.solidArea.y = gameObject.Worldy + gameObject.solidArea.y;

                    //object solid area position
                    gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                    gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;


                    switch (gameObject.direction) {
                        case "up":
                            gameObject.solidArea.y -= gameObject.speed;
                            if (gameObject.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    gameObject.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "down":
                            gameObject.solidArea.y += gameObject.speed;
                            if (gameObject.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    gameObject.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "left":
                            gameObject.solidArea.x -= gameObject.speed;
                            if (gameObject.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    gameObject.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                            }
                            break;
                        case "right":
                            gameObject.solidArea.x += gameObject.speed;
                            if (gameObject.solidArea.intersects(gp.obj[i].solidArea)) {
                                if(gp.obj[i].collision == true){
                                    gameObject.collisionOn = true;
                                }
                                if(player == true){
                                    index = i;
                                }
                                break;
                            }
                        }

                        gameObject.solidArea.x = gameObject.solidAreaDefaultX;
                        gameObject.solidArea.y = gameObject.solidAreaDefaultY;
                        gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                        gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

                }
                }return index;
             }
        }
