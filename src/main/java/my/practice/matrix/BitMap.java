package my.practice.matrix;

/**
 * Created by kmishra on 8/15/2016.
 */
public class BitMap {

    /**
     * Given a bitmap, find the largest size of adjacent 1's.
     */
    public static int largest(int[][] bm) {
        int m = bm.length;
        int n = bm[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bm[i][j] == 1) {
                    max = Math.max(helper(bm, i, j), max);
                }
            }
        }
        return max;
    }

    private static int helper(int[][] bm, int i, int j) {
        int m = bm.length;
        int n = bm[0].length;
        if (i < 0 || i > m - 1) return 0;
        if (j < 0 || j > n - 1) return 0;
        if (bm[i][j] != 1) return 0;

        bm[i][j] = 0;

        bm[i][j] += helper(bm, i + 1, j);
        bm[i][j] += helper(bm, i, j + 1);
        bm[i][j] += helper(bm, i - 1, j);
        bm[i][j] += helper(bm, i, j - 1);

        return ++bm[i][j];
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,0,0,0},
                {1,1,0,1},
                {0,0,0,1},
                {1,1,0,0}
        };
        System.err.println(largest(mat));
    }
}
