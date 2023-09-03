import biuoop.GUI; 
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

public class SimpleGuiExample {

  public void drawRandomCircles() {
    Random rand = new Random(); // create a random-number generator
    // Create a window with the title "Random Circles Example"
    // which is 400 pixels wide and 300 pixels high. 
    GUI gui = new GUI("Breakout", 800, 600);
    
    
    DrawSurface d = gui.getDrawSurface();
    for (int i = 0; i < 10; ++i) {
       int x = rand.nextInt(400) + 1; // get integer in range 1-400
       int y = rand.nextInt(300) + 1; // get integer in range 1-300
       int r = 5*(rand.nextInt(4) + 1); // get integer in 5,10,15,20
       d.setColor(Color.RED);
       d.fillCircle(x,y,r);




    }   
    gui.show(d);
  }


  public static void drawLines(int width, int hight) {
    Random rand = new Random();
    GUI gui = new GUI("breakout", width, hight);
    DrawSurface d = gui.getDrawSurface();
    
    // create lines
    Line[] arrayLines = new Line[10];
    for (int i = 0; i < 10; i++) {
      int x1 = rand.nextInt(width) + 1;
      int y1 = rand.nextInt(hight) + 1;
      int x2 = rand.nextInt(width) + 1;
      int y2 = rand.nextInt(hight) + 1;
      Line l = new Line(x1, y1, x2, y2);
      arrayLines[i] = l;
    }

    // drawLines
    d.setColor(Color.BLACK);
    for (Line l : arrayLines) {
      d.drawLine((int)l.start().x, (int)l.start().y, (int)l.end().x, (int)l.end().y);
    }

    // draw midpoints
    d.setColor(Color.BLUE);
    for (Line l : arrayLines) {
      Point midpoint = l.middle();
      d.fillCircle((int)midpoint.x, (int)midpoint.y, 3);
    }

    // draw intersection
    d.setColor(Color.RED);
    for (int i = 0; i < 10; i++) {
      for (int j = i + 1; j < 10; j++) {
        Point intersectingPoint = arrayLines[i].intersectionWith(arrayLines[j]);
        if (intersectingPoint != null) {
          d.fillCircle((int)intersectingPoint.x, (int)intersectingPoint.y, 3);
        }
      }
    }

    gui.show(d);
  }
  public static void main(String[] args) {
     drawLines(800,600);
  }
}