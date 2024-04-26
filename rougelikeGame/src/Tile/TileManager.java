package Tile;
import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileManager {
    gamePanel gp;
   public Tile[] tile;
   public int [][] mapTileNum ;


   ArrayList<String> fileNames = new ArrayList<>();
   ArrayList<String> collisionStatus = new ArrayList<>();



    public TileManager(gamePanel gp){

        this.gp = gp;

        //read tile data files
        InputStream is = getClass().getResourceAsStream("/Map/worldmap1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));


        //GET THE TILE NAMES AND COLLISION INFO FROM THE FILE
        String line;
        tile = new Tile[100];

        try {
            while ((line = br.readLine()) != null) {
                fileNames.add(line);
                collisionStatus.add(br.readLine());
            }
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        //initialize the tile ARRAY based on the filenames size

        getTileImage();


        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        loadMap("/Map/worldmap1.txt");
    }


    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/000.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/001.png"));
            //tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/002.png"));
            //tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/003.png"));


            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/004.png"));
           // tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/005.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/006.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/007.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/008.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/009.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/010.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/011.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/012.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/013.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/014.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/015.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/016.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/017.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/018.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/019.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/020.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/021.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/022.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/023.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/024.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/025.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/026.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/027.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/028.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/029.png"));
            tile[29].collision = true;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/030.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/031.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/032.png"));
            tile[32].collision = true;
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/033.png"));

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/034.png"));

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/035.png"));

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/036.png"));

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/037.png"));

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/bridge.png"));

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castle1.png"));
            tile[39].collision = true;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castle2.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castle3.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castle4.png"));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/CastleFloor.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/CastleStair.png"));

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castleTiles.png"));

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/castleWall.png"));

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/caveWall.png"));

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dungeonFloor.png"));

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/dungeonWall.png"));

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/floorCave.png"));

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lava.png"));

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lava2.png"));

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lava3.png"));

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lava4.png"));

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/lava5.png"));

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/Road1.png"));

            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stair.png"));

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stairCave.png"));

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stairCave2.png"));

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stairCave3.png"));

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/stairCave4.png"));


            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tile.png"));


            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/toCastle.png"));

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/toCave.png"));

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/toDungeo.png"));

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
            tile[69].collision = true;

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setup(int index, String imageName, boolean collision){

    }
    public void loadMap(String filePath){
        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                 String line = br.readLine();

                while (col< gp.maxWorldCol){

                 String []numbers= line.split(" ");

                 int num = Integer.parseInt(numbers[col]);

                 mapTileNum[col][row] = num;
                 col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }br.close();


        }catch (Exception e) {
        }
    }


    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldRow < gp.maxWorldRow) {

            worldCol = 0;

            while (worldCol < gp.maxWorldCol) {
                int tileNum = mapTileNum[worldCol][worldRow];
                if (tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null) {
                    int worldX = worldCol * gp.tileSize;
                    int worldY = worldRow * gp.tileSize;
                    int screenX = worldX - gp.player.Worldx + gp.player.screenX;
                    int screenY = worldY - gp.player.Worldy + gp.player.screenY;

                    if (worldX + gp.tileSize > gp.player.Worldx - gp.player.screenX &&
                            worldX - gp.tileSize < gp.player.Worldx + gp.player.screenX &&
                            worldY + gp.tileSize > gp.player.Worldy - gp.player.screenY &&
                            worldY - gp.tileSize < gp.player.Worldy + gp.player.screenY) {
                        g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,null);
                    }
                }
                worldCol++;
            }
            worldRow++;
        }
    }
}


