package src;

import biuoop.DrawSurface;


public interface Sprite {
    public void init();
    public void update();
    public void draw(DrawSurface surface);
}
