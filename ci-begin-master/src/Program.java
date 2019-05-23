import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
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
        window.setSize(800,600); // theo px
        window.setResizable(false); // ko cho resize
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //tat cua so chuong trinh se dung

        //tao panel
        GamePanel panel= new GamePanel();
//        panel.setBackground(Color.CYAN);

        window.add(panel); // add panel vaof cua so
    //set window
        window.setVisible(true);


    //load image
//        BufferedImage playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        System.out.println(playerImage.getWidth());
//        System.out.println(playerImage.getHeight());

    //start game
        panel.gameLoop();

    }
}
