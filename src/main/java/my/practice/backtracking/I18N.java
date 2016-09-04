package my.practice.backtracking;

/**
 * Created by kmishra on 8/31/2016.
 */
public class I18N {

    public static void print(String s, int i, int j, int[][] dp) {
        if (i >= j) return;
        if (dp[i][j] != 0) return;
        dp[i][j] = 1;
        System.err.println(s.substring(0, i) + (j - i) + s.substring(j));
        print(s, i + 1, j, dp);
        print(s, i, j - 1, dp);
    }

    public static void main(String[] ar) {
        String s = "careercup";
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        print(s, 1, s.length() - 1, dp);
    }
}
