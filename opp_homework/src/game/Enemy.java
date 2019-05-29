package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;
    Vector2D position;
    ArrayList<EnemyBullet> bulletss;
    EnemyBullet[] bullets=new EnemyBullet[8];

    public Enemy(){
        image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position = new Vector2D(Mathx.random(0,350),-20);
        bulletss=new ArrayList<>();
    }
    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
        for (int i=0;i<bulletss.size();i++){
            EnemyBullet bullet=bulletss.get(i);
            bullet.render(g);
        }
    }

    public void run(){
        position.y+=2;
        if(position.y>600) {
            position.set(Mathx.random(0,350),-20);
        }
        this.bulletRun();
        this.fire();
        this.move();
    }

    int count=0;
    int[] x={0,50,60,50,0,-50,-60,-50};
    int[] y={-60,-40,0,40,60,40,0,-40};
    public void fire(){
        count++;
        if(count>20){
            for (int i=0;i<8;i++){
                bullets[i]=new EnemyBullet();
                bullets[i].position.set(this.position.x+x[i],this.position.y+y[i]);
                bulletss.add(bullets[i]);
            }
            count=0;
        }
    }

    public void bulletRun(){
        for (int i=0;i<bulletss.size();i++){
            EnemyBullet bullet= bulletss.get(i);
            bullet.run(i%8);
        }
    }
    public void move(){
        for (int i=0;i<bulletss.size();i++){
            EnemyBullet bullet=bulletss.get(i);
            if (bullet.position.x<=1||bullet.position.x>350||bullet.position.y<2||bullet.position.y>600){
                bullet.position.set(0,-10);
            }
            if(this.position.y==-10) bulletss.clear();
        }
    }
}
