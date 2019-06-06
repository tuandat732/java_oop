package game;

import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 * 1 số phím tắt hay dùng:
 * alt + enter: fix code;
 * (fn)+ shift + f6 : rename
 * ctrl + alt + l: format code
 *
 * Quy tắc đặt tên
 *  class: PlayerBullet (pascal case)
 *  biến/hàm: limitPositionAbc (camel case)
 *  packed: my_game (snake case)
 *
 *  tạo hằng : final + loại(int,float,...) + tên biến(nên viết hoa hết giữa các từ có gạch dưới) = giá trị
 */

public class Program {
//    public static <E> E getSomething(Class<E> cls){
//        // E ~ String| Player|GameObject...
//        // cls ~ String.class| Player.class|...
//        try {
//            return cls.getConstructor().newInstance();
//        } catch (Exception ex){
//            return null;
//        }
//    }
    public static void main(String[] args) {
//        ArrayList<String> strings =new ArrayList<>(); //size=0
        // cac ham hay dung
        //.add()
        //.remove()
        //.get()
        //.size()


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
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.isFirePress=true;
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
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.isFirePress=false;
                }
            }
        });

        //tao panel
        GamePanel panel= new GamePanel();
        window.add(panel); // add panel vaof cua so
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));
        window.pack();
    //set window
        window.setVisible(true);


    //start game
        panel.gameLoop();

    }
}
