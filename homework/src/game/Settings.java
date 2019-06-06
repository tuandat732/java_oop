package game;

public class Settings {
    //game
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    //player
    public static final int PLAYER_WIDTH = 32;
    public static final int PLAYER_HEIGHT =48;
    //playerbullet
    public static double startAngle=-60;
    public static double endAngle=-120;
    public static double startX=20;
    public static double endX=-20;
    public static int numberBullet=3;
    public static double stepAngle=Math.abs(endAngle-startAngle)/(numberBullet-1);
    public static double stepX=Math.abs(endX-startX)/(numberBullet-1);
    //enemy
    public static double enemyStartAngle=0;
    public static double enemyEndAngle=360;
    public static double enemyStartX=20;
    public static double enemyEndX=-20;
    public static int enemyNumberBullet=12;
    public static double enemyStepAngle=Math.abs(endAngle-startAngle)/(numberBullet-1);
    public static double enemyStepX=Math.abs(endX-startX)/(numberBullet-1);
    //enemybullet
    public static int bulletplus=0;

    //background
    public static final int BACKGROUND_WIDTH=384;
    public static final int BACKGROUND_HEIGHT=3109;
}
