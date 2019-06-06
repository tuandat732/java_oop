package game;

import game.physics.BoxCollider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // quan li doi tuong (static)
    public static ArrayList<GameObject> objects=new ArrayList<>();

    public static <E extends GameObject> E findIntersects(Class<E> cls,BoxCollider hitBox){
        // E ~ Enemy | Player | EnemyBullet|...
        //cls ~ enemy.class | Player.class|...
        //for(GameObject object : objects)
        //object.active
        //object.hitbox != null
        //object.hitbox.intersects(hitbox)
        //object la 1 doi tuong thuoc class cls
        //return object
        //neu ko tim dc object tm return null
        for (int i=0;i<objects.size();i++){
            GameObject object=objects.get(i);
            if(object.active
            &&object.hitBox!=null
            && object.hitBox.intersec(hitBox)
            && cls.isAssignableFrom(object.getClass())){
                return (E) object;
            }
        }
        return null;
    }

    public static void renderAll(Graphics g){
        for (int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            if(object.active)
            object.render(g);
        }
    }

    public static void runAll(){
        for (int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            if(object.active)
            object.run();
        }
    }

    // dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider hitBox; //null
    public boolean active;

    public GameObject(){
        objects.add(this); // add doi tuong vao 1 mang;
        position = new Vector2D(); //(0,0)
        velocity = new Vector2D(); //(0,0)
        active=true;
    }

    public void render(Graphics g){
         if(image!=null){
             g.drawImage(image,(int)position.x,(int)position.y,null);
         }
    }

    public void run(){
        position.add(velocity.x,velocity.y);
    }

    public void deactive(){
        active=false;
    }

    public void reset(){
        active=true;
    }

    public void move(){
        if(position.x<0||position.x>360||position.y<0||position.y>600)
            this.deactive();
    }
}
