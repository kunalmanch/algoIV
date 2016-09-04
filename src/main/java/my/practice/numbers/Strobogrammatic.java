package my.practice.numbers;

import java.util.HashMap;

/**
 * Created by kmishra on 8/22/2016.
 */
public class Strobogrammatic {

    private final static HashMap<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
    }

    public static boolean isStrobogrammatic(int num) {
        int div = 100;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            int l = num / div;
            int r = num % 10;
            if (map.get(l) == null || map.get(l) != r) return false;
            num = (num % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(isStrobogrammatic(8698));
        System.err.println(isStrobogrammatic(878));
    }
}
