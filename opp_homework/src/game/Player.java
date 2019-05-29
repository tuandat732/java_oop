package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    int m;
    BufferedImage image;
    Vector2D position;
    ArrayList<PlayerBullet> bullets;
    //private (protected) BufferedImange image;
//    public BufferedImage getImage(){
//        return image;
//    }
//    public void setImage(BufferedImage image){
//        this.image =image;
//    }

    public Player(){
        image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position=new Vector2D(300,300);
        bullets = new ArrayList<>();
    }

    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
        for (int i=0;i< bullets.size();i++){
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    public void run(){
        this.move();
        this.limitPosition();
        this.bulletsRun();
        this.fire();
        this.removeBullet();
    }

    int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count>20){
            PlayerBullet bullet2 = new PlayerBullet();
            PlayerBullet bullet1 =new PlayerBullet("assets/images/player-bullets/a/0.png");
            PlayerBullet bullet3 = new PlayerBullet("assets/images/player-bullets/a/2.png");
            bullet2.position.set(this.position.x,this.position.y);
            bullet1.position.set(this.position.x-20,this.position.y-5);
            bullet3.position.set(this.position.x+20,this.position.y-5);
            bullets.add(bullet1);
            bullets.add(bullet2);
            bullets.add(bullet3);
            count=0;
        }
    }

    private void bulletsRun() {
            for (int i = 0; i < bullets.size(); i++) {
                PlayerBullet bullet = bullets.get(i);
                bullet.run((i +1+m) % 3);
            }
    }

    public void move(){
        //dieu khuyen
        if(KeyEventPress.isUpPress)
            position.y-=2;
        if(KeyEventPress.isDownPress)
            position.y+=2;
        if(KeyEventPress.isLeftPress)
            position.x-=2;
        if(KeyEventPress.isRightPress)
            position.x+=2;
    }

    public void limitPosition(){
        //gioi han
        position.x= Mathx.clamp(position.x,0,384-32);
        position.y= Mathx.clamp(position.y,0,600-48);
    }
    public void removeBullet(){
        for (int i=0;i<bullets.size();i++) {
            PlayerBullet bullet = bullets.get(i);
            if (bullet.position.y<=1 || bullet.position.x<0 || bullet.position.x>350) {
                bullets.remove(i);
                m++;
            }
        }
        if(m==3) m=0;
    }
}
