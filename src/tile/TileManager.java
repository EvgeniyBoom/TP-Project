package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;


    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[100];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01(59x35).txt");
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Grass/Grass_part_5.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part1.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part2.png")));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part3.png")));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part4.png")));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part5.png")));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part6.png")));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part7.png")));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part8.png")));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part9.png")));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part10.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part11.png")));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part12.png")));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/CastleWall/CastleWall_part12_down.png")));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part1.png")));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part2.png")));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part3.png")));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part4.png")));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part5.png")));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Mettalic_Gates/Mettalic_Gates_part6.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();
                while(col < gp.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public void  draw(Graphics2D g2) {

        //g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[1].image, 64, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[2].image, 128, 0, gp.tileSize, gp.tileSize, null);

        //SINGLE MAP
        /*int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }*/


        //WORLD MAP
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }




        }

    }

}
