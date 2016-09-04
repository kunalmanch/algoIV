package my.practice.dp;

/**
 * Given a number, find the least number of squares that sum to the number
 */
public class LeastNumofSquares {

    public static int leastNumOfSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.err.println(leastNumOfSquares(11));
    }
}
