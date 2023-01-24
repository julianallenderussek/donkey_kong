import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

// The Game Panel class acts as the screen our game
// This class inherits from JPanel Class
public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    // This is the standard size of a tile in our game (16 pixels is a pretty
    // standard size for 2d games)
    final int originalTileSize = 12; // 16x16 tile

    // Scaling for new monitors
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile

    // Size of our screen in tiles
    final int maxScreenCol = 48;
    final int maxScreenRow = 36;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels

    final int FPS = 60;

    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    final int maxAmountBarrels = 5;

    // Conditionals
    boolean canAddBarrel = true;

    // Conditionals
    boolean canAddEnemy = true;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    CollisionChecker cChecker = new CollisionChecker(this);

    Mario mario = new Mario(this, keyH);
    Kong kong = new Kong(this, keyH);

    // Ladder Tiles
    Ladder l1 = new Ladder(this, keyH, 20, 20);
    Ladder l2 = new Ladder(this, keyH, 20, 30);
    Ladder l3 = new Ladder(this, keyH, 20, 40);

    Ladder[] ladders = { l1, l2, l3 };

    // Ladder Tiles
    Floor f1 = new Floor(this, keyH, 20, 20, "right");
    Floor f2 = new Floor(this, keyH, 20, 30, "right");
    Floor f3 = new Floor(this, keyH, 20, 40, "right");

    Floor[] floors = { f1, f2, f3 };

    // Barrels
    ArrayList<Barrel> barrels = new ArrayList<Barrel>();

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // As the class implements the runnable
    @Override
    public void run() {

        // GAME LOOP
        // This is use to update our loop a fixed amount of times per second, so our
        // game is playable
        double drawInterval = 1000000000 / FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            // UPDATE STATE
            update();

            // DRAW INSTANCES
            // Repaint is also a built-in method
            repaint();

            try {
                double remaningTime = nextDrawTime - System.nanoTime();
                // This converts nano seconds back into seconds
                remaningTime = remaningTime / 1000000;
                if (remaningTime < 0) {
                    remaningTime = 0;
                }
                Thread.sleep((long) remaningTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        mario.update();
        if (barrels.size() < maxAmountBarrels) {
            if (canAddBarrel) {
                System.out.println("STAR WARS");
                canAddBarrel = false;
                CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                    System.out.println("Adding barrel to scene");
                    barrels.add(new Barrel(this, keyH, 300, 300)); 
                    canAddBarrel = true;
                });
            }
        }

        if (barrels.size() > 0) {
            for (int i = 0; i < barrels.size(); i++) {
                Barrel barrel = barrels.get(i);
                barrel.update();
            }
        }

    }

    // Built method of JPanel to draw on screen
    public void paintComponent(Graphics g) {
        // Super is a reference to the parent class of this subclass
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        mario.draw(g2);
        kong.draw(g2);

        for (int i = 0; i < ladders.length; i++) {
            ladders[i].draw(g2);
        }
        ;

        for (int i = 0; i < floors.length; i++) {
            floors[i].draw(g2);
        };

        for (int i = 0; i < barrels.size(); i++) {
            Barrel barrel = barrels.get(i);
            barrel.draw(g2);
        };

        g2.dispose();
    }
}
