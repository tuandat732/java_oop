package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    int type=0;
    public PlayerBullet(){
        image= SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        type=0;
    }
    public PlayerBullet(String i,int typ){
        image=SpriteUtils.loadImage(i);
        type=typ;
    }
    @Override
    public void run(){
        if(type==0) position.y-=5;
        else if(type==1){
            position.y-=5;
            position.x-=2;
        }
        else{
            position.y-=5;
            position.x+=2;
        }
        this.remove();
    }

    public void remove(){
        if(position.x<0||position.y<0||position.x>350)
            objects.remove(this);
    }
}
