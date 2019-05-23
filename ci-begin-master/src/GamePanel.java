import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel { //extends: ke thua
    BufferedImage playerImage;
    int playerX;
    int playerY;
    int backgroundX;
    int backgroundY;
    BufferedImage backgroundImage;
    BufferedImage bullet;
    BufferedImage enemy;
    int enemyX=150;
    int enemyY=50;
    int bulletX=150;
    int bulletY=50;
    int i=0;
    int xa=1;


    double fps;
    public GamePanel(){ //hamf taoj
        System.out.println("this is gamepanel");
        backgroundImage =SpriteUtils.loadImage("assets/images/background/0.png");
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        bullet = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        enemy=SpriteUtils.loadImage(("assets/images/enemies/level0/black/0.png"));

        fps=0;
        playerX=160;
        playerY=500;
        backgroundX=0;
        backgroundY=-(3109-600);
    }

    @Override
    public void paint(Graphics g) {
        //reset khung anh
        g.setColor(Color.white); //set màu phần tử
        g.fillRect(0,0,800,600);
        //
        g.drawImage(backgroundImage,backgroundX,backgroundY,null);
        g.drawImage(playerImage,playerX,playerY,null);

        g.drawImage(bullet,bulletX,bulletY,null);
        g.drawImage(enemy,enemyX,enemyY,null);

        g.setColor(Color.black);
        g.drawString("fps: "+fps,730,20);
    }

    public void runAll() {
//        playerY++;
        if (backgroundY >= 0) backgroundY = 0;
        else backgroundY += 10;
    // bullet
        if (bulletY < 500)
            bulletY += 2;
        if (bulletX > 350) xa = 1;
        else if (bulletX < 10) xa = -1;
        if (xa == 1) bulletX -= 2;
        else if (xa == -1) bulletX += 2;
    // enemy
        enemy=SpriteUtils.loadImage("assets/images/enemies/level0/black/"+i/5+".png");
        if(i>40) i=0;
        else i++;
        enemyY++;
        if(enemyY>100) enemyY=100;


    }
    //game loop: vong lap game
    public void gameLoop(){
        long lastTime = 0;
        long delay=1000/60;
        while(true){
            long currentTime =System.currentTimeMillis();
            if (currentTime-lastTime>delay){
                fps=1000/(currentTime-lastTime);
                repaint();
                runAll();
                lastTime=currentTime;
            }
        }
    }

}
