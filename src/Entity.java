import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entity {
    public int x,y;
    public int speed;

    public BufferedImage up1, up2, left1, down1, right1, climb;
    public String direction;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn= false;

}
