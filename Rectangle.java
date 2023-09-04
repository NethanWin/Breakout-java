import java.util.List;
import biuoop.DrawSurface;
import java.awt.Color;


public class Rectangle implements Sprite {
    public Point upperLeft;
    public int width;
    public int height;


    public Rectangle(Point uppperLeft, int width, int height) {
        this.upperLeft = uppperLeft;
        this.width = width;
        this.height = height;
    }


    public void init() {

    }
    
    
    public void update() {

    }


    public void draw(DrawSurface surface) {
        surface.setColor(Color.BLUE);
        surface.drawRectangle((int) upperLeft.x, (int) upperLeft.y, width, height);
        surface.setColor(Color.RED);
        surface.fillRectangle((int) upperLeft.x + 1, (int) upperLeft.y + 1, width - 1 ,height - 1);
        //surface.drawRectangle((int) upperLeft.x, (int) upperLeft.y, 30, 40);
        //surface.fillCircle((int) upperLeft.x, (int) upperLeft.y, 10);
   
    }
}
