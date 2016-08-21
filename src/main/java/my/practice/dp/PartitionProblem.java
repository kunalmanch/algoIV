package my.practice.dp;

/**
 * Given an array, can it be partitioned into two halves of equal sum.
 */
public class PartitionProblem {

    public static boolean canBePartitioned(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        int p = sum / 2;

        boolean[][] dp = new boolean[p + 1][a.length + 1];

        for (int i = 0; i <= a.length; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= a.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= a[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - a[j - 1]][j - 1];
                }
            }
        }
        return dp[p][a.length];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.err.println(canBePartitioned(a));
    }
}
