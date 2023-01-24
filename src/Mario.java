import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Rectangle;

import javax.imageio.ImageIO;

public class Mario extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Mario(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle(0, 0, gp.tileSize - 5, gp.tileSize - 5);
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.y = solidAreaDefaultX;
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("./res/mario/mario_all.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("./res/mario/mario_left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("./res/mario/mario_right.png"));
            climb = ImageIO.read(getClass().getResourceAsStream("./res/mario/mario_climb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method will implement the jump functionality
    private void jump() {
        System.out.println("Player jumps");
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
            System.out.println("Pressed up");
            System.out.println(x + " " + y);
        }
        else if (keyH.downPressed == true) {
            direction = "down";
            
        }
        else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
            System.out.println("Pressed up");
            System.out.println(x + " " + y);
        }
        else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
        else if (keyH.spacePressed == true) {
            this.jump();
        }

        collisionOn = false;
        
        gp.cChecker.checkCollision(this, "player");
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = up1;
                break;
            case "right":
                image = right1; 
                break;
            case "left":
                image = left1; 
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
