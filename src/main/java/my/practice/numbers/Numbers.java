package my.practice.numbers;

/**
 * Created by kmishra on 8/6/2016.
 */
public class Numbers {

    public static int replaceOsWith5s(int num) {
        int div = 1;
        while (num / div >= 10) {
            div *= 10;
        }

        int result = 0;
        while (num > 0) {
            int q = num / div;
            result = result * 10 + (q == 5 ? 0 : q);
            num %= div;
            div /= 10;
        }
        return result;
    }

    public static void printFactors(int n) {
        System.err.println(n + " * 1");
        printFactorshHelper("", n, n);
    }

    private static void printFactorshHelper(String currExp, int dividend, int prevFactor) {
        for (int factor = dividend - 1; factor >= 2; factor--) {
            if (dividend % factor == 0 && factor <= prevFactor) {
                int nextFactor = dividend / factor;
                if (nextFactor <= factor) {
                    System.err.println(currExp + factor + " * " + nextFactor);
                }
                printFactorshHelper(currExp + factor + " * ", nextFactor, factor);
            }
        }
    }

    public static int atoi(String s) {
        int start = 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            start = 1;
            sign = -1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        }
        int num = 0;
        for (int i = start; i < s.length(); i++) {
            char c =s.charAt(i);
            if (!isDigit(c)) throw new RuntimeException("number parsing exception");
            num = num * 10 + (c - '0');
        }
        return num * sign;
    }

    private static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        System.err.println(replaceOsWith5s(1255));
        printFactors(24);
        System.err.println(atoi("-24"));
    }
}
