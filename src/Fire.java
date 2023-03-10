import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fire extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;

    public Fire(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        try {
            // TO DO CHANGE IMAGE
            image = ImageIO.read(getClass().getResourceAsStream("./res/peach/peach.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        
    }

    public void move() {}

    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
