package my.practice.matrix;

/**
 * Created by kmishra on 8/15/2016.
 */
public class SpiralMatrix {

    public static int[][] createSpiral(int m, int n) {
        int[][] mat = new int[m][n];
        int count = m * n;
        int val = 1, i = 0, j = 0;
        int rRow = m;
        int rCol = n;
        int lRow = 0;
        int lCol = -1;
        boolean right = true,
                down = false,
                left = false,
                up = false;
        while (val <= count) {
            mat[i][j] = val++;
            if (right) {
                j++;
                if (j == rCol) {
                    right = false;
                    down = true;
                    --j;
                    ++i;
                    --rCol;
                }
            } else if (down) {
                i++;
                if (i == rRow) {
                    down = false;
                    left = true;
                    --i;
                    --j;
                    --rRow;
                }
            } else if (left) {
                j--;
                if (j == lCol) {
                    left = false;
                    up = true;
                    ++j;
                    --i;
                    ++lCol;
                }
            } else if (up) {
                i--;
                if (i == lRow) {
                    up = false;
                    right = true;
                    ++i;
                    ++j;
                    ++lRow;
                }
            }
        }
        return mat;
    }

    public static void print(int[][] mat) {
        for (int[] a : mat) {
            for (int i : a) {
                System.err.print(i + "\t");
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        print(createSpiral(5, 5));
    }
}
