package game.player;

import game.GameObject;
import game.Vector2D;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
//    Vector2D velocity;
    public int damege;

    public PlayerBullet(){
        image= SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        velocity=new Vector2D(0,-5);
        hitBox=new BoxCollider(this,24,24);
        damege=1;
    }

    @Override
    public void run() {
        super.run();
        super.move();
        this.checkEnemy();
    }



    private void checkEnemy(){
        Enemy enemy = GameObject.findIntersects(Enemy.class,this.hitBox);
        if(enemy!=null){
            // deactive anemy
            // deactive playerbullet ~ this
           this.deactive();
           enemy.takeDamege(damege);
        }
    }
}
