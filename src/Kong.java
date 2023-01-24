import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Kong extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Kong(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getKongImage();
    }

    public void setDefaultValues() {
        x = 150;
        y = 100;
    }

    public void getKongImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("./res/donkey_kong/donkey.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("./res/donkey_kong/donkeyLeft.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("./res/donkey_kong/donkey.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = up1;
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
