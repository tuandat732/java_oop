import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 7/4/17.
 * 1 số phím tắt hay dùng:
 * alt + enter: fix code;
 * (fn)+ shift + f6 : rename
 * ctrl + alt + l: format code
 */

public class Program {
    public static void main(String[] args) {
        //tao cua so , an JFrame de import javax.swing, trong cua so se co nhieu ô con, gọi là pamel
        JFrame window =new JFrame();
        window.setTitle("game");
//        window.setSize(800,600); // theo px

        window.setResizable(false); // ko cho resize
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //tat cua so chuong trinh se dung
        // add key nguoi dung
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    KeyEventPress.isUpPress=true;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress=true;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress=true;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress=true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    KeyEventPress.isUpPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress=false;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress=false;
                }
            }
        });

        //tao panel
        GamePanel panel= new GamePanel();
        window.add(panel); // add panel vaof cua so
        panel.setPreferredSize(new Dimension(800,600));
        window.pack();
    //set window
        window.setVisible(true);


    //start game
        panel.gameLoop();

    }
}
