package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    BufferedImage image;
    Vector2D position;
    public Enemy(){
        image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position = new Vector2D(Mathx.random(0,350),-20);
    }
    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }
    public void run(){
        position.y+=2;
        if(position.y>600) {
            position.set(Mathx.random(0,350),-20);
        }
    }
}
