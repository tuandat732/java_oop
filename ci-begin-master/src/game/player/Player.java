package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    //private (protected) BufferedImange image;
//    public BufferedImage getImage(){
//        return image;
//    }
//    public void setImage(BufferedImage image){
//        this.image =image;
//    }

    public Player(){
        image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(300,300);
    }

    @Override
    public void render(Graphics g){
//        g.drawImage(image,(int)position.x,(int)position.y,null);
        super.render(g); // g.drawImage() super:ke thua tu cha

    }

    @Override
    public void run(){
        super.run();
        this.move();
        this.limitPosition();
        this.fire();
    }

    int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count>20){
//            PlayerBullet bullet = new PlayerBullet();
//            bullet.position.set(this.position.x,this.position.y);
//            bullet.velocity.setAngle(Math.toRadians(-90));
//
//            PlayerBullet bullet2 = new PlayerBullet();
//            bullet2.position.set(this.position.x-20,this.position.y);
////            bullet2.velocity.set(-1,-5);
//            bullet2.velocity.setAngle(Math.toRadians(-120));
//
//            PlayerBullet bullet3 = new PlayerBullet();
//            bullet3.position.set(this.position.x+20,this.position.y);
////            bullet3.velocity.set(1,-5);
//            bullet3.velocity.setAngle(Math.toRadians(-60));
            double startAngle=-60;
            double endAngle=-120;
            double startX=20;
            double endX=-20;
            int numberBullet=3;
            double stepAngle=Math.abs(endAngle-startAngle)/(numberBullet-1);
            double stepX=Math.abs(endX-startX)/(numberBullet-1);
            for (int i=0;i<numberBullet;i++){
                PlayerBullet bullet=new PlayerBullet();
                bullet.position.set(this.position.x+(startX-stepX*i),this.position.y);
                bullet.velocity.setAngle(Math.toRadians(startAngle-stepAngle*i));
            }

            count=0;
        }
    }


    public void move(){
        //dieu khuyen
        double vx=0;
        double vy=0;
        if(KeyEventPress.isUpPress)
//            position.y-=2;
            vy-=2;
        if(KeyEventPress.isDownPress)
//            position.y+=2;
            vy+=2;
        if(KeyEventPress.isLeftPress)
//            position.x-=2;
            vx-=2;
        if(KeyEventPress.isRightPress)
//            position.x+=2;
            vx+=2;

        velocity.set(vx,vy);
        velocity.setLength(2);
    }

    public void limitPosition(){
        //gioi han
        position.x= Mathx.clamp(position.x,0,384-32);
        position.y= Mathx.clamp(position.y,0,600-48);
    }
}
