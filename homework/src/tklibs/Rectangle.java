import game.Vector2D;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle(Vector2D position,int width,int height){
        this.position=position;
        this.width=width;
        this.height=height;
    }

    public Rectangle(double x,double y,int width,int height){
        this(new Vector2D(x,y),width,height);
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


    public boolean intersec(Rectangle other){
//        double len_this =this.position.getLength();
//        double len_other = other.position.getLength();
//        if(len_this<len_other){
//            double ang_this_min=Math.atan(this.position.y/this.position.x+this.width);
//            double ang_this_max=Math.atan(this.position.y+this.height/this.position.x);
//
//        }
        return other.right() >= this.left()
                && other.left() <= this.right()
                && other.bot() >= this.top()
                && other.top() <= this.bot();
    }

//    public static void main(String[] args) {
//        Rectangle r1=new Rectangle(3,3,5,5);
//        Rectangle r2=new Rectangle(4,4,5,5);
//        Rectangle r3=new Rectangle(-3,-3,5,5);
//        System.out.println(r1.intersec(r2));
//        System.out.println(r1.intersec(r3));
//    }
}
