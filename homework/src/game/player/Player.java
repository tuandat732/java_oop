package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
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
    int hp=20;
    public Player(){
        image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(300,300);
        hitBox= new BoxCollider(this,32,48);
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
        super.move();
    }

    int count=0;
    private void fire() {
        count++;
        if (KeyEventPress.isFirePress && count>20){
            for (int i=0;i<Settings.numberBullet;i++){
                PlayerBullet bullet=new PlayerBullet();
                bullet.position.set(this.position.x+(Settings.startX-Settings.stepX*i),this.position.y);
                bullet.velocity.setAngle(Math.toRadians(Settings.startAngle-Settings.stepAngle*i));
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
        if(velocity.x<0)
            for (int i=0;i<=5;i++)
                image=SpriteUtils.loadImage("assets/images/players/left/"+i+".png");
        else if(velocity.x>0)
            for (int i=0;i<=5;i++)
                image=SpriteUtils.loadImage("assets/images/players/right/"+i+".png");
        else
            for (int i=0;i<=6;i++)
                image=SpriteUtils.loadImage("assets/images/players/straight/"+i+".png");
    }

    public void limitPosition(){
        //gioi han
        position.x= Mathx.clamp(position.x,0,384-32);
        position.y= Mathx.clamp(position.y,0,600-48);
    }

    public void takeDamege(int damege){
        hp--;
        if(hp<0){
            hp=0;
            this.deactive();
        }
    }
}
