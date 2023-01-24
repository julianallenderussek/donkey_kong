import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Peach extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;

    public Peach(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("./res/peach/peach.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 220;
        y = 220;
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
