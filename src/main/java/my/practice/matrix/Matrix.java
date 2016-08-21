package my.practice.matrix;

/**
 * Created by kmishra on 8/13/2016.
 */
public class Matrix {

    public static boolean find(int[][] mat, int t) {
        int r = 0, c = mat[0].length - 1;
        while (r < mat.length && c >= 0) {
            if (t == mat[r][c]) return true;
            if (t < mat[r][c]) c--;
            else r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };
        System.err.println(find(mat, 29));
    }
}
