package src;

import biuoop.DrawSurface;
import java.awt.Color;


public class Rectangle implements Sprite {
    public Point upperLeft;
    public int width;
    public int height;

    private int hitsLeft = 0;
    public Color fillColor = Color.WHITE;


    public Rectangle(Point uppperLeft, int width, int height, int hitsLeft) {
        this(uppperLeft, width, height);
        this.hitsLeft = hitsLeft;
    }
    public Rectangle(Point uppperLeft, int width, int height) {
        this.upperLeft = uppperLeft;
        this.width = width;
        this.height = height;
        hitsLeft = 0;
    }

    public void init() {

    }
    
    
    public void update() {

    }

    public void ballCollide() {
        // a func that Ball runs when it hits the block
        fillColor = Color.BLACK;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if (this == Game.blocks[i][j]) {

                    Game.blocks[i][j] = null;
                }
            }
    }

    public void draw(DrawSurface surface) {
        surface.setColor(Color.BLUE);
        surface.drawRectangle((int) upperLeft.x, (int) upperLeft.y, width, height);
        surface.setColor(fillColor);
        surface.fillRectangle((int) upperLeft.x + 1, (int) upperLeft.y + 1, width - 1 ,height - 1);
    }
}
