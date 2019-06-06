package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider(GameObject master,int width,int height){
        this.position=master.position;
        this.width=width;
        this.height=height;
    }


    public double top(){
        return position.y;
    }

    public double bot(){
        return top()+height;
    }

    public double left(){
        return position.x;
    }

    public double right(){
        return left()+width;
    }


    public boolean intersec(BoxCollider other){
        return other.right() >= this.left()
                && other.left() <= this.right()
                && other.bot() >= this.top()
                && other.top() <= this.bot();
    }

}
