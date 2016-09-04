package my.practice.matrix;

/**
 * a Toeplitz matrix or diagonal-constant matrix, named after Otto Toeplitz,
 * is a matrix in which each descending diagonal from left to right is constant.
 */
public class Toepliz {

    public static boolean isToepliz(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int val = 0;
//        boolean flag = true;
//        int i = 0, j = 0;
//        for (; i < m && j < n; i++, j++) {
//            if (flag) {
//                val = mat[i][j];
//                flag = false;
//            } else if (val != mat[i][j]) {
//                return false;
//            }
//        }
//        int prevI = 1;
//        i = prevI; j = 0;
//        int c = 0;
//        flag = true;
//        while (c < m - 1) {
//            if (flag) {
//                val = mat[i][j];
//                flag = false;
//            } else if (val != mat[i][j]) {
//                return false;
//            }
//            i++; j++;
//            if (i == m || j == n) {
//                c++;
//                i = ++prevI;
//                j = 0;
//                flag = true;
//            }
//        }
//
//        int prevJ = 1;
//        i = 1; j = prevJ;
//        c = 0;
//        flag = true;
//        while (c < n - 1) {
//            if (flag) {
//                val = mat[i][j];
//                flag = false;
//            } else if (val != mat[i][j]) {
//                return false;
//            }
//            i++; j++;
//            if (i == m || j == n) {
//                c++;
//                i = 0;
//                j = ++prevJ;
//                flag = true;
//            }
//        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (mat[i][j] != mat[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {6,7,8,9,2},
                {4,6,7,8,9},
                {1,4,6,7,8},
                {0,1,4,6,7}
        };
        System.err.println(isToepliz(mat));
    }
}
