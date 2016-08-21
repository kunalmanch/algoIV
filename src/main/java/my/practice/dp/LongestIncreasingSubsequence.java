package my.practice.dp;

/**
 * Created by kmishra on 8/15/2016.
 */
public class LongestIncreasingSubsequence {

    public static int lis(int[] a) {
        int[] dp = new int[a.length];
        int[] lis = new int[a.length];
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            lis[i] = i;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        lis[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }

        printLIS(a, lis, maxIdx);

        return max;
    }

    private static void printLIS(int[] a, int[] lis, int maxIdx) {
        int i;
        for (i = maxIdx; lis[i] != i; ) {
            System.err.print(a[i] + " ");
            i = lis[i];
        }
        System.err.print(a[i]);
        System.err.println("");
    }

    public static void main(String[] args) {
        int[] a = {10,3,7,9,0,15};
        System.err.println(lis(a));
    }
}
