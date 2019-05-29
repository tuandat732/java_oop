package tklibs;

import java.util.Random;

/**
 * Created by huynq on 5/20/17.
 */
public class Mathx {
    public static double lerp(double a, double b, double f) {
        return a + f * (b - a);
    }

//    /**
//     *
//     * @param origin
//     * @param destination
//     * @param f = currentime / time [0 1]
//     * @return
//     */
//    public static game.Vector2D lerp(game.Vector2D origin, game.Vector2D destination, double f) {
//        return origin.multiply(1  - f).add(destination.multiply(f));
//    }

    public static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
    static Random random = new Random();
    // 0 => bound-1
    public static  int random(int bound){
        return random.nextInt(bound);
    }
    //min => max
    public static int random(int min,int max){
        return min + random.nextInt(max-min+1);
    }
}
