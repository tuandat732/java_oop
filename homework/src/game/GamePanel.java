package game;

import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel { //extends: ke thua

    Player player;
    Background background;
    BufferedImage bullet;
    Vector2D bulletPosition;
    Enemy enemy;


    double fps;
    public GamePanel(){ //hamf taoj
        background=new Background();
        player=new Player();
        enemy=new Enemy();
        fps=0;
    }

    @Override
    public void paint(Graphics g) {
        //reset khung anh
        g.setColor(Color.white); //set màu phần tử
        g.fillRect(0,0,Settings.GAME_WIDTH,Settings.GAME_HEIGHT);
        //
        GameObject.renderAll(g);

        g.setColor(Color.black);
        g.drawString("fps: "+fps,730,20);
    }

    public void runAll() {
        GameObject.runAll();
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
