import java.util.ArrayList;

import javax.swing.DefaultRowSorter;
import biuoop.GUI; 
import biuoop.DrawSurface;
import biuoop.Sleeper;

public class Game {

    public static Sleeper sleeper = new Sleeper();
    public static GUI gui = new GUI("breakout", 800, 600);
    public static DrawSurface surface = gui.getDrawSurface();
    public static Ball ball = new Ball(new Point(400, 400));
    public static Rectangle[][] blocks = new Rectangle[20][20];    
   // public static Rectangle rect = new Rectangle(new Point(1,2), 8, 3);
    

    public static void init() {
        ball.init();
        for (int i = 0; i < Constans.Game.numOfColBlocks; i++) {
           for (int j = 0; j < Constans.Game.numOfRowBlocks; j++) {
                Point p = new Point(j * Constans.Game.screenWidth / Constans.Game.maxBlocksPerRow, i * Constans.Game.screenHeight / Constans.Game.maxBlocksPerCol);
                blocks[i][j] = new Rectangle(p, Constans.Game.screenWidth / Constans.Game.maxBlocksPerRow, Constans.Game.screenHeight / Constans.Game.maxBlocksPerCol);
           }
        }
    }


    public static void update() {
        sleeper.sleepFor(1000/60);
        ball.update();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (blocks[i][j] != null)
                    blocks[i][j].update();

    }


    public static void draw() {
        surface = gui.getDrawSurface();


        surface.fillRectangle(0,0,Constans.Game.screenWidth,Constans.Game.screenHeight);

        ball.draw(surface);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (blocks[i][j] != null) {
                    blocks[i][j].draw(surface);
                }
            }
        }
        gui.show(surface);
    }

    public static void drawBackground() {
//TODO
    }
}
