package my.practice.dp;

/**
 * Created by kmishra on 8/25/2016.
 */
public class PaintCost {

    public static int minCost(int[][] cost, int lo, int hi) {
        int[] dp = new int[hi + 1];
        for (int i = lo + 1; i <= hi; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cost.length; j++ ) {
                if (cost[j][0] < i && i <= cost[j][1] && dp[cost[j][0]] != -1) {
                    min = Math.min(min, dp[cost[j][0]] + cost[j][2]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min;
            }
        }
        return dp[hi];
    }

    public static void main(String[] args) {
        int[][] cost = {
                {0,5,10},
                {0,4,1},
                {0,2,5},
                {2,5,1}
        };
        System.err.println(minCost(cost, 0, 5));
    }
}
