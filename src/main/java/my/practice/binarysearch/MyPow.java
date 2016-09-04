package my.practice.binarysearch;

/**
 * Class to return pow(double a, int b).
 */
public class MyPow {

    static double pow(double x, int n) {
        double result = powHelper(x, Math.abs(n));
        return n < 0 ? 1 / result : result;
    }

    private static double powHelper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) return powHelper(x * x, n / 2);
        return x * powHelper(x * x, n / 2);
    }

    static double powNoRec(double x, int n) {
        if (n == 0) return 1;
        boolean isNegative = n < 0;
        n = Math.abs(n);
        int result = 1;
        while (n != 0) {
            if (n % 2 == 1) result *= x;
            x *= x;
            n /= 2;
        }
        return isNegative ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.err.println(pow(2, 4));
        System.err.println(pow(2, 3));
        System.err.println(powNoRec(2, 4));
        System.err.println(powNoRec(2, 3));
        System.err.println(powNoRec(2, 5));
        System.err.println(powNoRec(2, 6));
        System.err.println(powNoRec(2, 7));
        System.err.println(powNoRec(2, 0));
        System.err.println(powNoRec(2, 1));
    }
}
