import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel { //extends: ke thua
    BufferedImage playerImage;
//    int playerX;
//    int playerY;
    Vector2D playerPosition;
    BufferedImage backgroundImage;
    BufferedImage bullet;
    BufferedImage enemy;
//    int enemyX= Mathx.random(0,360);
//    int enemyY=50;
    Vector2D enemyPosition;
    Vector2D bulletPosition;
    Vector2D backgroundPosition;
    int i=0;
    double dem=0;
    int xa=1;

    double fps;
    public GamePanel(){ //hamf taoj
        System.out.println("this is gamepanel");
        backgroundImage =SpriteUtils.loadImage("assets/images/background/0.png");
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        bullet = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        enemy=SpriteUtils.loadImage(("assets/images/enemies/level0/black/0.png"));
        fps=0;
        playerPosition=new Vector2D(300,300);
        enemyPosition=new Vector2D(150,Mathx.random(0,360));
        bulletPosition=new Vector2D(150,50);
        backgroundPosition=new Vector2D(0,600-3109);
    }

    @Override
    public void paint(Graphics g) {
        //reset khung anh
        g.setColor(Color.white); //set màu phần tử
        g.fillRect(0,0,800,600);
        //
        g.drawImage(backgroundImage,(int)backgroundPosition.x,(int)backgroundPosition.y,null);
        g.drawImage(playerImage,(int)playerPosition.x,(int)playerPosition.y,null);
        g.drawImage(bullet,(int)bulletPosition.x,(int)bulletPosition.y,null);
        g.drawImage(enemy,(int)enemyPosition.x,(int)enemyPosition.y,null);

        g.setColor(Color.black);
        g.drawString("fps: "+fps,730,20);
    }

    public void runAll() {
        // player run
        if(KeyEventPress.isUpPress){
            playerPosition.y-=3;
        }
        if(KeyEventPress.isDownPress){
            playerPosition.y+=3;
        }
        if(KeyEventPress.isLeftPress){
            playerPosition.x-=3;
        }
        if(KeyEventPress.isRightPress){
            playerPosition.x+=3;
        }
    //background
        if (backgroundPosition.y >= 0) backgroundPosition.y = 600-3109;
        else backgroundPosition.y += 10;
        // gioi han di chuyen player
        playerPosition.x=Mathx.clamp(playerPosition.x,0,384-32);
        playerPosition.y=Mathx.clamp(playerPosition.y,0,600-100);
    // bullet
        dem+=0.001;
        double x=bulletPosition.getLength();
        double ang=bulletPosition.getAngle();
        if(x<10 || ang >= Math.PI/2) xa=-1;
        else if(x>520 || ang <Math.PI/10) xa=1;
        if(xa==-1){
            bulletPosition.setLength(x+dem);
            bulletPosition.setAngle(ang-dem);
        }
        else{
            bulletPosition.setLength(x-dem);
            bulletPosition.setAngle(ang+dem);
        }
        bulletPosition.x=Mathx.clamp(bulletPosition.x,0,384-32);
//        bulletPosition.y=Mathx.clamp(bulletPosition.y,0,500);

    // enemy
        enemy=SpriteUtils.loadImage(("assets/images/enemies/level0/black/"+i/5+ ".png"));
        if(i>40) i=0;
        else i++;
        enemyPosition.y+=2;
        if(enemyPosition.y>600) {
            enemyPosition.set(150,0);
        }
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
