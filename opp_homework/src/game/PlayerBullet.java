package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
    BufferedImage image;
    Vector2D position;
    public PlayerBullet(){
        image= SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        position = new Vector2D();
    }
    public PlayerBullet(String url){
        this.image=SpriteUtils.loadImage(url);
        this.position= new Vector2D();
    }

    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    public void run(int i){
        if (i==2)
            position.y-=5;
        else if(i==1){
            double len=position.getLength();
            position.setLength(len-5);
        }
        else{
            position.y-=4;
            position.x+=2;
        }
    }
}
