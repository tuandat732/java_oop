package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.enemy.Enemy;
import game.enemy.EnemyBullet;
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
        position.set(170,500);
    }

//    @Override
//    public void render(Graphics g){
//        super.render(g); // g.drawImage() super:ke thua tu cha
//
//    }

    @Override
    public void run(){
        this.move();
        this.limitPosition();
        this.fire();
    }

    int count=0;
    private void fire() {
        count++;
        if (Settings.isFirePress && count>20){
            PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet1 =new PlayerBullet("assets/images/player-bullets/a/0.png",1);
            PlayerBullet bullet2 =new PlayerBullet("assets/images/player-bullets/a/2.png",2);
            bullet.position.set(this.position.x,this.position.y);
            bullet1.position.set(this.position.x-50,this.position.y+30);
            bullet2.position.set(this.position.x+50,this.position.y+30);
            count=0;
        }
    }


    public void move(){
        //dieu khuyen
        if(Settings.isUpPress)
            position.y-=2;
        if(Settings.isDownPress)
            position.y+=2;
        if(Settings.isLeftPress)
            position.x-=2;
        if(Settings.isRightPress)
            position.x+=2;
    }

    public void limitPosition(){
        //gioi han
        position.x= Mathx.clamp(position.x,0,384-32);
        position.y= Mathx.clamp(position.y,0,600-48);
    }

    public void vacham(){
        Rectangle r1=new Rectangle((int)this.position.x,(int)this.position.y,(int)Settings.PLAYER_WIDTH,(int)Settings.PLAYER_HEIGHT);
        Rectangle r2=new Rectangle((int)Enemy.bullet.position.x,(int)Enemy.bullet.position.y,10,10);
        if(r1.intersects(r2)) objects.remove(this);
    }

}
