package my.practice.dp;

/**
 * Created by kmishra on 8/22/2016.
 */
public class WiggleWindow {


    public static int wiggleWindow(int[] a) {
        boolean[][] dp = new boolean[a.length][a.length];
        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            dp[i][i + 1] = a[i] - a[i + 1] != 0;
            if (dp[i][i + 1]) {
                max = 2;
            }
        }
        for (int l = 3; l <= a.length; l++) {
            for (int i = 0; i <= a.length - l; i++) {
                int j = i + l - 1;
                if ((a[i] - a[j] == 0 || (a[i] >= 0 && a[j] >= 0) || (a[i] < 0 && a[j] < 0))) {
                    dp[i][j] = dp[i + 1][j] && dp[i][j - 1];
                }
                if (dp[i][j]) {
                    max = l;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,1,0,1,2,1,4};
        System.err.println(wiggleWindow(a));
        int[] b = {0,0,0};
        System.err.println(wiggleWindow(b));
    }
}
