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

    public static int atoi(String str) {
        if (str.length() == 0) return 0;
        str = str.trim();
        double num = 0;
        int start = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            start = 1;
            sign = -1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isDigit(c)) break;
            num = num * 10 + (c - '0');
        }
        num *= sign;

        return num >= Integer.MAX_VALUE ?
                Integer.MAX_VALUE
                : num <= Integer.MIN_VALUE ?
                    Integer.MIN_VALUE :
                    (int)num;
    }

    /**
     * Test cases :
     *  "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
        "+." => false
        "3.3.3" => false
        "3.567e4" => true
        "3456e.4" => false
        "3000." => false
        "23e" => false
        " 005047e+6" => true
        "32.e-80123" => true
     */
    public static boolean isNumber(String sn) {
        if (sn == null || sn.isEmpty()) return false;
        String s = sn.trim();
        if (s.isEmpty()) return false;

        boolean foundDecimal = false;
        boolean foundE = false;
        boolean digitBeforeE = false;
        boolean digitAfterE = false;
        boolean isNum = false;

        char prev = '\0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '.':
                    if (foundE) return false; //found 'e' before decimal
                    if (foundDecimal) return false; //found another decimal
                    foundDecimal = true;
                    break;
                case 'e':
                    if (foundE) return false; //found another 'e'
                    foundE = true;
                    digitBeforeE = isNum; //is there any digit before 'e'
                    break;
                case '+':
                    if (i != 0 && prev != 'e') return false; //'+' can only be starting character or it can only follow 'e'
                    break;
                case '-':
                    if (i != 0 && prev != 'e') return false; //'-' can only be starting character or it can only follow 'e'
                    break;
                default:
                    if (!isDigit(c)) return false;
                    if (foundE) digitAfterE = true;
                    isNum = true;
            }
            prev = c;
        }
        if (foundE && !(digitAfterE && digitBeforeE)) return false;
        return isNum;
    }

    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static int addAllDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int r = n % 10;
            sum += r;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.err.println(replaceOsWith5s(1255));
        printFactors(24);
//        System.err.println(atoi("-24"));
        System.err.println(isNumber("23e"));
        System.err.println(isNumber("23e3"));
        System.err.println(isNumber("23e3.4"));
        System.err.println(isNumber("23.45e4"));
        System.err.println(isNumber("3.3.3.3"));
        System.err.println(isNumber(" 0.1"));
        System.err.println(isNumber("+."));
        System.err.println(isNumber("3."));
        System.err.println(isNumber("."));
        System.err.println(isNumber("1. 9"));
        System.err.println(isNumber(" 1.9 "));
        System.err.println(isNumber(".e1"));
        System.err.println(isNumber(" 005047e+6"));
        System.err.println(isNumber("32.e-80123"));
        System.err.println(isNumber("e"));
        System.err.println(atoi("9223372036854775809"));
        System.err.println(addAllDigits(123));
    }
}
