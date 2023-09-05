package src;

import java.awt.Color;
import biuoop.DrawSurface;


public class Ball implements Sprite {
    public static java.awt.Color color = Color.CYAN;
    public double x;
    public double y;
    public int radius;

    // speed
    public double dx;
    public double dy;

    public Ball(Point center) {
        x = center.x;
        y = center.y;
        dx = -10;
        dy = -10;
        radius = 5;
    }


    public void init() {

    }
    
    
    public void update() {
        // collision with borders
        if (x <= 0 || x >= Constants.Game.screenWidth) {
            dx *= -1;
        }

        if (y <= 0 || y >= Constants.Game.screenHeight) {
            dy *= -1;
        }


        // collision with blocks
        for (int i = 0; i < Constants.Game.numOfColBlocks; i++)
            for (int j = 0; j < Constants.Game.numOfRowBlocks; j++) {
                if (Game.blocks[i][j] != null && isColliding(Game.blocks[i][j])) {


                    if (isHorizontalCollision(Game.blocks[i][j]))
                        dy *= -1;
                    else
                        dx *= -1;
                    Game.blocks[i][j].ballCollide();
                }
            }

        x += dx;
        y += dy;

    }
    public boolean isHorizontalCollision(Rectangle rect) {


        // Check if the right side of rect1 is to the left of the left side of rect2
        boolean leftCollision = x + radius < rect.upperLeft.x;

        // Check if the left side of rect1 is to the right of the right side of rect2
        boolean rightCollision = x > rect.upperLeft.x + rect.width;

        // If both conditions are false, there is a horizontal collision
        return !(leftCollision || rightCollision);

        //return (x < rect.upperLeft.x + rect.width) && (x + radius > rect.upperLeft.x);
    }

    public void draw(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int)x, (int)y, radius);
    }


    public boolean isColliding(Rectangle rect) {
        boolean vertical1 = x + radius > rect.upperLeft.x;
        boolean vertical2 = x < rect.upperLeft.x + rect.width;
        boolean horizontal1 = y + radius > rect.upperLeft.y;
        boolean horizontal2 = y < rect.upperLeft.y + rect.height;
        return vertical1 && vertical2 && horizontal1 && horizontal2;
    }
}