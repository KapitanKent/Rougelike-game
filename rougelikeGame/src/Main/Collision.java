    package Main;

    import characters.System;

    public class Collision {

        gamePanel gp;

        public Collision(gamePanel gp){

        this.gp = gp;

        }

        public void checkTile(System system){

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
    }
