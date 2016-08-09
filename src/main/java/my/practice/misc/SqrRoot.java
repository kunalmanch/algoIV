package my.practice.misc;

/**
 * Square Root related questions solved with binary search-esque approach.
 */
public class SqrRoot {

    public static int squareRoot(int n) {
        if (n == 0 || n == 1) return n;
        if (n < 0) throw new RuntimeException("sqrt of -ve number is 'i'");
        int lo = 1, hi = (n >> 1) + 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int sq = mid * mid;
            if (sq == n) return mid;
            if (sq < n) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPerfectSquare(int n) {
        if (n == 0 || n == 1) return true;
        if (n < 0) throw new RuntimeException("sqrt of -ve number is 'i'");
        int lo = 1, hi = (n >> 1) + 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int sq = mid * mid;
            if (sq == n) return true;
            if (sq < n) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.err.println(squareRoot(17));
        System.err.println(squareRoot(2));
        System.err.println(isPerfectSquare(17));
        System.err.println(isPerfectSquare(16));
        System.err.println(isPerfectSquare(1));
        System.err.println(isPerfectSquare(2));
    }
}
