/**************************
  *  Compilation:  javac Game.java
  *  Execution:    java Game
  *  Dependencies: Jframe.java, GamePanel.java
  *
  *  Runs Donkey Kong Arcade Game. 
  * 
  * Author: Julian Allende
  *
  *************************/

import javax.swing.*;

public class Game {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Donkey kong");

        GamePanel gamePanel = new GamePanel();
        window.add((gamePanel));

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }

}