package src;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

public class Game {

    public static Sleeper sleeper = new Sleeper();
    public static GUI gui = new GUI("breakout", Constants.Game.screenWidth, Constants.Game.screenHeight);
    public static DrawSurface surface = gui.getDrawSurface();
    public static Ball ball = new Ball(new Point(400, 400));
    public static Rectangle[][] blocks = new Rectangle[10][10];
   // public static src.Rectangle rect = new src.Rectangle(new src.Point(1,2), 8, 3);
    

    public static void init() {
        ball.init();
        //Point p = new Point(350,300);
        //blocks[0][0] = new Rectangle(p, Constants.Game.screenWidth / Constants.Game.maxBlocksPerRow, Constants.Game.screenHeight / Constants.Game.maxBlocksPerCol);
        for (int i = 0; i < Constants.Game.numOfColBlocks; i++) {
           for (int j = 0; j < Constants.Game.numOfRowBlocks; j++) {
                Point p = new Point(j * Constants.Game.screenWidth / Constants.Game.maxBlocksPerRow, i * Constants.Game.screenHeight / Constants.Game.maxBlocksPerCol);
                blocks[i][j] = new Rectangle(p, Constants.Game.screenWidth / Constants.Game.maxBlocksPerRow, Constants.Game.screenHeight / Constants.Game.maxBlocksPerCol);
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

        drawBackground();
        


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (blocks[i][j] != null) {
                    blocks[i][j].draw(surface);
                }
            }
        }

        ball.draw(surface);
        gui.show(surface);
    }

    public static void drawBackground() {
        surface.setColor(Color.GRAY);
        surface.fillRectangle(0, 0, Constants.Game.screenWidth, Constants.Game.screenHeight);
    }
}
