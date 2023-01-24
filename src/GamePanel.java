import javax.swing.JPanel;
import java.awt.*;

// The Game Panel class acts as the screen our game
// This class inherits from JPanel Class
public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    // This is the standard size of a tile in our game (16 pixels is a pretty standard size for 2d games)
    final int originalTileSize = 16; // 16x16 tile
    // Scaling for new monitors
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 tile
    // Size of our screen in tiles
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels

    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // As the class implements the runnable
    @Override
    public void run() {

        System.out.println("START GAME THREAD");
        while(gameThread != null) {
            System.out.println("RUNNING THREAD");
        }
    }
}
