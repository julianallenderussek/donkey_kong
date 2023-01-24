import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ladder extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    String fallDirection;
    int x;
    int y;
    BufferedImage image;

    public Ladder(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        this.x = x;
        this.x = y;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("./res/ladder/ladder1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.x, this.y, gp.tileSize, gp.tileSize, null);
    }
}
