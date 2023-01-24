import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Floor extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    String fallDirection;
    BufferedImage image;

    public Floor(GamePanel gp, KeyHandler keyH, int i, int j, String fallDirection){
        this.gp = gp;
        this.keyH = keyH;
        this.fallDirection = fallDirection;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        
        g2.drawImage(this.image, this.x, y, gp.tileSize, gp.tileSize, null);
    }
}
