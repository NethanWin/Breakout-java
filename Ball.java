import java.awt.Color;
import biuoop.DrawSurface;


public class Ball implements Sprite {
    public double x;
    public double y;
    public int size;
    public static java.awt.Color color;


    public Ball(Point center) {
        x = center.x;
        y = center.y;
        size = 5;
        color = Color.BLUE;
    }


    public void init() {

    }
    
    
    public void update() {

    }


    public void draw(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int)x, (int)y, size);
   
  //    d.drawLine((int)l.start().x, (int)l.start().y, (int)l.end().x, (int)l.end().y);
    }
}