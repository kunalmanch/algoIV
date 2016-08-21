package my.practice.matrix;

/**
 * Created by kmishra on 8/13/2016.
 */
public class FloodFill {

    public static void floodFill(int[][] mat, int prevC, int newC) {
        int m = mat.length,
                n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == prevC) {
                    floodFillHelper(mat, i, j, prevC, newC);
                }
            }
        }
    }

    private static void floodFillHelper(int[][] mat, int i, int j, int prevC, int newC) {
        int m = mat.length,
                n = mat[0].length;
        if (i < 0 || i > m -1) return;
        if (j < 0 || j > n - 1) return;
        if (mat[i][j] != prevC) return;

        mat[i][j] = newC;

        floodFillHelper(mat, i + 1, j, prevC, newC);
        floodFillHelper(mat, i, j + 1, prevC, newC);
        floodFillHelper(mat, i - 1, j, prevC, newC);
        floodFillHelper(mat, i, j - 1, prevC, newC);
    }

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };

        floodFill(screen, 2, 3);
        for (int[] a : screen) {
            for (int i : a) {
                System.err.print(i + " ");
            }
            System.err.println("");
        }
    }
}
