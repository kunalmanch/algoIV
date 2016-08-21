package my.practice.misc;

/**
 * Created by kmishra on 8/15/2016.
 */
public class GrayCode {

    public static void generate(int n) {
        int m = (int)Math.pow(2, n);
        for (int i = 0; i < m; i++) {
            System.err.println((i >> 1) ^ i);
        }
    }

    public static boolean isConsecutive(int a, int b) {
        return b == (a ^ 1) || b == (a ^ ((a & -a) << 1));
    }

    public static void main(String[] args) {
        generate(3);
        System.err.println(isConsecutive(5,7));
    }
}
