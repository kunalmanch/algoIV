package my.practice.numbers;

/**
 * Created by kmishra on 8/21/2016.
 */
public class GCDLCM {

    public static int gcd(int a, int b) {
//        if (b == 0) return a;
//        return gcd(b, a % b);

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        System.err.println(gcd(10, 4));
        System.err.println(gcd(10, 5));
        System.err.println(gcd(5, 10));
        System.err.println(lcm(4, 5));
    }
}
