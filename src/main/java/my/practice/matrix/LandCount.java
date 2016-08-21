package my.practice.matrix;

/**
 * Given a matrix of 1s and 0s, countLand the number of contiguous 1s.
 */
public class LandCount {

    public static int countLand(int[][] mat) {
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
        if (i < 0 || i > m - 1) return;
        if (j < 0 || j > n - 1) return;
        if (mat[i][j] != 1) return;

        mat[i][j] = 0;

        helper(mat, i + 1, j);
        helper(mat, i, j + 1);
        helper(mat, i - 1, j);
        helper(mat, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,0,0,0},
                {1,1,0,1},
                {0,0,0,1},
                {1,1,0,0}
        };
        System.err.println(countLand(mat));
    }
}
