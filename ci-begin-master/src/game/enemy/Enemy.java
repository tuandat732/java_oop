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

    public Enemy(){
        image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0,350),-20);
//        bullets=new ArrayList<>();
    }

//    @Override
//    public void render(Graphics g){
//        super.render(g);
//
//        for (int i=0;i<bullets.size();i++){
//            EnemyBullet bullet=bullets.get(i);
//            bullet.render(g);
//        }
//    }

    @Override
    public void run(){
        this.move();
        this.fire();
//        this.bulletsRun();

    }

    int count=0;
    private void fire() {
        count++;
        if(count>12){
            EnemyBullet bullet=new EnemyBullet();
            bullet.position.set(position.x,position.y);

//            bullets.add(bullet);
            count=0;
        }
    }


//    private void bulletsRun() {
//        for (int i=0;i<bullets.size();i++){
//            EnemyBullet bullet=bullets.get(i);
//            bullet.run();
//        }
//    }

    public void move() {
        position.y += 2;
        if (position.y > 600) {
            position.set(Mathx.random(0, 350), -20);
        }
    }
}
