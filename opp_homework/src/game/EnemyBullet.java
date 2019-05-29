package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EnemyBullet {
    BufferedImage image;
    Vector2D position;

    public EnemyBullet(){
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        position=new Vector2D();
    }

    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    public void run(int type){
//        if(type<=4) position.setLength(position.getLength()+5);
        if(type==0) position.y-=5;
        else if(type==4) position.y+=5;
        else if(type<4) position.set(this.position.x+5,this.position.y);
        else   position.set(this.position.x-5,this.position.y);
//        position.y+=5;
    }
}
