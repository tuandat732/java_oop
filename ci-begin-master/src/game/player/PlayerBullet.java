package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        image= SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

    @Override
    public void run(){
        position.y-=5;
    }
}
