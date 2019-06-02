package game.enemy;

import game.GameObject;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
//    ArrayList<EnemyBullet> bullets; => da co het trong list object
    public static EnemyBullet bullet;
    public Enemy(){
        image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0,350),-20);
    }

    @Override
    public void run(){
        this.move();
        this.fire();
    }

    int count=0;
    private void fire() {
        count++;
        if(count>12){
            bullet=new EnemyBullet();
            bullet.position.set(position.x,position.y);
            count=0;
        }
    }

    public void move() {
        position.y += 2;
        if (position.y > 600) {
            position.set(Mathx.random(0, 350), -20);
        }
    }
}
