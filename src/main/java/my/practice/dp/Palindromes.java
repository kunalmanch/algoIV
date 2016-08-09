package my.practice.dp;

/**
 * Created by kmishra on 8/8/2016.
 */
public class Palindromes {
    /**
     * longest palindromic sub-sequence for an int array.
     */
    public static int lpsq(int[] a) {
        int[][] dp = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= a.length; l++) {
            for (int i = 0; i < a.length - l + 1; i++) {
                int j = i + l - 1;
                if (a[i] == a[j]) {
                    dp[i][j] = l == 2 ? 2 : 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][a.length - 1];
    }

    /**
     * longest palindromic sub-sequence through longest common sub-sequence
     */
    public static int lpsqLCS(int[] a) {
        int[] rev = new int[a.length];
        for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
            rev[i] = a[j];
        }

        int[][] dp = new int[a.length + 1][a.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= rev.length; j++) {
                if (a[i - 1] == rev[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length][a.length];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 1};
        System.err.println(lpsq(a));
        System.err.println(lpsqLCS(a));
    }
}
