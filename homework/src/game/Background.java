package game;

import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {
//    BufferedImage image;
//    Vector2D position;
//    vi da ke thua r nen ko can khai bao

    public Background(){
        image = SpriteUtils.loadImage("assets/images/background/0.png");
//        position=new Vector2D(0,600-3109);
        position.set(0,Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
    }

//    public void render(Graphics g){
////        g.drawImage(image,(int)position.x,(int)position.y,null);
////    } da the thua

    @Override //viet de lai ham run trong GameObject
    public void run(){
        if (position.y >= 0) position.y = Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT;
        else position.y += 10;
    }
}
