package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
//    ArrayList<EnemyBullet> bullets; => da co het trong list object
    public int hp;

    public Enemy(){
        image= SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0,350),-20);
        velocity.set(0,3);
        hitBox=new BoxCollider(this,28,28);
        hp=10;
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
        super.run();
        this.move();
        this.fire();
//        this.bulletsRun();
    }

    public void takeDamege(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive();
        }
    }

    int count=0;
    private void fire() {
        count++;
        if(count>50){
            for (int i=0;i<=Settings.enemyNumberBullet;i++){
                EnemyBullet bullet= new EnemyBullet();
                bullet.position.set(this.position.x+10,this.position.y+40);
                bullet.velocity.setAngle(Math.toRadians(Settings.enemyStartAngle+i*Settings.enemyStepAngle));
            }
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
        if (position.y > 600) {
            position.set(Mathx.random(0, 350), -20);
        }
    }
}
