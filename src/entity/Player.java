package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {

        worldX = gp.tileSize * 30;
        worldY = gp.tileSize * 18;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        try{
            idle1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_1.png")));
            idle2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_2.png")));
            idle3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_3.png")));
            idle4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_4.png")));
            idle_left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_left_1.png")));
            idle_left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_left_2.png")));
            idle_left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_left_3.png")));
            idle_left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Idle_left_4.png")));
            run_left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_left_1.png")));
            run_left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_left_2.png")));
            run_left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_left_3.png")));
            run_left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_left_4.png")));
            run_left5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_left_5.png")));
            run_right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_right_1.png")));
            run_right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_right_2.png")));
            run_right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_right_3.png")));
            run_right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_right_4.png")));
            run_right5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Run_right_5.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {

        if (keyH.rightPressed == true || keyH.leftPressed == true || keyH.upPressed == true || keyH.downPressed == true) {
            if(keyH.upPressed == true){
                direction = "up";
                worldY -= speed;
            }
            else if (keyH.downPressed == true) {
                direction = "down";
                worldY += speed;
            }
            else if (keyH.leftPressed == true) {
                direction = "left";
                worldX -= speed;
            }
            else if (keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 10) {
                if(sprite_Run_Num == 1) {
                    sprite_Run_Num = 2;
                } else if (sprite_Run_Num == 2) {
                    sprite_Run_Num = 3;
                } else if (sprite_Run_Num == 3) {
                    sprite_Run_Num = 4;
                } else if (sprite_Run_Num == 4) {
                    sprite_Run_Num = 5;
                } else if (sprite_Run_Num == 5) {
                    sprite_Run_Num = 1;
                }
                if(sprite_Idle_Num == 1) {
                    sprite_Idle_Num = 2;
                } else if (sprite_Idle_Num == 2) {
                    sprite_Idle_Num = 3;
                } else if (sprite_Idle_Num == 3) {
                    sprite_Idle_Num = 4;
                } else if (sprite_Idle_Num == 4) {
                    sprite_Idle_Num = 1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                switch (sprite_Idle_Num) {
                    case 1 -> image = idle1;
                    case 2 -> image = idle2;
                    case 3 -> image = idle3;
                    case 4 -> image = idle4;
                }
            }
            case "down" -> image = switch (sprite_Idle_Num) {
                case 1 -> idle_left1;
                case 2 -> idle_left2;
                case 3 -> idle_left3;
                case 4 -> idle_left4;
                default -> image;
            };
            case "left" -> image = switch (sprite_Run_Num) {
                case 1 -> run_left1;
                case 2 -> run_left2;
                case 3 -> run_left3;
                case 4 -> run_left4;
                case 5 -> run_left5;
                default -> image;
            };
            case "right" -> image = switch (sprite_Run_Num) {
                case 1 -> run_right1;
                case 2 -> run_right2;
                case 3 -> run_right3;
                case 4 -> run_right4;
                case 5 -> run_right5;
                default -> image;
            };
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
