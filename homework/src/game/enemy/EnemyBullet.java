package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    int damege=1;
    public EnemyBullet(){
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
        velocity.set(0,5);
        hitBox= new BoxCollider(this,16,16);
        damege=1;
    }
    int count=0;
    @Override
    public void run(){
        count++;
        super.run();
        super.move();
        this.checkPlayer();
//        if(count==50) {
//            this.fireplus();
//        }
    }

    public void fireplus() {
            for (int i = 0; i <= 5; i++) {
                EnemyBullet bullet = new EnemyBullet();
                bullet.position.set(super.position.x, super.position.y);
                bullet.velocity.setAngle(Math.toRadians(Settings.enemyStartAngle + i * Settings.enemyStepAngle));
            }
    }

    public void checkPlayer(){
        Player player=GameObject.findIntersects(Player.class,this.hitBox);
        if(player!=null){
            this.deactive();
            player.takeDamege(damege);
        }
    }
}
