package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public  int[][] mapTileNum;


    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[100];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01(59x35).txt");
    }

    public void getTileImage() {

        // NEED A PLACEHOLDER FOR NUMBERS 0-9  Check the 12-th lesson!
        setup(0, "Grass/Grass_part_5", false);
        setup(1, "CastleWall/CastleWall_part1", true);
        setup(2, "CastleWall/CastleWall_part2", true);
        setup(3, "CastleWall/CastleWall_part3", true);
        setup(4, "CastleWall/CastleWall_part4", true);
        setup(5, "CastleWall/CastleWall_part5", true);
        setup(6, "CastleWall/CastleWall_part6", true);
        setup(7, "CastleWall/CastleWall_part7", true);
        setup(8, "CastleWall/CastleWall_part8", true);
        setup(9, "CastleWall/CastleWall_part9", true);
        setup(10, "CastleWall/CastleWall_part10", true);
        setup(11, "CastleWall/CastleWall_part11", true);
        setup(12, "CastleWall/CastleWall_part12", true);
        setup(13, "CastleWall/CastleWall_part12_down", true);
        setup(14, "Mettalic_Gates/Mettalic_Gates_part1", true);
        setup(15, "Mettalic_Gates/Mettalic_Gates_part2", true);
        setup(16, "Mettalic_Gates/Mettalic_Gates_part3", true);
        setup(17, "Mettalic_Gates/Mettalic_Gates_part4", true);
        setup(18, "Mettalic_Gates/Mettalic_Gates_part5", true);
        setup(19, "Mettalic_Gates/Mettalic_Gates_part6", true);

    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/" + imagePath + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

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

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
