import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrel extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;
    int x;
    int y;
    String direction;

    public Barrel(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        this.x = x;
        this.y = y;
        this.direction = "down";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("./res/barrel/barrel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // Check if we have a ladder if we habe a ladder run method for checking if we fall directly
        // Check if we have floor below if yes we move to the direction of the fall of the floor        
    }

    public void fall() {
        // Update y of barrel        
    }

    public void move(String direction) {

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.x, this.y, gp.tileSize, gp.tileSize, null);
    }
}
