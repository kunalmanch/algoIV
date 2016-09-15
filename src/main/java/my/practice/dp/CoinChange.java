package my.practice.dp;

/**
 * Created by kmishra on 9/6/2016.
 */
public class CoinChange {

    public static int coinChange(int V, int[] coins) {
        int[] dp = new int[V + 1];

        for (int i  = 1; i <= V; i++) {
            int min = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] == -1) continue;
                    min = Math.min(min, 1 + dp[i - coins[j]]);
                    flag = true;
                }
            }
            dp[i] = flag ? min : -1;
        }
        return dp[V];
    }

    public static void main(String[] args) {
        int[] c = {3,7};
        System.err.println(coinChange(11, c));
    }
}
