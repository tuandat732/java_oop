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
        this.move();
        this.limitPosition();
        this.fire();
    }

    int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count>20){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);

            count=0;
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
}
