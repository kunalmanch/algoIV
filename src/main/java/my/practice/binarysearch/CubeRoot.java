package my.practice.binarysearch;

/**
 * Created by kmishra on 8/30/2016.
 */
public class CubeRoot {

    public static int cubeRoot(int n) {
        boolean negative = n < 0;
        n = Math.abs(n);
        int lo = 1, hi = n / 3 + 1;
        int ans = lo;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int cube = mid * mid * mid;
            if (cube == n) {
                ans = mid;
                break;
            }
            if (cube < n) {
                ans = lo;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return negative ? -1 * ans :  ans;
    }

    public static void main(String[] args) {
        System.err.println(cubeRoot(-27));
    }
}
