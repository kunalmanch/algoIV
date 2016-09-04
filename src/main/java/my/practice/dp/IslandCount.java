package my.practice.dp;

/**
 * Created by kmishra on 8/29/2016.
 */
public class IslandCount {

    public static int islandCount(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    helper(mat, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void helper(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        if (i < 0 || i >= m) return;
        if (j < 0 || j >= n) return;

        if (mat[i][j] == 0) return;

        mat[i][j] = 0;

        helper(mat, i + 1, j);
        helper(mat, i - 1, j);
        helper(mat, i, j + 1);
        helper(mat, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0},
                {1,0,0,1},
                {0,0,1,1},
                {1,0,0,0}
        };
        System.err.println(islandCount(mat));
    }
}
