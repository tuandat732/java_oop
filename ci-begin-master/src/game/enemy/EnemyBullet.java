package game.enemy;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    public EnemyBullet(){
        image= SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
        velocity.set(0,5);
    }

}
