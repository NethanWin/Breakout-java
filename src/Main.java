package src;

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.util.Random;
import java.awt.Color;

public class Main {

  public static void drawRandomCircles() {
    Random rand = new Random(); // create a random-number generator
    // Create a window with the title "Random Circles Example"
    // which is 400 pixels wide and 300 pixels high. 
    GUI gui = new GUI("Breakout", 800, 600);
    Sleeper sleeper = new Sleeper(); 
    
    
    for (int i = 0; i < 1000; ++i) {
      DrawSurface d = gui.getDrawSurface();
       int x = rand.nextInt(400) + 1; // get integer in range 1-400
       int y = rand.nextInt(300) + 1; // get integer in range 1-300
       int r = 5*(rand.nextInt(4) + 1); // get integer in 5,10,15,20
       d.setColor(Color.RED);
       d.fillCircle(x,y,r);

      sleeper.sleepFor(500);
      gui.show(d);

    }
    
  }
  
  public static void main(String[] args) {
    Game.init();
    while (true) {
      Game.update();
      Game.draw();
    }
  }
}